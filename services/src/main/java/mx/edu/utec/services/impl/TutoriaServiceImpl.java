package mx.edu.utec.services.impl;

import mx.edu.utec.dto.ErrorApp;
import mx.edu.utec.dto.ResponseDTO;
import mx.edu.utec.dto.TutoriaDTO;
import mx.edu.utec.model.*;
import mx.edu.utec.repositories.*;
import mx.edu.utec.services.MailService;
import mx.edu.utec.services.TutoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
@Service
public class TutoriaServiceImpl implements TutoriaService{
    private static final Logger logger = LoggerFactory.getLogger(TutoriaServiceImpl.class);

    @Autowired
    TutoriaRepository tutoriaRepository;

    @Autowired
    PersonalRepository personalRepository;

    @Autowired
    PeriodoAlumnoRepository periodoAlumnoRepository;

    @Autowired
    MailService mailService;

    @Autowired
    SimpleMailMessage templateMessage;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlanTutoriaRepository planTutoriaRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public List<TutoriaDTO> findAllTutoriaByCarreraAndPeriodo(Long idCarrera, Long idPeriodo) {
        Iterator<Tutoria> itTutoria = tutoriaRepository.findAllTutoriaByCarreraAndPeriodo(idCarrera, idPeriodo).iterator();
        List<TutoriaDTO> copy = new ArrayList<TutoriaDTO>();
        while (itTutoria.hasNext()) {
            Tutoria t = itTutoria.next();
            TutoriaDTO dto = convertTutoriaDTO(t);
            copy.add(dto);
        }
        return copy;
    }

    private TutoriaDTO convertTutoriaDTO(Tutoria tutoria) {
        TutoriaDTO dto = new TutoriaDTO();
        dto.setId(tutoria.getId());
        dto.setMatricula(tutoria.getPeriodoAlumno().getAlumno().getMatricula());
        dto.setNombreAlumno(tutoria.getPeriodoAlumno().getAlumno().getNombre() + ' ' + tutoria.getPeriodoAlumno().getAlumno().getApellidoPaterno() + ' ' + tutoria.getPeriodoAlumno().getAlumno().getApellidoMaterno());
        dto.setNombreTutor(tutoria.getTutor().getNombre() + ' ' + tutoria.getTutor().getApellidoPaterno() + ' ' + tutoria.getTutor().getApellidoMaterno());
        return dto;

    }


    @Override
    public void updateDeptoTutoria(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = tutoriaRepository.findOne(tutoriaDTO.getId());
        tutoria.setDepartamento(Departamento.valueOf(tutoriaDTO.getDepartamento()));
        tutoriaRepository.save(tutoria);
    }

    @Override
    public void updateStatusTutoria(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = tutoriaRepository.findOne(tutoriaDTO.getId());
        tutoria.setStatusTutoria(StatusTutoria.valueOf(tutoriaDTO.getStatusTutoria()));
        tutoriaRepository.save(tutoria);
    }

    @Override
    public void updateTutoria(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = tutoriaRepository.findOne(tutoriaDTO.getId());
        tutoria.setStatusTutoria(StatusTutoria.valueOf(tutoriaDTO.getStatusTutoria()));
        tutoria.setDepartamento(Departamento.valueOf(tutoriaDTO.getDepartamento()));
        tutoria.setTipoTutoria(TipoTutoria.valueOf(tutoriaDTO.getTipoTutoria()));
        Tutoria tutoria1 = tutoriaRepository.save(tutoria);

        PlanTutoria planTutoria = planTutoriaRepository.findByTutoria(tutoria1);
        if(planTutoria == null){
            planTutoria = new PlanTutoria();
        }
        planTutoria.setProposito(tutoriaDTO.getProposito());
        planTutoria.setRecomendaciones(tutoriaDTO.getRecomendaciones());
        planTutoria.setMedidas(tutoriaDTO.getMedidas());
        planTutoria.setDiagnostico(tutoriaDTO.getDiagnostico());
        planTutoria.setTutoria(tutoria1);
        planTutoriaRepository.save(planTutoria);
    }

    @Override
    public void updateTutoriaFinalizada(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = tutoriaRepository.findOne(tutoriaDTO.getId());
        tutoria.setStatusTutoria(StatusTutoria.valueOf(tutoriaDTO.getStatusTutoria()));
        Tutoria tutoria1 = tutoriaRepository.save(tutoria);

        PlanTutoria planTutoria = planTutoriaRepository.findByTutoria(tutoria1);
        if(planTutoria == null){
            planTutoria = new PlanTutoria();
        }

        planTutoria.setNota(tutoriaDTO.getNota());
        planTutoriaRepository.save(planTutoria);
    }

    @Override
    public ErrorApp createTutoria(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = convertDTOtoTutoria(tutoriaDTO);
        PeriodoAlumno periodoAlumno =
                periodoAlumnoRepository.findByMatriculaAndPeriodo(tutoriaDTO.getMatricula(), tutoriaDTO.getIdPeriodo());
        Personal tutor =
                personalRepository.findByCarreraAndMatriculaAndPeriodo(
                        tutoriaDTO.getIdPeriodo(), tutoriaDTO.getIdCarrera(),
                        tutoriaDTO.getMatricula());

        if(periodoAlumno == null || tutor == null ||
                (tutor.getId() != tutoriaDTO.getIdCanalizador() && tutoriaDTO.getRol().equals("TUTOR"))){
            return ErrorApp.MATRICULANOTFOUND;
        }
        tutoria.setPeriodoAlumno(periodoAlumno);
        tutoria.setTutor(tutor);
        Tutoria tutoriaSave = this.tutoriaRepository.save(tutoria);

        if(tutoriaDTO.getDiagnostico() != null && !tutoriaDTO.getDiagnostico().isEmpty()){
            PlanTutoria planTutoria = convertDTOtoPlanTutoria(tutoriaDTO);
            planTutoria.setTutoria(tutoriaSave);
            PlanTutoria result = this.planTutoriaRepository.save(planTutoria);
        }

        sendMail(tutoriaDTO.getMatricula(),tutoriaDTO.getIdPeriodo(), tutoriaDTO.getIdCanalizador());
        return ErrorApp.OK;
    }

    private Tutoria convertDTOtoTutoria(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = new Tutoria();
        Personal canalizador = new Personal();
        canalizador.setId(tutoriaDTO.getIdCanalizador());
        tutoria.setDepartamento(Departamento.valueOf(tutoriaDTO.getDepartamento()));
        tutoria.setStatusTutoria(StatusTutoria.valueOf(tutoriaDTO.getStatusTutoria()));
        tutoria.setTipoTutoria(TipoTutoria.valueOf(tutoriaDTO.getTipoTutoria()));
        tutoria.setObservaciones(tutoriaDTO.getObservaciones());
        tutoria.setCanalizador(canalizador);
        tutoria.setFechaInicio(new Date());

        return tutoria;
    }

    private PlanTutoria convertDTOtoPlanTutoria(TutoriaDTO tutoriaDTO) {
        PlanTutoria planTutoria = new PlanTutoria();
        planTutoria.setDiagnostico(tutoriaDTO.getDiagnostico());
        planTutoria.setMedidas(tutoriaDTO.getMedidas());
        planTutoria.setProposito(tutoriaDTO.getProposito());
        planTutoria.setRecomendaciones(tutoriaDTO.getRecomendaciones());

        return planTutoria;
    }

    private void sendMail(String matricula, Long idPeriodo, Long idPersonal){

        Personal personal = new Personal();
        personal.setId(idPersonal);
        String[] correo = new String[3];

        User director = userRepository.findDirectorByMatriculaAndPeriodo(idPeriodo, matricula);
        User psicologo = userRepository.findPsicologoByPeriodo(idPeriodo);
        User tutor = userRepository.findTutorByMatriculaAndPeriodo(idPeriodo, matricula);
        User profesor = userRepository.findByPersonal(personal);
        Alumno alumno = alumnoRepository.findByMatricula(matricula);

        correo[0] = director.getUsername();
        correo[1] = psicologo.getUsername();
        correo[2] = profesor.getUsername();


        logger.info("Enviando correo a " + correo[0] + ' ' + correo[1] + ' ' + correo[2]);
        templateMessage.setTo(tutor.getUsername());
        templateMessage.setCc(correo);

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("tutorName", profesor.getPersonal().getNombre() + ' ' +
                profesor.getPersonal().getApellidoPaterno() + ' ' +
                profesor.getPersonal().getApellidoMaterno());
        props.put("alumnoName", alumno.getNombre() + ' ' +
                alumno.getApellidoPaterno() + ' ' +
                alumno.getApellidoMaterno());

        mailService.send(templateMessage, props);


    }

}

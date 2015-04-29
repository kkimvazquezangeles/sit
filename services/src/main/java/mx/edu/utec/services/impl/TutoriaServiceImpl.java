package mx.edu.utec.services.impl;

import mx.edu.utec.dto.TutoriaDTO;
import mx.edu.utec.model.*;
import mx.edu.utec.repositories.PeriodoAlumnoRepository;
import mx.edu.utec.repositories.PersonalRepository;
import mx.edu.utec.repositories.TutorRepository;
import mx.edu.utec.repositories.TutoriaRepository;
import mx.edu.utec.services.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
@Service
public class TutoriaServiceImpl implements TutoriaService{

    @Autowired
    TutoriaRepository tutoriaRepository;

    @Autowired
    PersonalRepository personalRepository;

    @Autowired
    PeriodoAlumnoRepository periodoAlumnoRepository;

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
    public void updateTutoria(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = tutoriaRepository.findOne(tutoriaDTO.getId());
        tutoria.setDepartamento(Departamento.valueOf(tutoriaDTO.getDepartamento()));
        tutoriaRepository.save(tutoria);
    }


    @Override
    public void createTutoria(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = convertDTOtoTutoria(tutoriaDTO);
        PeriodoAlumno periodoAlumno =
                periodoAlumnoRepository.findByMatriculaAndPeriodo(tutoriaDTO.getMatricula(), tutoriaDTO.getIdPeriodo());
        Personal tutor =
                personalRepository.findByCarreraAndMatriculaAndPeriodo(
                        tutoriaDTO.getIdPeriodo(), tutoriaDTO.getIdCarrera(),
                        tutoriaDTO.getMatricula());
        tutoria.setPeriodoAlumno(periodoAlumno);
        tutoria.setTutor(tutor);
        this.tutoriaRepository.save(tutoria);

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


}

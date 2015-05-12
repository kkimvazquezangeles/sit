package mx.edu.utec.services.impl;

import mx.edu.utec.dto.PersonalDTO;
import mx.edu.utec.dto.TutorDTO;
import mx.edu.utec.model.*;
import mx.edu.utec.repositories.PeriodoPersonalRepository;
import mx.edu.utec.repositories.PersonalRepository;
import mx.edu.utec.repositories.TutorRepository;
import mx.edu.utec.repositories.UserRoleRepository;
import mx.edu.utec.services.PeriodoService;
import mx.edu.utec.services.TutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 16/04/15.
 */
@Service
public class TutorServiceImpl implements TutorService {

    private static final Logger logger = LoggerFactory.getLogger(PlanGrupalServiceImpl.class);

    @Autowired
    TutorRepository tutorRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    PeriodoPersonalRepository periodoPersonalRepository;

    @Override
    public List<TutorDTO> findAllTutoresByCarreraAndPeriodo(Long idCarrera, Long idPeriodo) {
        Iterator<Tutor> itTutor = tutorRepository.findAllByCarreraAndPeriodo(idCarrera, idPeriodo).iterator();
        List<TutorDTO> copy = new ArrayList<TutorDTO>();
        while (itTutor.hasNext()) {
            Tutor tutor = itTutor.next();
            TutorDTO dto = convertTutorToDTO(tutor);
            copy.add(dto);
        }
        return copy;
    }

    private TutorDTO convertTutorToDTO(Tutor tutor) {
        TutorDTO dto = new TutorDTO();
        dto.setId(tutor.getId());
        dto.setIdTutor(tutor.getPeriodoPersonal().getPersonal().getId());
        dto.setNombreCompleto(tutor.getPeriodoPersonal().getPersonal().getNombre() +
                ' ' + tutor.getPeriodoPersonal().getPersonal().getApellidoPaterno() +
                ' ' + tutor.getPeriodoPersonal().getPersonal().getApellidoMaterno());
        dto.setIdCarrera(tutor.getCarrera().getId());
        dto.setCarrera(tutor.getCarrera().getNombreCarrera());
        dto.setIdCuatrimestre(tutor.getCuatrimestre().getId());
        dto.setCuatrimestre(tutor.getCuatrimestre().getCuatrimestre());
        dto.setIdGrupo(tutor.getGrupo().getId());
        dto.setGrupo(tutor.getGrupo().getGrupo());
        return dto;

    }

    @Override
    public TutorDTO findGrupoTutoradoByTutorAndPeriodo(Long idPersonal, Long idPeriodo) {
        Tutor tutor = tutorRepository.findByPersonalAndPeriodo(idPersonal, idPeriodo);
        return convertTutorDTO(tutor);
    }

    private TutorDTO convertTutorDTO(Tutor tutor) {
        TutorDTO dto = new TutorDTO();
        dto.setId(tutor.getId());
        dto.setIdTutor(tutor.getPeriodoPersonal().getPersonal().getId());
        dto.setNombreCompleto(tutor.getPeriodoPersonal().getPersonal().getNombre() +
                ' ' + tutor.getPeriodoPersonal().getPersonal().getApellidoPaterno() +
                ' ' + tutor.getPeriodoPersonal().getPersonal().getApellidoMaterno());
        dto.setIdCarrera(tutor.getCarrera().getId());
        dto.setCarrera(tutor.getCarrera().getNombreCarrera());
        dto.setIdCuatrimestre(tutor.getCuatrimestre().getId());
        dto.setCuatrimestre(tutor.getCuatrimestre().getCuatrimestre());
        dto.setIdGrupo(tutor.getGrupo().getId());
        dto.setGrupo(tutor.getGrupo().getGrupo());
        return dto;

    }

    @Override
    public void createTutor(TutorDTO tutorDTO) {
        this.tutorRepository.save(convertDTOtoTutor(tutorDTO));
        this.createUserTutorRole(tutorDTO);
    }

    private Tutor convertDTOtoTutor(TutorDTO tutorDto) {
        Tutor tutor = new Tutor();

        Carrera carrera = new Carrera();
        carrera.setId(tutorDto.getIdCarrera());
        tutor.setCarrera(carrera);

        Cuatrimestre cuatrimestre = new Cuatrimestre();
        cuatrimestre.setId(tutorDto.getIdCuatrimestre());
        tutor.setCuatrimestre(cuatrimestre);

        Grupo grupo = new Grupo();
        grupo.setId(tutorDto.getIdGrupo());
        tutor.setGrupo(grupo);

        PeriodoPersonal periodoPersonal = new PeriodoPersonal();
        periodoPersonal.setId(tutorDto.getIdPeriodoPersonal());
        tutor.setPeriodoPersonal(periodoPersonal);


        return tutor;
    }

    @Override
    public void deleteTutor(Long idTutor) {
        this.deleteUserTutorRole(idTutor);
        this.tutorRepository.delete(idTutor);

    }

    private void deleteUserTutorRole(Long idTutor) {
        Tutor tutor = this.tutorRepository.findOne(idTutor);
        PeriodoPersonal personal =
                periodoPersonalRepository.findOne(tutor.getPeriodoPersonal().getId());
        User user = new User();
        user.setUsername(personal.getPersonal().getUser().getUsername());
        UserRole userRole = this.userRoleRepository.findOneByUserAndRole(user, "TUTOR");
        this.userRoleRepository.delete(userRole);
    }


    private void createUserTutorRole(TutorDTO tutor) {
        PeriodoPersonal personal =
                periodoPersonalRepository.findOne(tutor.getIdPeriodoPersonal());
        UserRole userRole = new UserRole();
        userRole.setRole("TUTOR");
        userRole.setUser(personal.getPersonal().getUser());

        this.userRoleRepository.save(userRole);
    }
}

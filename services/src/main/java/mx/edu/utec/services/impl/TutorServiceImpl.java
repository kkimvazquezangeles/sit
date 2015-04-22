package mx.edu.utec.services.impl;

import mx.edu.utec.dto.PersonalDTO;
import mx.edu.utec.dto.TutorDTO;
import mx.edu.utec.model.Personal;
import mx.edu.utec.model.Tutor;
import mx.edu.utec.repositories.TutorRepository;
import mx.edu.utec.services.TutorService;
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

    @Autowired
    TutorRepository tutorRepository;

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
    public List<TutorDTO> findGrupoTutoradoByTutorAndPeriodo(Long idPersonal, Long idPeriodo) {
        Iterator<Tutor> itTutor = tutorRepository.findAllByCarreraAndPeriodo(idPersonal, idPeriodo).iterator();
        List<TutorDTO> copy = new ArrayList<TutorDTO>();
        while (itTutor.hasNext()) {
            Tutor tutor = itTutor.next();
            TutorDTO dto = convertTutorDTO(tutor);
            copy.add(dto);
        }
        return copy;
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

}

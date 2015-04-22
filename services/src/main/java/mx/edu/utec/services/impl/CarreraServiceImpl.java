package mx.edu.utec.services.impl;

import mx.edu.utec.dto.CarreraDTO;
import mx.edu.utec.model.Carrera;
import mx.edu.utec.repositories.CarreraRepository;
import mx.edu.utec.repositories.PersonalRepository;
import mx.edu.utec.repositories.TutorRepository;
import mx.edu.utec.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 10/04/15.
 */
@Service
public class CarreraServiceImpl implements CarreraService {
    @Autowired
    CarreraRepository carreraRepository;

    @Autowired
    PersonalRepository personalRepository;

    @Autowired
    private TutorRepository tutorRepository;


    @Override
    public List<CarreraDTO> findAllByPersonalAndPeriodoAndPerfil(Long idPersonal, Long idPeriodo, String perfil) {
        if (perfil.equals("DIRECTOR")) {
            Carrera carreraDir = carreraRepository.findByDirector(idPersonal);

            List<CarreraDTO> copy = new ArrayList<CarreraDTO>();
            copy.add(convertCarreraToDTO(carreraDir));
            return copy;
        }
        Iterator<Carrera> itCarrera = null;

        if (perfil.equals("PSICOLOGO")) {
            itCarrera = carreraRepository.findAllCarrerasByPeriodo(idPeriodo).iterator();
        }

        if (perfil.equals("TUTOR")) {
            itCarrera = carreraRepository.findAllByTutorAndPeriodo(idPersonal, idPeriodo).iterator();
        }

        if (perfil.equals("PROFESOR")) {
            itCarrera = carreraRepository.findAllByPersonalAndPeriodo(idPersonal, idPeriodo).iterator();
        }

        List<CarreraDTO> copy = new ArrayList<CarreraDTO>();
        while (itCarrera.hasNext()) {
            Carrera carrera = itCarrera.next();
            CarreraDTO dto = convertCarreraToDTO(carrera);
            copy.add(dto);
        }
        return copy;

    }

    private CarreraDTO convertCarreraToDTO(Carrera carrera) {
        CarreraDTO dto = new CarreraDTO();
        dto.setId(carrera.getId());
        dto.setCarrera(carrera.getNombreCarrera());
        return dto;
    }
}


package mx.edu.utec.services.impl;

import mx.edu.utec.dto.AlumnoDTO;
import mx.edu.utec.dto.PersonalDTO;
import mx.edu.utec.model.Alumno;
import mx.edu.utec.model.Personal;
import mx.edu.utec.repositories.PersonalRepository;
import mx.edu.utec.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public List<PersonalDTO> findAllProfesorByCarrera(Long idCarrera) {
        Iterator<Personal> itPersonal = personalRepository.findAllProfesorByCarrera(idCarrera).iterator();
        List<PersonalDTO> copy = new ArrayList<PersonalDTO>();
        while (itPersonal.hasNext()) {
            Personal p = itPersonal.next();
            PersonalDTO dto = convertPersonalToDTO(p);
            copy.add(dto);
        }
        return copy;
    }

    private PersonalDTO convertPersonalToDTO(Personal personal) {
        PersonalDTO dto = new PersonalDTO();
        dto.setId(personal.getId());
        dto.setNombreCompleto(personal.getNombre() +
                ' ' + personal.getApellidoPaterno() +
                ' ' + personal.getApellidoMaterno());
        return dto;
    }

}



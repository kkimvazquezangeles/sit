package mx.edu.utec.services.impl;

import mx.edu.utec.dto.PersonalDTO;
import mx.edu.utec.model.PeriodoPersonal;
import mx.edu.utec.repositories.PeriodoPersonalRepository;
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
    PeriodoPersonalRepository periodoPersonalRepository;

    @Override
    public List<PersonalDTO> findAllProfesorByCarrera(Long idCarrera, Long idPeriodo) {
        Iterator<PeriodoPersonal> itPersonal = periodoPersonalRepository.findAllByCarreraAndPeriodo(idCarrera, idPeriodo).iterator();
        List<PersonalDTO> copy = new ArrayList<PersonalDTO>();
        while (itPersonal.hasNext()) {
            PeriodoPersonal p = itPersonal.next();
            PersonalDTO dto = convertPersonalToDTO(p);
            copy.add(dto);
        }
        return copy;
    }

    private PersonalDTO convertPersonalToDTO(PeriodoPersonal periodoPersonal) {
        PersonalDTO dto = new PersonalDTO();
        dto.setId(periodoPersonal.getId());
        dto.setNombreCompleto(periodoPersonal.getPersonal().getNombre() +
                ' ' + periodoPersonal.getPersonal().getApellidoPaterno() +
                ' ' + periodoPersonal.getPersonal().getApellidoMaterno());
        return dto;
    }

}



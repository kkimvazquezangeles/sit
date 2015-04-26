package mx.edu.utec.services;

import mx.edu.utec.dto.PersonalDTO;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */
public interface PersonalService {
    List<PersonalDTO> findAllProfesorByCarrera(Long idCarrera, Long idPeriodo);
}

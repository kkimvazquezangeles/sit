package mx.edu.utec.services.impl;

import mx.edu.utec.dto.PersonalDTO;
import mx.edu.utec.services.PersonalService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */

@Service
public class PersonalServiceImpl implements PersonalService {

    @Override
    public List<PersonalDTO> findAllProfesorByCarrera(Long carrera_id) {
        return null;
    }
}

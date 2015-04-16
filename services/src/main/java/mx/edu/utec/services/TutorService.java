package mx.edu.utec.services;

import mx.edu.utec.dto.TutorDTO;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 16/04/15.
 */
public interface TutorService {
    List<TutorDTO> findAllTutoresByCarreraAndPeriodo(Long idCarrera, Long idPeriodo);
}

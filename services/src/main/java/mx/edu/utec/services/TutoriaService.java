package mx.edu.utec.services;



import mx.edu.utec.dto.TutoriaDTO;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
public interface TutoriaService {
    public List<TutoriaDTO> findAllTutoriaByCarreraAndPeriodo(Long idCarrera, Long idPeriodo);
}
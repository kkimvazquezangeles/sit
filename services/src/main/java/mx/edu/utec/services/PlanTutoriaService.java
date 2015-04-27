package mx.edu.utec.services;

import mx.edu.utec.dto.PlanTutoriaDTO;
import mx.edu.utec.model.PlanTutoria;
import mx.edu.utec.model.Tutoria;

/**
 * Created by kkimvazquezangeles on 26/04/15.
 */
public interface PlanTutoriaService {
    PlanTutoriaDTO findByTutoria(Tutoria tutoria);
}

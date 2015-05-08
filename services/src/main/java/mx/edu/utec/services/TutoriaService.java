package mx.edu.utec.services;



import mx.edu.utec.dto.ErrorApp;
import mx.edu.utec.dto.PlanTutoriaDTO;
import mx.edu.utec.dto.TutoriaDTO;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
public interface TutoriaService {
    public List<TutoriaDTO> findAllTutoriaByCarreraAndPeriodo(Long idCarrera, Long idPeriodo);
    void updateDeptoTutoria(TutoriaDTO tutoriaDTO);
    void updateStatusTutoria(TutoriaDTO tutoriaDTO);
    public void updateTutoria(TutoriaDTO tutoriaDTO);
    public ErrorApp createTutoria(TutoriaDTO tutoriaDTO);

}

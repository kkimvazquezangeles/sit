package mx.edu.utec.services;

import mx.edu.utec.dto.PlanGrupalDTO;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
public interface PlanGrupalService {
    void createPlanGrupal(PlanGrupalDTO planGrupalDTO);
    public PlanGrupalDTO findByPersonalAndPeriodo(Long idPeriodo, Long idPersonal);

}

package mx.edu.utec.services;

import mx.edu.utec.dto.PlanGrupalDTO;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
public interface PlanGrupalService {
    public static int PLAN_GRUPAL_MAX_PLAN_DETALLE = 8;
    void createPlanGrupal(PlanGrupalDTO planGrupalDTO);
    public PlanGrupalDTO findByPersonalAndPeriodo(Long idPeriodo, Long idPersonal);

}

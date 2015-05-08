package mx.edu.utec.services.impl;


import mx.edu.utec.dto.PlanDetalleDTO;
import mx.edu.utec.dto.PlanGrupalDTO;
import mx.edu.utec.model.Mes;
import mx.edu.utec.model.Plan;
import mx.edu.utec.model.PlanDetalle;
import mx.edu.utec.model.Tutor;
import mx.edu.utec.repositories.PlanDetalleGrupalRepository;
import mx.edu.utec.repositories.PlanGrupalRepository;
import mx.edu.utec.repositories.TutorRepository;
import mx.edu.utec.services.PlanGrupalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
@Service
public class PlanGrupalServiceImpl implements PlanGrupalService {

    private static final Logger logger = LoggerFactory.getLogger(PlanGrupalServiceImpl.class);

    @Autowired
    PlanGrupalRepository planGrupalRepository;

    @Autowired
    PlanDetalleGrupalRepository planDetalleGrupalRepository;

    @Autowired
    TutorRepository tutorRepository;

    @Override
    public PlanGrupalDTO findByPersonalAndPeriodo(Long idPeriodo, Long idPersonal) {
        Plan plan = planGrupalRepository.findPlanByPeriodoAndPersonal(idPeriodo, idPersonal);
        PlanGrupalDTO planGrupalDTO = null;
        List<PlanDetalleDTO> actividadesDTO = new ArrayList<>();
        if(plan != null){
            planGrupalDTO = convertPlanToDTO(plan);
            logger.info("TAMAÑOOOOOOOOOOO    " + plan.getActividades().size());
            for(PlanDetalle actividad : plan.getActividades()){
                PlanDetalleDTO planDetalleDTO = convertPlanDetalleToDTO(actividad);
                actividadesDTO.add(planDetalleDTO);
                logger.info("ACTIVIDAAAAAD  " + actividad.getActividad());
            }
        } else {
            planGrupalDTO = new PlanGrupalDTO();
        }
        while (actividadesDTO.size() <= PLAN_GRUPAL_MAX_PLAN_DETALLE){
            actividadesDTO.add(new PlanDetalleDTO());
        }
        planGrupalDTO.setActividades(actividadesDTO);
        return planGrupalDTO;
    }

    private PlanDetalleDTO convertPlanDetalleToDTO(PlanDetalle actividad) {
        PlanDetalleDTO dto = new PlanDetalleDTO();

        dto.setId(actividad.getId());
        dto.setActividad(actividad.getActividad());
        dto.setMes(actividad.getMes().toString());

        return dto;
    }

    private PlanGrupalDTO convertPlanToDTO(Plan plan) {
        PlanGrupalDTO dto = new PlanGrupalDTO();

        dto.setId(plan.getId());
        dto.setMedidas(plan.getMedidas());
        dto.setDiagnostico(plan.getDiagnostico());
        dto.setProposito(plan.getProposito());
        dto.setRecomendaciones(plan.getRecomendaciones());
        dto.setIdTutor(plan.getTutor().getId());
        dto.setIdCuatrimestre(plan.getTutor().getCuatrimestre().getId());
        dto.setIdGrupo(plan.getTutor().getGrupo().getId());

        return dto;
    }

    @Override
    public void createPlanGrupal(PlanGrupalDTO planGrupalDTO) {
        Tutor tutor = tutorRepository.findByPersonalAndPeriodo(planGrupalDTO.getIdTutor(), planGrupalDTO.getIdPeriodo());
        Plan plan = convertDTOtoPlan(planGrupalDTO);
        plan.setTutor(tutor);
        this.planGrupalRepository.save(plan);
        List<PlanDetalleDTO> actividades = planGrupalDTO.getActividades();
        logger.info("TAMAÑOOOOOOOOOOO    " + actividades.size());
        for(PlanDetalleDTO planDetalleDTO : actividades){
            logger.info("planDetalleDTO    " + planDetalleDTO.getActividad());
            PlanDetalle planDetalle = convertDTOtoPlanDetalle(planDetalleDTO);
            planDetalle.setPlan(plan);
            if (planDetalle.getActividad() == null || planDetalle.getActividad().isEmpty()) {
                this.planDetalleGrupalRepository.delete(planDetalle);
            } else {
                this.planDetalleGrupalRepository.save(planDetalle);
            }
        }
    }

    private Plan convertDTOtoPlan(PlanGrupalDTO planGrupalDTO) {
        Plan plan = new Plan();

        if (planGrupalDTO.getId() != null) {
            plan.setId(planGrupalDTO.getId());
        }

        plan.setMedidas(planGrupalDTO.getMedidas());
        plan.setProposito(planGrupalDTO.getProposito());
        plan.setDiagnostico(planGrupalDTO.getDiagnostico());
        plan.setRecomendaciones(planGrupalDTO.getRecomendaciones());

        return plan;
    }

    private PlanDetalle convertDTOtoPlanDetalle(PlanDetalleDTO planDetalleDTO){
        PlanDetalle planDetalle = new PlanDetalle();

        if (planDetalleDTO.getId() != null) {
            logger.info("DETALLE ID ACTIVIDAAAAAAAAA" + planDetalleDTO.getId());
            planDetalle.setId(planDetalleDTO.getId());
        }

        planDetalle.setActividad(planDetalleDTO.getActividad());
        if (planDetalleDTO.getMes() != null && !planDetalleDTO.getMes().isEmpty()) {
            planDetalle.setMes(Mes.valueOf(planDetalleDTO.getMes()));
        }

        return planDetalle;
    }

}

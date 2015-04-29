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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
@Service
public class PlanGrupalServiceImpl implements PlanGrupalService {

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
            for(PlanDetalle actividad : plan.getActividades()){
                PlanDetalleDTO planDetalleDTO = convertPlanDetalleToDTO(actividad);
                actividadesDTO.add(planDetalleDTO);
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

        return dto;
    }


    @Override
    public void createPlanGrupal(PlanGrupalDTO planGrupalDTO) {
        Plan plan = this.planGrupalRepository.save(convertDTOtoPlan(planGrupalDTO));
        Tutor tutor = tutorRepository.findByPersonalAndPeriodo(planGrupalDTO.getIdTutor(), planGrupalDTO.getIdPeriodo());
        plan.setTutor(tutor);
        for(PlanDetalleDTO planDetalleDTO : planGrupalDTO.getActividades()){
            PlanDetalle planDetalle = convertDTOtoPlanDetalle(planDetalleDTO);
            planDetalle.setPlan(plan);
            this.planDetalleGrupalRepository.save(planDetalle);
        }
    }

    private Plan convertDTOtoPlan(PlanGrupalDTO planGrupalDTO) {
        Plan plan = new Plan();

        plan.setMedidas(planGrupalDTO.getMedidas());
        plan.setProposito(planGrupalDTO.getProposito());
        plan.setDiagnostico(planGrupalDTO.getDiagnostico());
        plan.setRecomendaciones(planGrupalDTO.getRecomendaciones());

        return plan;
    }

    private PlanDetalle convertDTOtoPlanDetalle(PlanDetalleDTO planDetalleDTO){
        PlanDetalle planDetalle = new PlanDetalle();

        planDetalle.setActividad(planDetalleDTO.getActividad());
        planDetalle.setMes(Mes.valueOf(planDetalleDTO.getMes()));

        return planDetalle;
    }

}

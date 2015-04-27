package mx.edu.utec.services.impl;

import mx.edu.utec.dto.PlanTutoriaDTO;
import mx.edu.utec.model.PlanTutoria;
import mx.edu.utec.model.Tutoria;
import mx.edu.utec.repositories.PlanTutoriaRepository;
import mx.edu.utec.services.PlanTutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kkimvazquezangeles on 26/04/15.
 */
@Service
public class PlanTutoriaServiceImpl implements PlanTutoriaService {

    @Autowired
    PlanTutoriaRepository planTutoriaRepository;

    @Override
    public PlanTutoriaDTO findByTutoria(Tutoria tutoria) {
        PlanTutoria planTutoria = planTutoriaRepository.findByTutoria(tutoria);
        return convertPlanTutoriaToDTO(planTutoria);
    }

    private PlanTutoriaDTO convertPlanTutoriaToDTO(PlanTutoria planTutoria) {
        PlanTutoriaDTO dto = new PlanTutoriaDTO();
        dto.setId(planTutoria.getId());
        dto.setIdTutoria(planTutoria.getTutoria().getId());
        dto.setStatusTutoria(planTutoria.getTutoria().getStatusTutoria().toString());
        dto.setTipoTutoria(planTutoria.getTutoria().getTipoTutoria().toString());
        dto.setDepartamento(planTutoria.getTutoria().getDepartamento().toString());
        dto.setDiagnostico(planTutoria.getDiagnostico());
        dto.setMedidas(planTutoria.getMedidas());
        dto.setProposito(planTutoria.getProposito());
        dto.setRecomendaciones(planTutoria.getRecomendaciones());
        return dto;
    }
}

package mx.edu.utec.services.impl;

import mx.edu.utec.dto.PlanTutoriaDTO;
import mx.edu.utec.dto.TutoriaDTO;
import mx.edu.utec.model.PlanTutoria;
import mx.edu.utec.model.Tutoria;
import mx.edu.utec.repositories.PlanTutoriaRepository;
import mx.edu.utec.repositories.TutoriaRepository;
import mx.edu.utec.services.PlanTutoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kkimvazquezangeles on 26/04/15.
 */
@Service
public class PlanTutoriaServiceImpl implements PlanTutoriaService {

    private static final Logger logger = LoggerFactory.getLogger(PlanTutoriaServiceImpl.class);

    @Autowired
    TutoriaRepository tutoriaRepository;

    @Autowired
    PlanTutoriaRepository planTutoriaRepository;

    @Override
    public PlanTutoriaDTO findByTutoria(Tutoria tutoria) {
        PlanTutoria planTutoria = planTutoriaRepository.findByTutoria(tutoria);
        if(planTutoria != null){
            return convertPlanTutoriaToDTO(planTutoria);
        } else {
            Tutoria tutoria1 = tutoriaRepository.findOne(tutoria.getId());
            return convertTutoriaToDTO(tutoria1);
        }
    }

    private PlanTutoriaDTO convertTutoriaToDTO(Tutoria tutoria) {
        PlanTutoriaDTO dto = new PlanTutoriaDTO();
        dto.setIdTutoria(tutoria.getId());
        dto.setMatricula(tutoria.getPeriodoAlumno().getAlumno().getMatricula());
        dto.setObservaciones(tutoria.getObservaciones());
        dto.setStatusTutoria(tutoria.getStatusTutoria().toString());
        dto.setTipoTutoria(tutoria.getTipoTutoria().toString());
        dto.setDepartamento(tutoria.getDepartamento().toString());
        return dto;
    }

    private PlanTutoriaDTO convertPlanTutoriaToDTO(PlanTutoria planTutoria) {
        PlanTutoriaDTO dto = new PlanTutoriaDTO();
        dto.setId(planTutoria.getId());
        dto.setIdTutoria(planTutoria.getTutoria().getId());
        dto.setMatricula(planTutoria.getTutoria().getPeriodoAlumno().getAlumno().getMatricula());
        dto.setObservaciones(planTutoria.getTutoria().getObservaciones());
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

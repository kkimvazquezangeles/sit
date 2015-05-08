package mx.edu.utec.controller;


import mx.edu.utec.dto.ErrorApp;
import mx.edu.utec.dto.ResponseDTO;
import mx.edu.utec.dto.TutoriaDTO;
import mx.edu.utec.services.TutoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
@Controller
@RequestMapping("/tutoria")
public class TutoriaController {
    private static final Logger logger = LoggerFactory.getLogger(TutoriaController.class);

    @Autowired
    TutoriaService tutoriaService;

    @ResponseBody
    @RequestMapping(
            value = { "" },
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    public ResponseDTO updateTutoria(@RequestBody Map<String, String> tutoriaMap){
        int tipo = Integer.parseInt(tutoriaMap.get("tipo"));
        ResponseDTO responseDTO = new ResponseDTO();
        TutoriaDTO dto = new TutoriaDTO();

        switch (tipo) {
            case 1:
                dto.setId(Long.valueOf(tutoriaMap.get("id")));
                dto.setDepartamento(tutoriaMap.get("departamento"));
                tutoriaService.updateDeptoTutoria(dto);
                responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
                responseDTO.setMessage("Alumno canalizado al departamento de Psicología.");
                break;
            case 2:
                dto.setId(Long.valueOf(tutoriaMap.get("id")));
                dto.setStatusTutoria(tutoriaMap.get("statusTutoria"));
                tutoriaService.updateStatusTutoria(dto);
                responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
                responseDTO.setMessage("Estatus de la tutoría actualizado correctamente.");
                break;
            case 3:
                dto.setId(Long.valueOf(tutoriaMap.get("id")));
                dto.setStatusTutoria(tutoriaMap.get("statusTutoria"));
                dto.setDepartamento(tutoriaMap.get("departamento"));
                dto.setTipoTutoria(tutoriaMap.get("tipoTutoria"));
                dto.setDiagnostico(tutoriaMap.get("diagnostico"));
                dto.setProposito(tutoriaMap.get("proposito"));
                dto.setMedidas(tutoriaMap.get("medidas"));
                dto.setRecomendaciones(tutoriaMap.get("recomendaciones"));
                tutoriaService.updateTutoria(dto);
                responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
                responseDTO.setMessage("Seguimiento de tutoría actualizado correctamente.");
                break;

        }
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping(
            value = { "" },
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public ResponseDTO createTutoria(@RequestBody TutoriaDTO tutoria) {
        logger.info("Recibe Modelo Diag -------------- " + tutoria.getDiagnostico());
        logger.info("Recibe Modelo ID -------------- " + tutoria.getId());
        logger.info("Recibe Modelo Tipo Tutoria -------------- " + tutoria.getTipoTutoria());
        ResponseDTO responseDTO = new ResponseDTO();
        ErrorApp result = tutoriaService.createTutoria(tutoria);
        if (result == ErrorApp.MATRICULANOTFOUND) {
            responseDTO.setCode(ResponseDTO.CODE_ERROR);
            responseDTO.setMessage("La matricula es inválida.");
        } else if (result == ErrorApp.OK) {
            responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
            responseDTO.setMessage("Tutoría registrada correctamente");
        }

        return responseDTO;
    }


}

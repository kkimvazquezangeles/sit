package mx.edu.utec.controller;


import mx.edu.utec.dto.PlanTutoriaDTO;
import mx.edu.utec.dto.ResponseDTO;
import mx.edu.utec.dto.TutoriaDTO;
import mx.edu.utec.services.TutoriaService;
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

    @Autowired
    TutoriaService tutoriaService;

    @ResponseBody
    @RequestMapping(
            value = { "" },
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    public ResponseDTO updateTutoria(@RequestBody Map<String, String> tutoriaMap){
        TutoriaDTO dto = new TutoriaDTO();
        dto.setId(Long.valueOf(tutoriaMap.get("id")));
        dto.setDepartamento(tutoriaMap.get("departamento"));
        ResponseDTO responseDTO = new ResponseDTO();
        tutoriaService.updateTutoria(dto);
        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage("Alumno canalizado al departamento de Psicología");
        return responseDTO;
    }


}

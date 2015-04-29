package mx.edu.utec.controller;

import mx.edu.utec.dto.PlanGrupalDTO;
import mx.edu.utec.dto.ResponseDTO;
import mx.edu.utec.repositories.PlanGrupalRepository;
import mx.edu.utec.services.PlanGrupalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
@Controller
@RequestMapping("/planGrupal")
public class PlanGrupalController {
    @Autowired
    PlanGrupalService planGrupalService;

    @ResponseBody
    @RequestMapping(
            value = { "" },
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public ResponseDTO createTutor(@RequestBody PlanGrupalDTO plan) {
        ResponseDTO responseDTO = new ResponseDTO();
        planGrupalService.createPlanGrupal(plan);
        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage("Se guardaron cambios en el plan grupal");
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping(
            value = { "" },
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public PlanGrupalDTO findByPersonalAndPeriodo(@RequestParam(value = "periodo") Long idPeriodo, @RequestParam(value = "personal") Long idPersonal) {
        return planGrupalService.findByPersonalAndPeriodo(idPeriodo, idPersonal);
    }
}

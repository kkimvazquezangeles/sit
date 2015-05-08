package mx.edu.utec.controller;

import mx.edu.utec.dto.PlanGrupalDTO;
import mx.edu.utec.dto.ResponseDTO;
import mx.edu.utec.repositories.PlanGrupalRepository;
import mx.edu.utec.services.PlanGrupalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
@Controller
@RequestMapping("/planGrupal")
public class PlanGrupalController {

    private static final Logger logger = LoggerFactory.getLogger(PlanGrupalController.class);

    @Autowired
    PlanGrupalService planGrupalService;

    @RequestMapping(
            value = { "" },
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseDTO createPlanGrupal(@RequestBody PlanGrupalDTO plan) {
        ResponseDTO responseDTO = new ResponseDTO();
        planGrupalService.createPlanGrupal(plan);
        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage("Se guardaron cambios en el plan grupal");
        return responseDTO;
    }

    @RequestMapping(
            value = { "" },
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseDTO updatePlanGrupal(@RequestBody PlanGrupalDTO plan) {
        ResponseDTO responseDTO = new ResponseDTO();
        planGrupalService.createPlanGrupal(plan);
        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage("Se actualizaron datos en el plan grupal");
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

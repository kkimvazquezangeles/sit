package mx.edu.utec.controller;

import mx.edu.utec.dto.PlanTutoriaDTO;
import mx.edu.utec.dto.ResponseDTO;
import mx.edu.utec.dto.TutorDTO;
import mx.edu.utec.model.Tutoria;
import mx.edu.utec.services.PlanTutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kkimvazquezangeles on 26/04/15.
 */
@Controller
@RequestMapping("/planTutoria")
public class PlanTutoriaController {
    @Autowired
    PlanTutoriaService planTutoriaService;

    @ResponseBody
    @RequestMapping(value = { "" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public PlanTutoriaDTO getPlanTutoria(@RequestParam(value = "tutoria") Long idTutoria){
        Tutoria tutoria = new Tutoria();
        tutoria.setId(idTutoria);
        return planTutoriaService.findByTutoria(tutoria);
    }

}

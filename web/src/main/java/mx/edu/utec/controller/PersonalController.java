package mx.edu.utec.controller;

import mx.edu.utec.dto.CuatrimestreDTO;
import mx.edu.utec.dto.PersonalDTO;
import mx.edu.utec.model.Cuatrimestre;
import mx.edu.utec.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */
@Controller
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    PersonalService personalService;

    @ResponseBody
    @RequestMapping(value = { "/carrera/{carrera}" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<PersonalDTO> listProfesorByCarrera(@PathVariable("carrera") Long carrera_id) {
        return personalService.findAllProfesorByCarrera(carrera_id);
    }

}

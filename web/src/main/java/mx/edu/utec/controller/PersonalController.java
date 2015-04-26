package mx.edu.utec.controller;

import mx.edu.utec.dto.CarreraDTO;
import mx.edu.utec.dto.CuatrimestreDTO;
import mx.edu.utec.dto.PersonalDTO;
import mx.edu.utec.model.Carrera;
import mx.edu.utec.model.Cuatrimestre;
import mx.edu.utec.services.CarreraService;
import mx.edu.utec.services.PersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */
@Controller
@RequestMapping("/personal")
public class PersonalController {

    private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);

    @Autowired
    PersonalService personalService;

    @Autowired
    CarreraService carreraService;

    @ResponseBody
    @RequestMapping(
            value = { "/carrera/{carrera}" },
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public List<PersonalDTO> listProfesorByCarrera(
            @PathVariable("carrera") Long carrera_id,
            @RequestParam(value = "periodo") Long periodo) {
        logger.info("carrera_id " + carrera_id);
        logger.info("periodo " + periodo);
        return personalService.findAllProfesorByCarrera(carrera_id, periodo);
    }

    @ResponseBody
    @RequestMapping(
            value = { "/{personal}/carrera" },
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public List<CarreraDTO> listCarreraByPersonalAndPeriodoAndPerfil(
            @PathVariable("personal") Long idPersonal,
            @RequestParam(value = "periodo") Long idPeriodo,
            @RequestParam(value = "perfil") String perfil) {
        return carreraService.findAllByPersonalAndPeriodoAndPerfil(idPersonal, idPeriodo, perfil);
    }
}

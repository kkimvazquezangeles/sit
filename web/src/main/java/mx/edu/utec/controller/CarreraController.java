package mx.edu.utec.controller;

import mx.edu.utec.dto.CuatrimestreDTO;
import mx.edu.utec.dto.GrupoDTO;
import mx.edu.utec.services.CuatrimestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 05/04/15.
 */

@Controller
@RequestMapping("/carrera")
public class CarreraController {
    @Autowired
    CuatrimestreService cuatrimestreService;

    @ResponseBody
    @RequestMapping(value = { "/{carrera}/cuatrimestre" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<CuatrimestreDTO> listCuatrimestreByCarrera(@PathVariable("carrera") Long idCarrera) {
        return cuatrimestreService.findAllCuatrimestreByCarrera(idCarrera);
    }

    @ResponseBody
    @RequestMapping(value = { "/{carrera}/cuatrimestre/{cuatrimestre}/grupo" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<GrupoDTO> listGrupoByCuatrimestre(@PathVariable("carrera") Long idCarrera, @PathVariable("cuatrimestre") Long idCuatrimestre) {
        return cuatrimestreService.findAllGrupoByCuatrimestreAndCarrera(idCarrera, idCuatrimestre);
    }

}

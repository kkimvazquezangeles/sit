package mx.edu.utec.controller;

import mx.edu.utec.dto.CarreraDTO;
import mx.edu.utec.dto.CuatrimestreDTO;
import mx.edu.utec.dto.GrupoDTO;
import mx.edu.utec.dto.TutorDTO;
import mx.edu.utec.services.CarreraService;
import mx.edu.utec.services.CuatrimestreService;
import mx.edu.utec.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 05/04/15.
 */

@Controller
@RequestMapping("/carrera")
public class CarreraController {
    @Autowired
    CuatrimestreService cuatrimestreService;

    @Autowired
    TutorService tutorService;


    @ResponseBody
    @RequestMapping(
            value = { "/{carrera}/cuatrimestre" },
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public List<CuatrimestreDTO> listCuatrimestreByCarrera(
            @PathVariable("carrera") Long idCarrera,
            @RequestParam(value = "periodo") Long idPeriodo) {
        return cuatrimestreService.findAllCuatrimestreByCarrera(idCarrera, idPeriodo);
    }

    @ResponseBody
    @RequestMapping(value = { "/{carrera}/cuatrimestre/{cuatrimestre}/grupo" },
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public List<GrupoDTO> listGrupoByCuatrimestre(
            @PathVariable("carrera") Long idCarrera,
            @PathVariable("cuatrimestre") Long idCuatrimestre,
            @RequestParam(value = "periodo") Long idPeriodo) {
        return cuatrimestreService.findAllGrupoByCuatrimestreAndCarrera(idCarrera, idCuatrimestre, idPeriodo);
    }

    @ResponseBody
    @RequestMapping(
            value = { "/{carrera}/tutor" },
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public List<TutorDTO> listTutoresByCarrera(
            @PathVariable("carrera") Long idCarrera,
            @RequestParam(value = "periodo") Long idPeriodo) {
        return tutorService.findAllTutoresByCarreraAndPeriodo(idCarrera, idPeriodo);
    }

}

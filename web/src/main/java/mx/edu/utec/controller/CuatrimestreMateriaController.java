package mx.edu.utec.controller;

import mx.edu.utec.dto.CuatrimestreMateriaDTO;
import mx.edu.utec.services.CuatrimestreMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 24/04/15.
 */
@Controller
@RequestMapping("/materias")
public class CuatrimestreMateriaController {

    @Autowired
    CuatrimestreMateriaService cuatrimestreMateriaService;

    @ResponseBody
    @RequestMapping(
            value = { "/carrera/{carrera}/cuatrimestre/{cuatrimestre}/grupo/{grupo}" },
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public List<CuatrimestreMateriaDTO> listMateriasByCarreraAndCuatrimestreAndGrupo(
            @PathVariable("carrera") Long idCarrera,
            @PathVariable("cuatrimestre") Long idCuatrimestre,
            @PathVariable("grupo") Long idGrupo,
            @RequestParam(value = "periodo") Long idPeriodo) {
        return cuatrimestreMateriaService.findAllByPeriodoAndCarreraAndCuatrimestreAndGrupo(idPeriodo, idCarrera, idCuatrimestre, idGrupo);
    }

}

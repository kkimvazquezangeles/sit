package mx.edu.utec.controller;

import mx.edu.utec.dto.ResponseDTO;
import mx.edu.utec.dto.TutorDTO;
import mx.edu.utec.dto.TutoriaDTO;
import mx.edu.utec.services.TutorService;
import mx.edu.utec.services.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */

@Controller
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    TutorService tutorService;

    @ResponseBody
    @RequestMapping(value = { "/personal/{personal}" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public TutorDTO findGrupoTutorado(@PathVariable("personal") Long idPersonal, @RequestParam(value = "periodo") Long idPeriodo) {
        return tutorService.findGrupoTutoradoByTutorAndPeriodo(idPersonal, idPeriodo);
    }

    @ResponseBody
    @RequestMapping(
            value = { "/personal/{personal}" },
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public ResponseDTO createTutor(@RequestBody TutorDTO tutor) {
        ResponseDTO responseDTO = new ResponseDTO();
        tutorService.createTutor(tutor);
        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage("Tutor asignado correctamente");
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping(
            value = { "/{tutor}" },
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    public ResponseDTO deleteTutor(@PathVariable("tutor") Long idTutor) {
        ResponseDTO responseDTO = new ResponseDTO();
        tutorService.deleteTutor(idTutor);
        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage("Tutor eliminado correctamente");
        return responseDTO;
    }
}

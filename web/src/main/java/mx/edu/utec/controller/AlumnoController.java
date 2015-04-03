package mx.edu.utec.controller;

import mx.edu.utec.dto.AlumnoDTO;
import mx.edu.utec.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 23/03/15.
 */

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @ResponseBody
    @RequestMapping(value = { "/" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<AlumnoDTO> todosAlumnos() {
        return alumnoService.findAllAlumnos();
    }

    @ResponseBody
    @RequestMapping(value = { "/{matricula}" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public AlumnoDTO getAlumnoMatricula(@PathVariable("matricula") String matricula) {
        return alumnoService.findAlumnobyMatricula(matricula);
    }
}

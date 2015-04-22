package mx.edu.utec.controller;

import mx.edu.utec.dto.TutoriaDTO;
import mx.edu.utec.services.TutorService;
import mx.edu.utec.services.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */

@Controller
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    TutorService tutorService;

}

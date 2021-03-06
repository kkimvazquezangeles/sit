package mx.edu.utec.controller;

import mx.edu.utec.dto.SessionDTO;
import mx.edu.utec.model.EstadoPeriodo;
import mx.edu.utec.model.Periodo;
import mx.edu.utec.services.PeriodoService;
import mx.edu.utec.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Set;

/**
 * Created by kkimvazquezangeles on 07/04/15.
 */
@Controller
@RequestMapping("/session")
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    UserService userService;

    @Autowired
    PeriodoService periodoService;

    @ResponseBody
    @RequestMapping(value = { "/user" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public SessionDTO userAuthenticated() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Periodo periodo = periodoService.findByEstadoPeriodo(EstadoPeriodo.ACTIVO);
        Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        logger.info("Roles del usuario ------> " + roles);
        if (periodo.getId() != null)
            logger.info("Periodo ------> " + periodo.getId());
        SessionDTO sessionDTO = userService.findByUsername(user.getUsername(), periodo.getId(), roles);
        if(periodo != null){
            sessionDTO.setEstadoPeriodo(EstadoPeriodo.ACTIVO.name());
            sessionDTO.setIdPeriodo(periodo.getId().toString());
        } else {
            sessionDTO.setEstadoPeriodo(EstadoPeriodo.DESACTIVO.name());
        }

        return sessionDTO;
    }


}

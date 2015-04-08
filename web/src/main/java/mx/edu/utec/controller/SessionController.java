package mx.edu.utec.controller;

import mx.edu.utec.dto.SessionDTO;
import mx.edu.utec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * Created by kkimvazquezangeles on 07/04/15.
 */
@Controller
@RequestMapping("/session")
public class SessionController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = { "/user" }, method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public SessionDTO userAuthenticated() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SessionDTO sessionDTO = userService.findByUsername(user.getUsername());
        sessionDTO.setRoles(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return sessionDTO;
    }


}

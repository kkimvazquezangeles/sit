package mx.edu.utec.services.impl;

import mx.edu.utec.dto.CarreraDTO;
import mx.edu.utec.dto.SessionDTO;
import mx.edu.utec.model.Periodo;
import mx.edu.utec.model.PeriodoPersonal;
import mx.edu.utec.model.Personal;
import mx.edu.utec.model.User;
import mx.edu.utec.repositories.PeriodoPersonalRepository;
import mx.edu.utec.repositories.UserRepository;
import mx.edu.utec.services.CarreraService;
import mx.edu.utec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 07/04/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarreraService carreraService;

    @Autowired
    PeriodoPersonalRepository periodoPersonalRepository;

    @Override
    public SessionDTO findByUsername(String username, Long idPeriodo, Collection<? extends GrantedAuthority> authorities) {
        SessionDTO dto = convertUserToDTO(userRepository.findByUsername(username));
        dto.setRoles(authorities);
        Periodo periodo = new Periodo();
        periodo.setId(idPeriodo);
        Personal personal = new Personal();
        personal.setId(dto.getId());

        PeriodoPersonal periodoPersonal= periodoPersonalRepository.findByPeriodoAndPersonal(periodo, personal);
        dto.setIdPeriodoPersonal(periodoPersonal.getId());

        List<CarreraDTO> carreras =
                carreraService.findAllByPersonalAndPeriodoAndPerfil(
                        dto.getId(), idPeriodo, rolePrincipal(dto.getRoles()));

        if (carreras.size() > 0){
            CarreraDTO carrera = carreras.get(0);
            dto.setIdCarrera(carrera.getId());
            dto.setCarrera(carrera.getCarrera());
        }
        return dto;
    }

    private SessionDTO convertUserToDTO(User user){
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setId(user.getPersonal().getId());
        sessionDTO.setName(user.getPersonal().getFullName());
        sessionDTO.setUsername(user.getUsername());
        return sessionDTO;
    }

    private String rolePrincipal(Collection<? extends GrantedAuthority> roles){
        Iterator<? extends GrantedAuthority> itr = roles.iterator();
        List<String> rolesList = new ArrayList<String>();
        while (itr.hasNext()){
            rolesList.add(itr.next().getAuthority());
        }

        if(rolesList.contains("DIRECTOR"))
            return "DIRECTOR";

        if(rolesList.contains("TUTOR"))
            return "TUTOR";

        if(rolesList.contains("PROFESOR"))
            return "PROFESOR";

        if(rolesList.contains("PSICOLOGO"))
            return "PSICOLOGO";

        return null;
    }
}

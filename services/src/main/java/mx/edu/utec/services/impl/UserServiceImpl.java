package mx.edu.utec.services.impl;

import mx.edu.utec.dto.CarreraDTO;
import mx.edu.utec.dto.SessionDTO;
import mx.edu.utec.model.User;
import mx.edu.utec.repositories.UserRepository;
import mx.edu.utec.services.CarreraService;
import mx.edu.utec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    @Override
    public SessionDTO findByUsername(String username, Long idPeriodo, Collection<? extends GrantedAuthority> authorities) {
        SessionDTO dto = convertUserToDTO(userRepository.findByUsername(username));
        dto.setRoles(authorities);

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

        if(roles.contains("DIRECTOR"))
            return "DIRECTOR";

        if(roles.contains("TUTOR"))
            return "TUTOR";

        if(roles.contains("PROFESOR"))
            return "PROFESOR";

        if(roles.contains("PSICOLOGO"))
            return "PSICOLOGO";

        return null;
    }
}

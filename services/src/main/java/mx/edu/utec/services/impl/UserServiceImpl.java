package mx.edu.utec.services.impl;

import mx.edu.utec.dto.SessionDTO;
import mx.edu.utec.model.Carrera;
import mx.edu.utec.model.User;
import mx.edu.utec.repositories.CarreraRepository;
import mx.edu.utec.repositories.UserRepository;
import mx.edu.utec.repositories.UserRoleRepository;
import mx.edu.utec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kkimvazquezangeles on 07/04/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public SessionDTO findByUsername(String username) {
        SessionDTO dto = convertUserToDTO(userRepository.findByUsername(username));
        Carrera carrera = carreraRepository.findByDirector(dto.getId());
        if (carrera!=null){
            dto.setIdCarrera(carrera.getId());
            dto.setCarrera(carrera.getNombreCarrera());
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
}

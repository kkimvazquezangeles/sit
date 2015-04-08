package mx.edu.utec.services.impl;

import mx.edu.utec.dto.SessionDTO;
import mx.edu.utec.model.User;
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

    @Override
    public SessionDTO findByUsername(String username) {
        return convertUserToDTO(userRepository.findByUsername(username));
    }

    private SessionDTO convertUserToDTO(User user){
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setId(String.valueOf(user.getPersonal().getId()));
        sessionDTO.setName(user.getPersonal().getFullName());
        sessionDTO.setUsername(user.getUsername());
        return sessionDTO;
    }
}

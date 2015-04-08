package mx.edu.utec.services;

import mx.edu.utec.dto.SessionDTO;

/**
 * Created by kkimvazquezangeles on 07/04/15.
 */
public interface UserService {
    SessionDTO findByUsername(String username);
}

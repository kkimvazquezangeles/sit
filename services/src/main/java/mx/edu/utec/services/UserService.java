package mx.edu.utec.services;

import mx.edu.utec.dto.SessionDTO;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by kkimvazquezangeles on 07/04/15.
 */
public interface UserService {
    SessionDTO findByUsername(String username, Long idPeriodo, Collection<? extends GrantedAuthority> authorities);
}

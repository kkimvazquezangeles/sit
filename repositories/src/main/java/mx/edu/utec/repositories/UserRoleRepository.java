package mx.edu.utec.repositories;

import mx.edu.utec.model.User;
import mx.edu.utec.model.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by betuzo on 27/01/15.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, String> {
    Set<UserRole> findAllByUser(User user);
}
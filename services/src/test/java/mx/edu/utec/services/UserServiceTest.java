package mx.edu.utec.services;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.config.ServicesConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServicesConfig.class, PersistenceConfig.class})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testFindByUsername(){
        Collection<GrantedAuthority> roles = new ArrayList<>();

        GrantedAuthority profesor = new TestAuthority("PROFESOR");
        roles.add(profesor);
        userService.findByUsername("jsoto@utec.edu.mx", 1L, roles);
    }

    private class TestAuthority implements GrantedAuthority {

        private String authority;

        public TestAuthority(String authority){
            this.authority = authority;
        }

        @Override
        public String getAuthority() {
            return authority;
        }

    }

}

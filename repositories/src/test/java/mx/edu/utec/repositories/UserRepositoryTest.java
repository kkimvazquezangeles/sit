package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kkimvazquezangeles on 01/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAllTutoriaByCarreraAndPeriodo(){
        User usuario = userRepository.findDirectorByMatriculaAndPeriodo(1L, "1712100276");
        Assert.assertNotNull(usuario);
    }

    @Test
    public void findPsicologoByPeriodo(){
        User psicologo = userRepository.findPsicologoByPeriodo(1L);
        Assert.assertNotNull(psicologo);
    }

    @Test
    public void findTutorByMatriculaAndPeriodo(){
        User tutor = userRepository.findTutorByMatriculaAndPeriodo(1L, "1712100276");
        Assert.assertNotNull(tutor);
    }
}

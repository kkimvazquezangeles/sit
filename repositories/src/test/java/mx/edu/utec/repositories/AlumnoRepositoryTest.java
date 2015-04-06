package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.Alumno;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class AlumnoRepositoryTest {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Test
    public void testFindByMatricula() {
        Alumno alumno = alumnoRepository.findByMatricula("1712100276");
        Assert.assertNotNull(alumno);
    }
}

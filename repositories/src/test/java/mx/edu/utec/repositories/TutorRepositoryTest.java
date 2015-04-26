package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.Alumno;
import mx.edu.utec.model.Tutor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 16/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class TutorRepositoryTest {
    @Autowired
    TutorRepository tutorRepository;

    @Test
    public void testFindAllByCarreraAndPeriodo(){
        List<Tutor> tutor = tutorRepository.findAllByCarreraAndPeriodo(1L,1L);
        Assert.assertNotNull(tutor);
    }

    @Test
    public void testfindGrupoTutoradoByTutorAndPeriodo(){
        Tutor tutor = tutorRepository.findByPersonalAndPeriodo(3L,1L);
        Assert.assertNotNull(tutor);
    }

}

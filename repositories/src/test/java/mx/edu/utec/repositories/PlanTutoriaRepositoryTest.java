package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.PlanTutoria;
import mx.edu.utec.model.Tutoria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 26/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class PlanTutoriaRepositoryTest {

    @Autowired
    PlanTutoriaRepository planTutoriaRepository;

    @Test
    public void findByTutoria(){
        Tutoria tutoria = new Tutoria();
        tutoria.setId(1L);
        PlanTutoria planTutoria = planTutoriaRepository.findByTutoria(tutoria);
        Assert.assertNotNull(planTutoria);
    }

}

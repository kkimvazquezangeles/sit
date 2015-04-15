package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.Carrera;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 10/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class CarreraRepositoryTest {
    @Autowired
    CarreraRepository carreraRepository;

    @Test
    public void findAllByPersonalAndPeriodo() {
        List<Carrera> carreras = carreraRepository.findAllByPersonalAndPeriodo(1L, 1L);
        Assert.assertNotNull(carreras);
    }

    @Test
    public void findByDirector() {
        Carrera carrera = carreraRepository.findByDirector(1L);
        Assert.assertNotNull(carrera);
    }

}

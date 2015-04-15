package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.EstadoPeriodo;
import mx.edu.utec.model.Periodo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

/**
 * Created by kkimvazquezangeles on 10/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class PeriodoRepositoryTest {
    @Autowired
    PeriodoRepository periodoRepository;

    @Test
    public void testfindByEstadoPeriodo(){
        Periodo periodo = periodoRepository.findByEstadoPeriodo(EstadoPeriodo.ACTIVO);
        Assert.assertNotNull(periodo);
    }
}

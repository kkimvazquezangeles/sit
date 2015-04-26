package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.Periodo;
import mx.edu.utec.model.PeriodoPersonal;
import mx.edu.utec.model.Personal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 25/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class PeriodoPersonalRepositoryTest {

    @Autowired
    PeriodoPersonalRepository periodoPersonalRepository;

    @Test
    public void findByPeriodoAndPersonal() {
        Personal personal = new Personal();
        personal.setId(1L);
        Periodo periodo = new Periodo();
        periodo.setId(1L);
        PeriodoPersonal periodoPersonal= periodoPersonalRepository.findByPeriodoAndPersonal(periodo, personal);
        Assert.assertNotNull(periodoPersonal);
    }

    @Test
    public void findAllByCarreraAndPeriodo() {
        List<PeriodoPersonal> periodoPersonal= periodoPersonalRepository.findAllByCarreraAndPeriodo(1L, 1L);
        Assert.assertNotNull(periodoPersonal);
    }
}

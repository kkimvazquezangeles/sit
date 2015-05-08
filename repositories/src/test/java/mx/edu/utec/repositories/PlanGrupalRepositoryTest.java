package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.Personal;
import mx.edu.utec.model.Plan;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class PlanGrupalRepositoryTest {

    @Autowired
    PlanGrupalRepository planGrupalRepository;

    @Test
    public void testfindPlanByPeriodoAndPersonal() {
        Plan plan = planGrupalRepository.findPlanByPeriodoAndPersonal(1L, 3L);
        Assert.assertNotNull(plan);
    }
}

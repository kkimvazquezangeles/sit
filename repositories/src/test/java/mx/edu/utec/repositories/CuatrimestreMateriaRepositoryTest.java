package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.CuatrimestreMateria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 23/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class CuatrimestreMateriaRepositoryTest {

    @Autowired
    CuatrimestreMateriaRepository cuatrimestreMateriaRepository;

    @Test
    public void findAllByPeriodoAndCarreraAndCuatrimestreAndGrupo() {
        List<CuatrimestreMateria> cuatrimestreMaterias = cuatrimestreMateriaRepository.findAllByPeriodoAndCarreraAndCuatrimestreAndGrupo(1L, 1L, 2L, 2L);
        Assert.assertNotNull(cuatrimestreMaterias);
    }
}

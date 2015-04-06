package mx.edu.utec.repositories;

import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.model.Cuatrimestre;
import mx.edu.utec.model.Grupo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 05/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class GrupoRepositoryTest {
    @Autowired
    GrupoRepository grupoRepository;

    @Test
    public void testFindAllGrupoByCarreraAndCuatrimestre() {
        List<Grupo> grupos = grupoRepository.findAllGrupoByCarreraAndCuatrimestre(1L, 1L);
        Assert.assertNotNull(grupos);
    }
}

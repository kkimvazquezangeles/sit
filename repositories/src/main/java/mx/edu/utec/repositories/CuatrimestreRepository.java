package mx.edu.utec.repositories;

import mx.edu.utec.model.Cuatrimestre;
import mx.edu.utec.model.Grupo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 05/04/15.
 */
public interface CuatrimestreRepository extends CrudRepository<Cuatrimestre, Long> {
    @Query("SELECT distinct gm.cuatrimestre FROM CuatrimestreMateria gm " +
            "WHERE gm.carrera.id = :idCarrera and gm.periodoPersonal.periodo.id = :idPeriodo")
    public List<Cuatrimestre> findAllCuatrimestreByCarrera(@Param("idCarrera") Long idCarrera, @Param("idPeriodo") Long idPeriodo);
    public List<Grupo> findAllGrupoByCuatrimestre(@Param("grupo") Long grupo);

}

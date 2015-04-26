package mx.edu.utec.repositories;



import mx.edu.utec.model.CuatrimestreMateria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
public interface CuatrimestreMateriaRepository extends CrudRepository<CuatrimestreMateria, Long> {
    @Query("SELECT distinct cm FROM CuatrimestreMateria cm WHERE cm.periodoPersonal.periodo.id =:idPeriodo and " +
            " cm.carrera.id =:idCarrera and cm.cuatrimestre.id =:idCuatrimestre and cm.grupo.id =:idGrupo")
    List<CuatrimestreMateria> findAllByPeriodoAndCarreraAndCuatrimestreAndGrupo(@Param("idPeriodo") Long idPeriodo, @Param("idCarrera") Long idCarrera, @Param("idCuatrimestre") Long idCuatrimestre, @Param("idGrupo") Long idGrupo);


}


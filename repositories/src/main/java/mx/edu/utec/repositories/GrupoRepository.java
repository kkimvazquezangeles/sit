package mx.edu.utec.repositories;

import mx.edu.utec.model.Carrera;
import mx.edu.utec.model.Cuatrimestre;
import mx.edu.utec.model.Grupo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 05/04/15.
 */
public interface GrupoRepository extends CrudRepository<Grupo, Long> {

    @Query("SELECT distinct gm.grupo FROM CuatrimestreMateria gm " +
            "WHERE gm.carrera.id = :idCarrera AND gm.cuatrimestre.id = :idCuatrimestre ")
    public List<Grupo> findAllGrupoByCarreraAndCuatrimestre(@Param("idCarrera") Long idCarrera, @Param("idCuatrimestre") Long idCuatrimestre);
}

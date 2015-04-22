package mx.edu.utec.repositories;

import mx.edu.utec.model.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 10/04/15.
 */
public interface CarreraRepository extends CrudRepository<Carrera, Long> {
    @Query("SELECT distinct gm.carrera FROM CuatrimestreMateria gm " +
            "WHERE gm.periodoPersonal.personal.id = :idPersonal AND gm.periodoPersonal.id = :idPeriodo")
    List<Carrera> findAllByPersonalAndPeriodo(@Param("idPersonal") Long idPersonal, @Param("idPeriodo") Long idPeriodo);

    @Query("SELECT d.carrera FROM Director d " +
            "WHERE d.periodoPersonal.personal.id = :idDirector")
    Carrera findByDirector(@Param("idDirector") Long idDirector);

    @Query("SELECT distinct gm.carrera FROM CuatrimestreMateria gm " +
            "WHERE gm.periodoPersonal.periodo.id = :idPeriodo")
    List<Carrera> findAllCarrerasByPeriodo(@Param("idPeriodo") Long idPeriodo);

    @Query("SELECT distinct tu.carrera FROM Tutor tu" +
            " WHERE tu.periodoPersonal.periodo.id = :idPeriodo AND tu.periodoPersonal.personal.id = :idPersonal")
    List<Carrera> findAllByTutorAndPeriodo(
            @Param("idPersonal") Long idPersonal,
            @Param("idPeriodo") Long idPeriodo);
}

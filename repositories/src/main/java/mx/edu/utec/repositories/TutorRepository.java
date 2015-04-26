package mx.edu.utec.repositories;

import mx.edu.utec.model.Tutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 16/04/15.
 */
public interface TutorRepository extends CrudRepository<Tutor, Long> {
    @Query("SELECT tu FROM Tutor tu" +
            " WHERE tu.periodoPersonal.periodo.id = :idPeriodo AND tu.carrera.id = :idCarrera")
    List<Tutor> findAllByCarreraAndPeriodo(
            @Param("idCarrera") Long idCarrera,
            @Param("idPeriodo") Long idPeriodo);

    @Query("SELECT tu FROM Tutor tu" +
            " WHERE tu.periodoPersonal.periodo.id = :idPeriodo AND tu.periodoPersonal.personal.id = :idPersonal")
    Tutor findByPersonalAndPeriodo(
            @Param("idPersonal") Long idPersonal,
            @Param("idPeriodo") Long idPeriodo);
}

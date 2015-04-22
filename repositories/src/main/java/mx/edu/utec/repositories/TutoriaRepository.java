package mx.edu.utec.repositories;

import mx.edu.utec.model.Grupo;
import mx.edu.utec.model.Tutoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 21/04/15.
 */

public interface TutoriaRepository extends CrudRepository<Tutoria, Long> {
    @Query("SELECT tt " +
            "FROM Tutoria tt " +
            "WHERE tt.periodoAlumno.alumno.carrera.id = :idCarrera and tt.periodoAlumno.periodo.id = :idPeriodo")
    public List<Tutoria> findAllTutoriaByCarreraAndPeriodo(
            @Param("idCarrera") Long idCarrera,
            @Param("idPeriodo") Long idPeriodo);
}


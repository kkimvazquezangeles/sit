package mx.edu.utec.repositories;

import mx.edu.utec.model.PeriodoAlumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
public interface PeriodoAlumnoRepository extends CrudRepository<PeriodoAlumno, Long> {
    @Query("SELECT pa FROM PeriodoAlumno pa " +
            "WHERE pa.alumno.matricula = :matricula AND" +
            " pa.periodo.id = :idPeriodo")
    PeriodoAlumno findByMatriculaAndPeriodo(@Param("matricula") String matricula,
                                            @Param("idPeriodo") Long idPeriodo);

}

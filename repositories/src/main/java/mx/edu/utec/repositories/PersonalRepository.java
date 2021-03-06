package mx.edu.utec.repositories;

import mx.edu.utec.model.Personal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */
public interface PersonalRepository extends CrudRepository<Personal, Long> {
    @Query("SELECT distinct gm.periodoPersonal.personal FROM CuatrimestreMateria gm " +
            "WHERE " +
            "gm.carrera.id = :idCarrera and " +
            "gm.periodoPersonal.personal.id in ( " +
                "SELECT ur.user.personal.id FROM UserRole ur " +
                "WHERE ur.role = 'PROFESOR' " +
                ") and " +
            "gm.periodoPersonal.id not in (SELECT tu.periodoPersonal.id from Tutor tu)")
    public List<Personal> findAllProfesorByCarrera(@Param("idCarrera") Long idCarrera);

    @Query("SELECT tu.periodoPersonal.personal FROM Tutor tu" +
            " WHERE tu.periodoPersonal.periodo.id = :idPeriodo AND" +
            " tu.carrera.id = :idCarrera AND" +
            " tu.grupo in (SELECT pa.grupo FROM PeriodoAlumno pa WHERE" +
            " pa.alumno.matricula = :matricula AND" +
            " pa.periodo.id = :idPeriodo) AND " +
            " tu.cuatrimestre in (SELECT pa.cuatrimestre FROM PeriodoAlumno pa WHERE" +
            " pa.alumno.matricula = :matricula AND" +
            " pa.periodo.id = :idPeriodo)")
    Personal findByCarreraAndMatriculaAndPeriodo(
            @Param("idPeriodo") Long idPeriodo,
            @Param("idCarrera") Long idCarrera,
            @Param("matricula") String matricula);
}

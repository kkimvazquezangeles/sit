package mx.edu.utec.repositories;

import mx.edu.utec.model.Personal;
import mx.edu.utec.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by betuzo on 25/01/15.
 */
public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);

    @Query("SELECT d.periodoPersonal.personal.user FROM Director d " +
            "WHERE d.periodoPersonal.periodo.id = :idPeriodo and " +
            "d.carrera.id in (select a.carrera.id from Alumno a where a.matricula = :matricula)")
    public User findDirectorByMatriculaAndPeriodo(
            @Param("idPeriodo") Long idPeriodo, @Param("matricula") String matricula);

    @Query("SELECT pp.personal.user FROM PeriodoPersonal pp " +
            "WHERE pp.periodo.id = :idPeriodo and " +
            "pp.personal.user.username in (select ur.user.username from UserRole ur where ur.role = 'PSICOLOGO')")
    public User findPsicologoByPeriodo(@Param("idPeriodo") Long idPeriodo);

    @Query("SELECT t.periodoPersonal.personal.user FROM Tutor t " +
            "WHERE t.periodoPersonal.periodo.id = :idPeriodo and " +
            "t.carrera.id in (select a.carrera.id from Alumno a where a.matricula = :matricula) and " +
            "t.grupo.id in (select pa.grupo.id from PeriodoAlumno pa where pa.periodo.id = :idPeriodo " +
                "and pa.alumno.matricula = :matricula) and " +
            "t.cuatrimestre.id in (select pa.cuatrimestre.id from PeriodoAlumno pa where pa.periodo.id = :idPeriodo " +
                "and pa.alumno.matricula = :matricula)")
    public User findTutorByMatriculaAndPeriodo(
            @Param("idPeriodo") Long idPeriodo, @Param("matricula") String matricula);

    User findByPersonal(Personal personal);

}

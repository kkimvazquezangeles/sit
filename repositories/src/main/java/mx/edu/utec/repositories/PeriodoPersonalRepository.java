package mx.edu.utec.repositories;

import mx.edu.utec.model.Periodo;
import mx.edu.utec.model.PeriodoPersonal;
import mx.edu.utec.model.Personal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 25/04/15.
 */
public interface PeriodoPersonalRepository extends CrudRepository<PeriodoPersonal, Long> {

    PeriodoPersonal findByPeriodoAndPersonal(Periodo periodo, Personal personal);

    @Query("SELECT distinct gm.periodoPersonal FROM CuatrimestreMateria gm " +
            "WHERE " +
            "gm.carrera.id = :idCarrera and " +
            "gm.periodoPersonal.periodo.id = :idPeriodo and " +
            "gm.periodoPersonal.personal.id in ( " +
            "SELECT ur.user.personal.id FROM UserRole ur " +
            "WHERE ur.role = 'PROFESOR' " +
            ") and " +
            "gm.periodoPersonal.id not in (SELECT tu.periodoPersonal.id from Tutor tu)")
    public List<PeriodoPersonal> findAllByCarreraAndPeriodo(@Param("idCarrera") Long idCarrera, @Param("idPeriodo") Long idPeriodo);
}

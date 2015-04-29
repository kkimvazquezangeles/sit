package mx.edu.utec.repositories;

import mx.edu.utec.model.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
public interface PlanGrupalRepository extends CrudRepository<Plan, Long> {
    @Query("SELECT p FROM Plan p " +
            "WHERE p.tutor.periodoPersonal.periodo.id = :idPeriodo and " +
            "p.tutor.periodoPersonal.personal.id = :idPersonal")
    public Plan findPlanByPeriodoAndPersonal(@Param("idPeriodo") Long idPeriodo, @Param("idPersonal") Long idPersonal);
}

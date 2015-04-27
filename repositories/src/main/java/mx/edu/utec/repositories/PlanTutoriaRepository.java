package mx.edu.utec.repositories;

import mx.edu.utec.model.PlanTutoria;
import mx.edu.utec.model.Tutoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 26/04/15.
 */
public interface PlanTutoriaRepository extends CrudRepository<PlanTutoria, Long> {
    PlanTutoria findByTutoria(Tutoria tutoria);
}

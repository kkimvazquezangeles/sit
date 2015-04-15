package mx.edu.utec.repositories;

import mx.edu.utec.model.Director;
import mx.edu.utec.model.PeriodoPersonal;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kkimvazquezangeles on 12/04/15.
 */
public interface DirectorRepository extends CrudRepository<Director, Long> {
    public Director findByPeriodoPersonal(PeriodoPersonal periodoPersonal);
}

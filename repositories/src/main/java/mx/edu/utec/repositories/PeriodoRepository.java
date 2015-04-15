package mx.edu.utec.repositories;

import mx.edu.utec.model.EstadoPeriodo;
import mx.edu.utec.model.Periodo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kkimvazquezangeles on 10/04/15.
 */
public interface PeriodoRepository extends CrudRepository<Periodo, Long> {
    Periodo findByEstadoPeriodo(EstadoPeriodo estadoPeriodo);
}

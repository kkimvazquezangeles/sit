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
    @Query("SELECT gm.periodoPersonal.personal FROM GradoMateria gm " +
            "WHERE gm.periodoPersonal.perfil = 'PROFESOR' and gm.carrera.id = :idCarrera ")
    public List<Personal> findAllProfesorByCarrera(@Param("idCarrera") Long idCarrera);
}

package mx.edu.utec.repositories;

import mx.edu.utec.model.Alumno;
import org.springframework.data.repository.CrudRepository;


public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
  Alumno findByMatricula(String matricula);
}
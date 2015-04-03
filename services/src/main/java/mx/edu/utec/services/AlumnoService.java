package mx.edu.utec.services;

import mx.edu.utec.dto.AlumnoDTO;

import java.util.List;

public interface AlumnoService {
    AlumnoDTO findAlumnobyMatricula(String matricula);
    List<AlumnoDTO> findAllAlumnos();
}
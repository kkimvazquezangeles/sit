package mx.edu.utec.services.impl;

import mx.edu.utec.dto.AlumnoDTO;
import mx.edu.utec.model.Alumno;
import mx.edu.utec.repositories.AlumnoRepository;
import mx.edu.utec.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;


    @Override
    public AlumnoDTO findAlumnobyMatricula(String matricula) {
        Alumno alumno = alumnoRepository.findByMatricula(matricula);
        return convertHotelToDTO(alumno);
    }

    @Override
    public List<AlumnoDTO> findAllAlumnos() {
        Iterator<Alumno> itAlumnos = alumnoRepository.findAll().iterator();
        List<AlumnoDTO> copy = new ArrayList<AlumnoDTO>();
        while (itAlumnos.hasNext()) {
            Alumno alumno = itAlumnos.next();
            AlumnoDTO dto = convertHotelToDTO(alumno);
            copy.add(dto);
        }
        return copy;
    }

    private AlumnoDTO convertHotelToDTO(Alumno alumno) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setMatricula(alumno.getMatricula());
        dto.setApellidoPaterno(alumno.getApellidoPaterno());
        dto.setApellidoMaterno(alumno.getApellidoMaterno());
        return dto;
    }
}

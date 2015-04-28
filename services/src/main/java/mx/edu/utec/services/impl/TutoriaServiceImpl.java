package mx.edu.utec.services.impl;

import mx.edu.utec.dto.TutoriaDTO;
import mx.edu.utec.model.Departamento;
import mx.edu.utec.model.Tutoria;
import mx.edu.utec.repositories.TutoriaRepository;
import mx.edu.utec.services.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
@Service
public class TutoriaServiceImpl implements TutoriaService{

    @Autowired
    TutoriaRepository tutoriaRepository;

    @Override
    public List<TutoriaDTO> findAllTutoriaByCarreraAndPeriodo(Long idCarrera, Long idPeriodo) {
        Iterator<Tutoria> itTutoria = tutoriaRepository.findAllTutoriaByCarreraAndPeriodo(idCarrera, idPeriodo).iterator();
        List<TutoriaDTO> copy = new ArrayList<TutoriaDTO>();
        while (itTutoria.hasNext()) {
            Tutoria t = itTutoria.next();
            TutoriaDTO dto = convertTutoriaDTO(t);
            copy.add(dto);
        }
        return copy;
    }

    private TutoriaDTO convertTutoriaDTO(Tutoria tutoria) {
        TutoriaDTO dto = new TutoriaDTO();
        dto.setId(tutoria.getId());
        dto.setMatricula(tutoria.getPeriodoAlumno().getAlumno().getMatricula());
        dto.setNombreAlumno(tutoria.getPeriodoAlumno().getAlumno().getNombre() + ' ' + tutoria.getPeriodoAlumno().getAlumno().getApellidoPaterno() + ' ' + tutoria.getPeriodoAlumno().getAlumno().getApellidoMaterno());
        dto.setNombreTutor(tutoria.getTutor().getNombre() + ' ' + tutoria.getTutor().getApellidoPaterno() + ' ' + tutoria.getTutor().getApellidoMaterno());
        return dto;

    }


    @Override
    public void updateTutoria(TutoriaDTO tutoriaDTO) {
        Tutoria tutoria = tutoriaRepository.findOne(tutoriaDTO.getId());
        tutoria.setDepartamento(Departamento.valueOf(tutoriaDTO.getDepartamento()));
        tutoriaRepository.save(tutoria);
    }


}

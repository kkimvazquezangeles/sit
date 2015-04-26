package mx.edu.utec.services.impl;

import mx.edu.utec.dto.CuatrimestreMateriaDTO;
import mx.edu.utec.model.CuatrimestreMateria;
import mx.edu.utec.repositories.CuatrimestreMateriaRepository;
import mx.edu.utec.services.CuatrimestreMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 23/04/15.
 */
@Service
public class CuatrimestreMateriaServiceImpl implements CuatrimestreMateriaService {

    @Autowired
    CuatrimestreMateriaRepository cuatrimestreMateriaRepository;

    @Override
    public List<CuatrimestreMateriaDTO> findAllByPeriodoAndCarreraAndCuatrimestreAndGrupo(
            Long idPeriodo, Long idCarrera, Long idCuatrimestre, Long idGrupo){
        Iterator<CuatrimestreMateria> itCuatrimestreMateria =
                cuatrimestreMateriaRepository.findAllByPeriodoAndCarreraAndCuatrimestreAndGrupo(
                        idPeriodo, idCarrera, idCuatrimestre, idGrupo).iterator();
        List<CuatrimestreMateriaDTO> materias = new ArrayList<>();
        while (itCuatrimestreMateria.hasNext()) {
            CuatrimestreMateria cuatrimestreMateria = itCuatrimestreMateria.next();
            CuatrimestreMateriaDTO dto = convertCuatrimestreMateriaToDTO(cuatrimestreMateria);
            materias.add(dto);
        }
        return materias;
    }

    private CuatrimestreMateriaDTO convertCuatrimestreMateriaToDTO(CuatrimestreMateria cuatrimestreMateria) {
        CuatrimestreMateriaDTO dto = new CuatrimestreMateriaDTO();
        dto.setId(cuatrimestreMateria.getId());
        dto.setNombreProfesor(cuatrimestreMateria.getPeriodoPersonal().getPersonal().getNombre() +
                ' ' + cuatrimestreMateria.getPeriodoPersonal().getPersonal().getApellidoPaterno() +
                ' ' + cuatrimestreMateria.getPeriodoPersonal().getPersonal().getApellidoMaterno());
        dto.setIdProfesor(cuatrimestreMateria.getPeriodoPersonal().getPersonal().getId());
        dto.setNombreMateria(cuatrimestreMateria.getMateria().getMateria());
        dto.setIdMateria(cuatrimestreMateria.getMateria().getId());

        dto.setNombreCuatrimestre(cuatrimestreMateria.getCuatrimestre().getCuatrimestre());
        dto.setIdCuatrimestre(cuatrimestreMateria.getCuatrimestre().getId());
        dto.setNombreGrupo(cuatrimestreMateria.getGrupo().getGrupo());
        dto.setIdGrupo(cuatrimestreMateria.getGrupo().getId());
        return dto;
    }
}

package mx.edu.utec.services;

import mx.edu.utec.dto.CuatrimestreMateriaDTO;
import mx.edu.utec.model.CuatrimestreMateria;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 23/04/15.
 */
public interface CuatrimestreMateriaService {
    List<CuatrimestreMateriaDTO> findAllByPeriodoAndCarreraAndCuatrimestreAndGrupo(Long idPeriodo, Long idCarrera, Long idCuatrimestre, Long idGrupo);

}

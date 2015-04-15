package mx.edu.utec.services;

import mx.edu.utec.dto.CuatrimestreDTO;
import mx.edu.utec.dto.GrupoDTO;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 05/04/15.
 */
public interface CuatrimestreService {
    List<CuatrimestreDTO> findAllCuatrimestreByCarrera(Long idCarrera, Long idPeriodo);
    List<GrupoDTO> findAllGrupoByCuatrimestreAndCarrera(Long idCarrera, Long idGrupo, Long idPeriodo);
}

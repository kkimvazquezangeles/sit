package mx.edu.utec.services.impl;

import mx.edu.utec.dto.AlumnoDTO;
import mx.edu.utec.dto.CuatrimestreDTO;
import mx.edu.utec.dto.GrupoDTO;
import mx.edu.utec.dto.PersonalDTO;
import mx.edu.utec.model.*;
import mx.edu.utec.repositories.CuatrimestreRepository;
import mx.edu.utec.repositories.GrupoRepository;
import mx.edu.utec.services.CuatrimestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 05/04/15.
 */

@Service
public class CuatrimestreServiceImpl implements CuatrimestreService {

    @Autowired
    CuatrimestreRepository cuatrimestreRepository;
    @Autowired
    GrupoRepository grupoRepository;

    @Override
    public List<CuatrimestreDTO> findAllCuatrimestreByCarrera(Long idCarrera, Long idPeriodo) {
        Iterator<Cuatrimestre> itCuatrimestre = cuatrimestreRepository.findAllCuatrimestreByCarrera(idCarrera, idPeriodo).iterator();
        List<CuatrimestreDTO> cuatrimestres = new ArrayList<>();
        while (itCuatrimestre.hasNext()) {
            Cuatrimestre cuatrimestre = itCuatrimestre.next();
            CuatrimestreDTO dto = convertCuatrimestreToDTO(cuatrimestre);
            cuatrimestres.add(dto);
        }
        return cuatrimestres;
    }

    private CuatrimestreDTO convertCuatrimestreToDTO(Cuatrimestre cuatrimestre) {
        CuatrimestreDTO dto = new CuatrimestreDTO();
        dto.setId(cuatrimestre.getId());
        dto.setCuatrimestre(cuatrimestre.getCuatrimestre());
        return dto;
    }


    @Override
    public List<GrupoDTO> findAllGrupoByCuatrimestreAndCarrera(Long idCarrera, Long idGrupo, Long idPeriodo, String tipo) {
        Iterator<Grupo> itGrupo = null;

        if(tipo.equals("asignacion")) {
            itGrupo = grupoRepository.findAllGrupoByCarreraAndCuatrimestre(idCarrera, idGrupo, idPeriodo).iterator();
        }
        if(tipo.equals("plan")) {
            itGrupo = grupoRepository.findAllPlanGrupoByCarreraAndCuatrimestre(idCarrera, idGrupo, idPeriodo).iterator();
        }

        List<GrupoDTO> grupos = new ArrayList<>();
        while (itGrupo.hasNext()) {
            Grupo grupo = itGrupo.next();
            GrupoDTO dto = convertGrupoToDTO(grupo);
            grupos.add(dto);
        }
        return grupos;
    }

    private GrupoDTO convertGrupoToDTO(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO();
        dto.setId(grupo.getId());
        dto.setGrupo(grupo.getGrupo());
        return dto;
    }
}

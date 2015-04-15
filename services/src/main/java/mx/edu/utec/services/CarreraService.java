package mx.edu.utec.services;

import mx.edu.utec.dto.CarreraDTO;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 10/04/15.
 */
public interface CarreraService {
    List<CarreraDTO> findAllByPersonalAndPeriodoAndPerfil(Long idPersonal, Long idPeriodo, String perfil);
}

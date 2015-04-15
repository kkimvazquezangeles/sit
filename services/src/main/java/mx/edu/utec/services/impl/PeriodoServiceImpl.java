package mx.edu.utec.services.impl;

import mx.edu.utec.model.EstadoPeriodo;
import mx.edu.utec.model.Periodo;
import mx.edu.utec.repositories.PeriodoRepository;
import mx.edu.utec.services.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kkimvazquezangeles on 10/04/15.
 */
@Service
public class PeriodoServiceImpl implements PeriodoService {

    @Autowired
    PeriodoRepository periodoRepository;


    @Override
    public Periodo findByEstadoPeriodo(EstadoPeriodo estadoPeriodo) {
        return periodoRepository.findByEstadoPeriodo(estadoPeriodo);
    }
}

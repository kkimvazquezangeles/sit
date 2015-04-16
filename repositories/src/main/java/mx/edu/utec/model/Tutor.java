package mx.edu.utec.model;

import javax.persistence.*;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */
@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cuatrimestre_id")
    private Cuatrimestre cuatrimestre;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "periodo_personal_id")
    private PeriodoPersonal periodoPersonal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cuatrimestre getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Cuatrimestre cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public PeriodoPersonal getPeriodoPersonal() {
        return periodoPersonal;
    }

    public void setPeriodoPersonal(PeriodoPersonal periodoPersonal) {
        this.periodoPersonal = periodoPersonal;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", cuatrimestre=" + cuatrimestre +
                ", grupo=" + grupo +
                ", carrera=" + carrera +
                ", periodoPersonal=" + periodoPersonal +
                '}';
    }


}

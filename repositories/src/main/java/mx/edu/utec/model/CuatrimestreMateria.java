package mx.edu.utec.model;

import javax.persistence.*;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */
@Entity
public class CuatrimestreMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "periodo_personal_id")
    private PeriodoPersonal periodoPersonal;

    @ManyToOne
    @JoinColumn(name = "cuatrimestre_id")
    private Cuatrimestre cuatrimestre;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeriodoPersonal getPeriodoPersonal() {
        return periodoPersonal;
    }

    public void setPeriodoPersonal(PeriodoPersonal periodoPersonal) {
        this.periodoPersonal = periodoPersonal;
    }

    public Cuatrimestre getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Cuatrimestre cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "GradoMateria{" +
                "id=" + id +
                ", periodoPersonal=" + periodoPersonal +
                ", grado=" + cuatrimestre +
                ", materia=" + materia +
                ", carrera=" + carrera +
                ", grupo=" + grupo +
                '}';
    }
}

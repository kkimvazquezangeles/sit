package mx.edu.utec.model;

import javax.persistence.*;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class PeriodoAlumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "cuatrimestre_id")
    private Cuatrimestre cuatrimestre;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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

    @Override
    public String toString() {
        return "PeriodoAlumno{" +
                "id=" + id +
                ", periodo=" + periodo +
                ", alumno=" + alumno +
                ", grado=" + cuatrimestre +
                ", grupo=" + grupo +
                '}';
    }
}

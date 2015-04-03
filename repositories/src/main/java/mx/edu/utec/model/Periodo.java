package mx.edu.utec.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre_periodo")
    private String nombrePeriodo;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;

    @OneToMany(mappedBy = "periodo")
    private List<PeriodoAlumno> periodoAlumnos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<PeriodoAlumno> getPeriodoAlumnos() {
        return periodoAlumnos;
    }

    public void setPeriodoAlumnos(List<PeriodoAlumno> periodoAlumnos) {
        this.periodoAlumnos = periodoAlumnos;
    }

    @Override
    public String toString() {
        return "Periodo{" +
                "id=" + id +
                ", nombrePeriodo='" + nombrePeriodo + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", periodoAlumnos=" + periodoAlumnos +
                '}';
    }
}

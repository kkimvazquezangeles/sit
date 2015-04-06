package mx.edu.utec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class Cuatrimestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cuatrimestre;

    @OneToMany(mappedBy = "cuatrimestre")
    private List<PeriodoAlumno> periodoAlumnos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public List<PeriodoAlumno> getPeriodoAlumnos() {
        return periodoAlumnos;
    }

    public void setPeriodoAlumnos(List<PeriodoAlumno> periodoAlumnos) {
        this.periodoAlumnos = periodoAlumnos;
    }

    @Override
    public String toString() {
        return "Grado{" +
                "id=" + id +
                ", cuatrimestre=" + cuatrimestre +
                ", periodoAlumnos=" + periodoAlumnos +
                '}';
    }
}

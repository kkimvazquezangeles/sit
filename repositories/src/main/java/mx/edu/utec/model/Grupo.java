package mx.edu.utec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String grupo;

    @OneToMany(mappedBy = "grupo")
    private List<PeriodoAlumno> periodoAlumnos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrupo() { return grupo; }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public List<PeriodoAlumno> getPeriodoAlumnos() {
        return periodoAlumnos;
    }

    public void setPeriodoAlumnos(List<PeriodoAlumno> periodoAlumnos) {
        this.periodoAlumnos = periodoAlumnos;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", grupo=" + grupo +
                ", periodoAlumnos=" + periodoAlumnos +
                '}';
    }
}

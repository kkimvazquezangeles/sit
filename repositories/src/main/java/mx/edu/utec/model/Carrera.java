package mx.edu.utec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre_carrera")
    private String nombreCarrera;

    @OneToMany(mappedBy = "carrera")
    private List<Alumno> alumnos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", alumnos=" + alumnos +
                '}';
    }
}

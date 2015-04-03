package mx.edu.utec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricula;
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @OneToMany(mappedBy = "alumno")
    private List<PeriodoAlumno> periodoAlumnos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<PeriodoAlumno> getPeriodoAlumnos() {
        return periodoAlumnos;
    }

    public void setPeriodoAlumnos(List<PeriodoAlumno> periodoAlumnos) {
        this.periodoAlumnos = periodoAlumnos;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", carrera=" + carrera +
                ", periodoAlumnos=" + periodoAlumnos +
                '}';
    }
}

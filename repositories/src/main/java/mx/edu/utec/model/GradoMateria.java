package mx.edu.utec.model;

import javax.persistence.*;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */
@Entity
public class GradoMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "periodo_personal_id")
    private PeriodoPersonal periodoPersonal;

    @ManyToOne
    @JoinColumn(name = "grado_id")
    private Grado grado;

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

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
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

    @Override
    public String toString() {
        return "GradoMateria{" +
                "id=" + id +
                ", periodoPersonal=" + periodoPersonal +
                ", grado=" + grado +
                ", materia=" + materia +
                ", carrera=" + carrera +
                '}';
    }
}

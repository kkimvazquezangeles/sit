package mx.edu.utec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class Tutoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "periodo_alumno_id")
    private PeriodoAlumno periodoAlumno;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tutoria")
    private TipoTutoria tipoTutoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_tutoria")
    private StatusTutoria statusTutoria;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "canalizador_id")
    private Personal canalizador;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Personal tutor;

    @OneToMany(mappedBy = "tutoria")
    private List<TutoriaDetalle> comentarios;


    @Enumerated(EnumType.STRING)
    private Departamento departamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeriodoAlumno getPeriodoAlumno() {

        return periodoAlumno;
    }

    public void setPeriodoAlumno(PeriodoAlumno periodoAlumno) {

        this.periodoAlumno = periodoAlumno;
    }

    public TipoTutoria getTipoTutoria() {

        return tipoTutoria;
    }

    public void setTipoTutoria(TipoTutoria tipoTutoria) {

        this.tipoTutoria = tipoTutoria;
    }

    public StatusTutoria getStatusTutoria() {

        return statusTutoria;
    }

    public void setStatusTutoria(StatusTutoria statusTutoria) {

        this.statusTutoria = statusTutoria;
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

    public Personal getCanalizador() {

        return canalizador;
    }

    public void setCanalizador(Personal canalizador) {

        this.canalizador = canalizador;
    }

    public Personal getTutor() {

        return tutor;
    }

    public void setTutor(Personal tutor) {

        this.tutor = tutor;
    }

    public List<TutoriaDetalle> getComentarios() {

        return comentarios;
    }

    public void setComentarios(List<TutoriaDetalle> comentarios) {

        this.comentarios = comentarios;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Tutoria{" +
                "id=" + id +
                ", periodoAlumno=" + periodoAlumno +
                ", tipoTutoria=" + tipoTutoria +
                ", statusTutoria=" + statusTutoria +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", canalizador=" + canalizador +
                ", tutor=" + tutor +
                ", comentarios=" + comentarios +
                ", departamento=" + departamento +
                '}';
    }
}

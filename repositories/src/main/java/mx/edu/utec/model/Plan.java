package mx.edu.utec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String diagnostico;
    private String proposito;
    private String medidas;
    private String recomendaciones;

    @OneToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @OneToMany(mappedBy = "plan", fetch = FetchType.EAGER)
    private List<PlanDetalle> actividades;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getDiagnostico() {

        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {

        this.diagnostico = diagnostico;
    }

    public String getProposito() {

        return proposito;
    }

    public void setProposito(String proposito) {

        this.proposito = proposito;
    }

    public String getMedidas() {

        return medidas;
    }

    public void setMedidas(String medidas) {

        this.medidas = medidas;
    }

    public String getRecomendaciones() {

        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {

        this.recomendaciones = recomendaciones;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<PlanDetalle> getActividades() {
        return actividades;
    }

    public void setActividades(List<PlanDetalle> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", diagnostico='" + diagnostico + '\'' +
                ", proposito='" + proposito + '\'' +
                ", medidas='" + medidas + '\'' +
                ", recomendaciones='" + recomendaciones + '\'' +
                ", tutor=" + tutor +
                '}';
    }
}

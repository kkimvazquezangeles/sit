package mx.edu.utec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "plan_detalle_id")
    private PlanDetalle planDetalle;


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

    public PlanDetalle getPlanDetalle() {
        return planDetalle;
    }

    public void setPlanDetalle(PlanDetalle planDetalle) {
        this.planDetalle = planDetalle;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", diagnostico='" + diagnostico + '\'' +
                ", proposito='" + proposito + '\'' +
                ", medidas='" + medidas + '\'' +
                ", recomendaciones='" + recomendaciones + '\'' +
                ", planDetalle=" + planDetalle +
                '}';
    }
}

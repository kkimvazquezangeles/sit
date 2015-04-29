package mx.edu.utec.model;

import javax.persistence.*;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class PlanDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String actividad;

    @Enumerated(EnumType.STRING)
    private Mes mes;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "PlanDetalle{" +
                "id=" + id +
                ", actividad='" + actividad + '\'' +
                ", mes=" + mes +
                '}';
    }
}

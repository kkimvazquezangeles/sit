package mx.edu.utec.dto;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
public class PlanDetalleDTO {

    private Long id;
    private String actividad;
    private String mes;

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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

}

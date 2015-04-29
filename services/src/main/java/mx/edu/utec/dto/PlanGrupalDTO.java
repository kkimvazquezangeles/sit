package mx.edu.utec.dto;

import java.util.List;

/**
 * Created by kkimvazquezangeles on 28/04/15.
 */
public class PlanGrupalDTO {

    private Long id;
    private String diagnostico;
    private String proposito;
    private String medidas;
    private String recomendaciones;
    private Long idTutor;
    private List<PlanDetalleDTO> actividades;

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

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public List<PlanDetalleDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<PlanDetalleDTO> actividades) {
        this.actividades = actividades;
    }
}


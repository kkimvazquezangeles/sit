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
    private Long idPeriodo;
    private Long idGrupo;
    private Long idCuatrimestre;
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

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Long getIdCuatrimestre() {
        return idCuatrimestre;
    }

    public void setIdCuatrimestre(Long idCuatrimestre) {
        this.idCuatrimestre = idCuatrimestre;
    }

    public List<PlanDetalleDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<PlanDetalleDTO> actividades) {
        this.actividades = actividades;
    }
}


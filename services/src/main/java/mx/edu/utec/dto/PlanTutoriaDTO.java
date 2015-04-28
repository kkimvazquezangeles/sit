package mx.edu.utec.dto;

/**
 * Created by kkimvazquezangeles on 26/04/15.
 */
public class PlanTutoriaDTO {

    private Long id;
    private Long idTutoria;
    private String matricula;
    private String statusTutoria;
    private String tipoTutoria;
    private String observaciones;
    private String departamento;
    private String diagnostico;
    private String proposito;
    private String medidas;
    private String recomendaciones;



    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getIdTutoria() {
        return idTutoria;
    }

    public void setIdTutoria(Long idTutoria) {
        this.idTutoria = idTutoria;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getStatusTutoria() {
        return statusTutoria;
    }

    public void setStatusTutoria(String statusTutoria) {
        this.statusTutoria = statusTutoria;
    }


    public String getTipoTutoria() {
        return tipoTutoria;
    }

    public void setTipoTutoria(String tipoTutoria) {
        this.tipoTutoria = tipoTutoria;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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



}

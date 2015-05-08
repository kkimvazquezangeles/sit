package mx.edu.utec.dto;

/**
 * Created by kkimvazquezangeles on 22/04/15.
 */
public class TutoriaDTO {

    private Long id;
    private String nombreAlumno;
    private String matricula;
    private String nombreTutor;
    private String departamento;
    private Long idCarrera;
    private Long idPeriodo;
    private String tipoTutoria;
    private String observaciones;
    private String statusTutoria;
    private Long idCanalizador;
    private String diagnostico;
    private String proposito;
    private String medidas;
    private String recomendaciones;
    private String rol;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
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

    public String getStatusTutoria() {
        return statusTutoria;
    }

    public void setStatusTutoria(String statusTutoria) {
        this.statusTutoria = statusTutoria;
    }

    public Long getIdCanalizador() {
        return idCanalizador;
    }

    public void setIdCanalizador(Long idCanalizador) {
        this.idCanalizador = idCanalizador;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

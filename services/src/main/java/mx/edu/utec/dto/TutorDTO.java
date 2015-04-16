package mx.edu.utec.dto;

/**
 * Created by kkimvazquezangeles on 16/04/15.
 */
public class TutorDTO {

    private Long id;
    private Long idTutor;
    private String nombreCompleto;
    private Long idCarrera;
    private String carrera;
    private Long idCuatrimestre;
    private String cuatrimestre;
    private Long idGrupo;
    private String grupo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Long getIdCuatrimestre() {
        return idCuatrimestre;
    }

    public void setIdCuatrimestre(Long idCuatrimestre) {
        this.idCuatrimestre = idCuatrimestre;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }


    @Override
    public String toString() {
        return "TutorDTO{" +
                "id=" + id +
                ", idTutor=" + idTutor +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", idCarrera=" + idCarrera +
                ", carrera='" + carrera + '\'' +
                ", idCuatrimestre=" + idCuatrimestre +
                ", cuatrimestre='" + cuatrimestre + '\'' +
                ", idGrupo=" + idGrupo +
                ", grupo='" + grupo + '\'' +
                '}';
    }
}

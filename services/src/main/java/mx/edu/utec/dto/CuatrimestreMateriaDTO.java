package mx.edu.utec.dto;

/**
 * Created by kkimvazquezangeles on 23/04/15.
 */
public class CuatrimestreMateriaDTO {

    private Long id;
    private String nombreProfesor;
    private Long idProfesor;
    private String nombreMateria;
    private Long idMateria;
    private String nombreGrupo;
    private Long idGrupo;
    private String nombreCuatrimestre;
    private Long idCuatrimestre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreCuatrimestre() {
        return nombreCuatrimestre;
    }

    public void setNombreCuatrimestre(String nombreCuatrimestre) {
        this.nombreCuatrimestre = nombreCuatrimestre;
    }

    public Long getIdCuatrimestre() {
        return idCuatrimestre;
    }

    public void setIdCuatrimestre(Long idCuatrimestre) {
        this.idCuatrimestre = idCuatrimestre;
    }
}

package mx.edu.utec.dto;

import mx.edu.utec.model.UserRole;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;

/**
 * Created by kkimvazquezangeles on 07/04/15.
 */
public class SessionDTO {

    private String name;
    private Long id;
    private String username;
    private Collection<? extends GrantedAuthority> roles;
    private Long idCarrera;
    private String carrera;
    private String estadoPeriodo;
    private String idPeriodo;
    private Long idPeriodoPersonal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public Long getIdCarrera() { return idCarrera; }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstadoPeriodo() {
        return estadoPeriodo;
    }

    public void setEstadoPeriodo(String estadoPeriodo) {
        this.estadoPeriodo = estadoPeriodo;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Long getIdPeriodoPersonal() {
        return idPeriodoPersonal;
    }

    public void setIdPeriodoPersonal(Long idPeriodoPersonal) {
        this.idPeriodoPersonal = idPeriodoPersonal;
    }
}

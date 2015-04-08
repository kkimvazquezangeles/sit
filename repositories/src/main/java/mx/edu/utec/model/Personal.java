package mx.edu.utec.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @OneToMany(mappedBy = "personal")
    private List<PeriodoPersonal> periodosPersonal;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellidoPaterno() {

        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {

        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {

        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {

        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFullName() {

        return nombre + ' ' + apellidoPaterno + ' ' + apellidoMaterno;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                '}';
    }
}

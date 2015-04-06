package mx.edu.utec.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class PeriodoPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToMany(mappedBy = "periodoPersonal")
    private List<CuatrimestreMateria> materias;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Periodo getPeriodo() {

        return periodo;
    }

    public void setPeriodo(Periodo periodo) {

        this.periodo = periodo;
    }

    public Personal getPersonal() {

        return personal;
    }

    public void setPersonal(Personal personal) {

        this.personal = personal;
    }

    public Perfil getPerfil() {

        return perfil;
    }

    public void setPerfil(Perfil perfil) {

        this.perfil = perfil;
    }

    public List<CuatrimestreMateria> getMaterias() {
        return materias;
    }

    public void setMaterias(List<CuatrimestreMateria> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "PeriodoPersonal{" +
                "id=" + id +
                ", periodo=" + periodo +
                ", personal=" + personal +
                ", perfil=" + perfil +
                ", materias=" + materias +
                '}';
    }
}

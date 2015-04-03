package mx.edu.utec.model;

import javax.persistence.*;

/**
 * Created by kkimvazquezangeles on 22/03/15.
 */
@Entity
public class TutoriaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutoria_id")
    private Tutoria tutoria;

    private String comentario;

    @Enumerated(EnumType.STRING)
    private TipoComentario tipoComentario;

    @ManyToOne
    @JoinColumn(name = "registrado_por_id")
    private Personal registradoPor;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Tutoria getTutoria() {

        return tutoria;
    }

    public void setTutoria(Tutoria tutoria) {

        this.tutoria = tutoria;
    }

    public String getComentario() {

        return comentario;
    }

    public void setComentario(String comentario) {

        this.comentario = comentario;
    }

    public TipoComentario getTipoComentario() {

        return tipoComentario;
    }

    public void setTipoComentario(TipoComentario tipoComentario) {

        this.tipoComentario = tipoComentario;
    }

    public Personal getRegistradoPor() {

        return registradoPor;
    }

    public void setRegistradoPor(Personal registradoPor) {

        this.registradoPor = registradoPor;
    }

    @Override
    public String toString() {
        return "TutoriaDetalle{" +
                "id=" + id +
                ", tutoria=" + tutoria +
                ", comentario='" + comentario + '\'' +
                ", tipoComentario=" + tipoComentario +
                ", registradoPor=" + registradoPor +
                '}';
    }
}

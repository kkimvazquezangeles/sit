package mx.edu.utec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kkimvazquezangeles on 02/04/15.
 */
@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String materia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", materia='" + materia + '\'' +
                '}';
    }
}

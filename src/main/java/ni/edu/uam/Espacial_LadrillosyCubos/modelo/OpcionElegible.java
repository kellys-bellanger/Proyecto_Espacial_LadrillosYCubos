package ni.edu.uam.Espacial_LadrillosyCubos.modelo;

import javax.persistence.*;
import lombok.*;

    @Embeddable
    @Getter @Setter
    public class OpcionElegible {

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private Pregunta pregunta;

    @Column(length=30)
    private String descripcion;
}
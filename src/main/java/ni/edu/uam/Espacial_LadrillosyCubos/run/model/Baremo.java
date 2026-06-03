package ni.edu.uam.Espacial_LadrillosyCubos.run.model;


import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Baremo {

    @Id
    @Column(length=4)
    int puntuacionDirecta;

    @Column(length=4) @Required
    int percentil;

    @Column(length=50) @Required
    String rango;
}

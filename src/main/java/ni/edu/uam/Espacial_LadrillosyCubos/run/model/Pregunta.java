package ni.edu.uam.Espacial_LadrillosyCubos.run.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

@Entity
@Getter @Setter
@View(members="imagenHtml; respuestaCorrecta")
@View(members="numeroPregunta; imagen; opcionA, opcionB, opcionC, opcionD, opcionE; respuestaCorrecta")
public class Pregunta {

    @Id
    @Column(length=4)
    int numeroPregunta;

    @Stereotype("IMAGE")
    @Column(length=32)
    String imagen;

    @Column(length=4) @Required
    int opcionA;

    @Column(length=4) @Required
    int opcionB;

    @Column(length=4) @Required
    int opcionC;

    @Column(length=4) @Required
    int opcionD;

    @Column(length=4) @Required
    int opcionE;

    @Column(length=1) @Required
    String respuestaCorrecta;
}
package ni.edu.uam.Espacial_LadrillosyCubos.run.model;

import javax.persistence.*;
import org.openxava.annotations.*;

public class pregunta
{
    @Entity
    @View(members="numeroPregunta; imagen; opciones [opcionA, opcionB, opcionC, opcionD, opcionE]; respuestaCorrecta")
    public class Pregunta {

        @Id
        @Required
        private int numeroPregunta;

        @Stereotype("IMAGE")
        @Column(length=50)
        private String imagen;

        @Required
        private int opcionA;
        @Required
        private int opcionB;
        @Required
        private int opcionC;
        @Required
        private int opcionD;
        @Required
        private int opcionE;

        @Required
        @Column(length=1)
        private String respuestaCorrecta; // Almacena 'A', 'B', 'C', 'D' o 'E'

        // --- GETTERS Y SETTERS ---
        public int getNumeroPregunta() { return numeroPregunta; }
        public void setNumeroPregunta(int numeroPregunta) { this.numeroPregunta = numeroPregunta; }

        public String getImagen() { return imagen; }
        public void setImagen(String imagen) { this.imagen = imagen; }

        public int getOpcionA() { return opcionA; }
        public void setOpcionA(int opcionA) { this.opcionA = opcionA; }

        public int getOpcionB() { return opcionB; }
        public void setOpcionB(int opcionB) { this.opcionB = opcionB; }

        public int getOpcionC() { return opcionC; }
        public void setOpcionC(int opcionC) { this.opcionC = opcionC; }

        public int getOpcionD() { return opcionD; }
        public void setOpcionD(int opcionD) { this.opcionD = opcionD; }

        public int getOpcionE() { return opcionE; }
        public void setOpcionE(int opcionE) { this.opcionE = opcionE; }

        public String getRespuestaCorrecta() { return respuestaCorrecta; }
        public void setRespuestaCorrecta(String respuestaCorrecta) { this.respuestaCorrecta = respuestaCorrecta; }
    }
}

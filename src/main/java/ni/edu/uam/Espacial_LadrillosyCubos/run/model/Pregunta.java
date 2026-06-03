package ni.edu.uam.Espacial_LadrillosyCubos.run.model;

import javax.persistence.*;
import org.openxava.annotations.*;

@Entity
@View(members="imagenHtml; respuestaCorrecta")
public class Pregunta {

    @Id
    @Required
    @Hidden
    @Column(length=5)
    private int numeroPregunta;

    private int valorA;
    private int valorB;
    private int valorC;
    private int valorD;
    private int valorE;

    public enum Opcion { A, B, C, D, E }

    @Required
    @Enumerated(EnumType.STRING)
    @Editor("ValidValuesRadioButton")
    private Opcion respuestaCorrecta;

    @Transient
    @HtmlText
    @ReadOnly // ESTO ES CLAVE: Le dice a OpenXava que solo muestre el HTML, sin el editor gris
    public String getImagenHtml() {
        // Usa la ruta absoluta desde la raíz de tu proyecto
        String ruta = "/Espacial_LadrillosyCubos/images/pregunta" + this.numeroPregunta + ".png";

        return "<div style='text-align: center; margin: 15px 0;'>" +
                "<img src='" + ruta + "' style='max-height: 250px;' />" +
                "</div>";
    }

    // --- GETTERS Y SETTERS ---
    public int getNumeroPregunta() { return numeroPregunta; }
    public void setNumeroPregunta(int numeroPregunta) { this.numeroPregunta = numeroPregunta; }

    public Opcion getRespuestaCorrecta() { return respuestaCorrecta; }
    public void setRespuestaCorrecta(Opcion respuestaCorrecta) { this.respuestaCorrecta = respuestaCorrecta; }

    public int getValorA() { return valorA; }
    public void setValorA(int valorA) { this.valorA = valorA; }

    public int getValorB() { return valorB; }
    public void setValorB(int valorB) { this.valorB = valorB; }

    public int getValorC() { return valorC; }
    public void setValorC(int valorC) { this.valorC = valorC; }

    public int getValorD() { return valorD; }
    public void setValorD(int valorD) { this.valorD = valorD; }

    public int getValorE() { return valorE; }
    public void setValorE(int valorE) { this.valorE = valorE; }
}
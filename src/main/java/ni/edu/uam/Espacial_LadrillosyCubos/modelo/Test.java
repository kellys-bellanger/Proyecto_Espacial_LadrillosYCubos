package ni.edu.uam.Espacial_LadrillosyCubos.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@View(members=
        "id, fechaPrueba;" +
                "pacienteTest;" +
                "detalles;" +
                "puntuacionDirecta, percentil, rangoSugerido;" +
                "informeFinal"
)
public class Test {

    @Id
    @Hidden
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @Required
    @ReadOnly
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fechaPrueba;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @DescriptionsList(descriptionProperties="nombreCompleto")
    @JoinColumn(name="paciente_id")
    paciente pacienteTest;

    @ElementCollection
    @ListProperties("pregunta.numeroPregunta, descripcion")
    Collection<OpcionEligible> detalles;

    @ReadOnly
    int puntuacionDirecta;

    @ReadOnly
    int percentil;

    @ReadOnly
    @Column(length=50)
    String rangoSugerido;

    @TextArea
    @ReadOnly
    String informeFinal;

    @PrePersist
    @PreUpdate
    private void calcularResultados() {
        int aciertos = 0;
        if (detalles != null) {
            for (OpcionEligible det : detalles) {
                if (det.getPregunta() != null &&
                        det.getDescripcion() != null &&
                        det.getDescripcion().equalsIgnoreCase(det.getPregunta().getRespuestaCorrecta())) {
                    aciertos++;
                }
            }
        }
        this.puntuacionDirecta = aciertos;

        try {
            EntityManager em = org.openxava.jpa.XPersistence.getManager();
            Baremo baremo = em.find(Baremo.class, this.puntuacionDirecta);

            if (baremo != null) {
                this.percentil = baremo.getPercentil();
                this.rangoSugerido = baremo.getRango();
            } else {
                this.percentil = 0;
                this.rangoSugerido = "Fuera de rango";
            }
        } catch (Exception e) {
            this.percentil = 0;
            this.rangoSugerido = "Error de consulta";
        }

        StringBuilder informe = new StringBuilder();
        if (pacienteTest != null) {
            informe.append("El paciente ").append(pacienteTest.getNombreCompleto())
                    .append(" completó la prueba con ").append(this.puntuacionDirecta).append(" aciertos netos, ")
                    .append("lo que equivale a un percentil de ").append(this.percentil).append(".\n")
                    .append("Diagnóstico: ").append(this.rangoSugerido).append(".");
        }
        this.informeFinal = informe.toString();
    }
}
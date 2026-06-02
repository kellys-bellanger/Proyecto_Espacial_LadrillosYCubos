package ni.edu.uam.Espacial_LadrillosyCubos.run.model;


import java.time.*;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openxava.annotations.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@View(members="cedula, nombreCompleto; fechaNacimiento, edad")
public class paciente {

    @Id
    @Column(length=20)
    @Required
    private String cedula;

    @Column(length=100)
    @Required
    private String nombreCompleto;

    @Required
    private LocalDate fechaNacimiento;

    @Depends("fechaNacimiento")
    public int getEdad() {
        if (fechaNacimiento == null) return 0;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }}

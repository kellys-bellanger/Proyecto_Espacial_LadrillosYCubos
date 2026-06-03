package ni.edu.uam.Espacial_LadrillosyCubos.run.model;

import javax.persistence.*;
import org.openxava.annotations.*;

@Entity
public class OpcionElegible {

    @Id
    @Column(length=2)
    private String id; // Almacenará 'A', 'B', 'C', 'D', 'E'

    @Column(length=30)
    private String descripcion; // Almacenará el texto que acompaña al círculo

    // --- GETTERS Y SETTERS ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}

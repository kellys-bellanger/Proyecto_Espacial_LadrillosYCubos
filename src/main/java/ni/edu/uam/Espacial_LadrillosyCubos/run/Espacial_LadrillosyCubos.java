package ni.edu.uam.Espacial_LadrillosyCubos.run;

import org.openxava.util.*;

/**
 * Ejecuta esta clase para arrancar la aplicación.
 */

public class Espacial_LadrillosyCubos {

	public static void main(String[] args) throws Exception {
		DBServer.start("Espacial_LadrillosyCubos-db"); // Para usar tu propia base de datos comenta esta línea y configura src/main/webapp/META-INF/context.xml
		AppServer.run("Espacial_LadrillosyCubos"); // Usa AppServer.run("") para funcionar en el contexto raíz
	}

}

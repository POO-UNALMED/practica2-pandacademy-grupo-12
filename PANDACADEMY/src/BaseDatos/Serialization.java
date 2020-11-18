package BaseDatos;
import gestorAplicacion.Persona.Estudiante;
import gestorAplicacion.Academico.Semestre;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization{ 
	
	static File archivo = new File("");
	
	public static void serializarE(Estudiante est) {
		
		try {
			FileOutputStream f = new FileOutputStream(archivo.getAbsolutePath()+"\\src\\BaseDatos\\temp\\estudiante.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(est);

			o.close();
			f.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
}

package BaseDatos;
import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.Estudiante;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import gestorAplicacion.Persona.Estudiante;

public class Deserialization {
	static File archivo = new File("");

	public static Estudiante deserializarE() {
		Estudiante est;
		try {
			FileInputStream f = new FileInputStream(archivo.getAbsolutePath()+"\\src\\BaseDatos\\temp\\estudiante.txt");
			ObjectInputStream o = new ObjectInputStream(f);

			est = (Estudiante) o.readObject();
			Semestre.profesores = est.getProfesores();
			o.close();
			f.close();
			return est;
						
		} catch (ClassNotFoundException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return null;
	}

}

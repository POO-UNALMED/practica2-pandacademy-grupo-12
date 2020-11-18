package gestorAplicacion.Persona;

import java.io.Serializable;
import java.util.*;

import gestorAplicacion.Horario;
import gestorAplicacion.Academico.*;

public class Profesor extends Persona implements Serializable {
  private ArrayList<Horario> asesoria = new ArrayList<>(); //Lista de horarios en los que el profesor puede atender.
  private Asignatura asignatura;
  private String detalles;

  public Profesor() {
    Semestre.profesores.add(this);
  }

  public Profesor(String nombre, String correo, String detalles, Asignatura asignatura) {
	this(nombre);
    this.correo = correo;
    this.detalles = detalles;
    this.asignatura = asignatura;
    Semestre.profesores.add(this);
  }

  public Profesor(String nombre) {
    this.nombre = nombre;
    Semestre.profesores.add(this);
  }

  public void setAsignatura(Asignatura asignatura) {
    this.asignatura = asignatura;
  }

  public Asignatura getAsignatura() {
    return asignatura;
  }

  public void setDetalles(String det) {
    detalles = det;
  }

  public String getDetalles() {
    return detalles;
  }

  public void setAsesoria() {
    asesoria.clear();
  }

  public void setAsesoria(Horario asesoria) {
    this.asesoria.add(asesoria);
  }

  public Horario getHorario(String dia) {
    for (int i = 0; i < asesoria.size(); i++) {
      if (asesoria.get(i).getDia().equalsIgnoreCase(dia)) {
        return asesoria.get(i);
      }
    }
    return null;
  }

  /**
   * Busca un profesor en la lista de profesores de los semestres.
   * @param nombre Nombre del profesor
   * @return Si existe el objeto, devuelve el objeto Profesor correspondiente. En caso contrario, devuelve <b>null</b>
   */
  public static Profesor Buscar(String nombre) {
    for (int i = 0; i < Semestre.profesores.size(); i++) {
      Profesor p = Semestre.profesores.get(i);
      if (p.getNombre().equalsIgnoreCase(nombre)) {
        return p;
      }
    }
    return null;
  }
  /**
   * Información del profesor.
   * @return Información básica del profesor (Nombre, Correo, Asignatura, Detalles)
   */
  public String toString() {
    String comp = "NOMBRE: " + this.nombre + "\n" + "CORREO: " + this.correo + "\n" + "ASIGNATURA: ";
    if (this.asignatura != null) {
      comp = comp + this.asignatura.getNombre() + "\n" + "DETALLES: " + this.detalles;
    }
    else{
      comp = comp + "\n" + "DETALLES: " + this.detalles;
    }
    return comp;
  }
}

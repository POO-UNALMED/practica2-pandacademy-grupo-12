package gestorAplicacion.Academico;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.Persona.*;

/**
 * Clase que representa las asignaturas del programa.
 * @author Cristian Londoño
 */

public class Asignatura implements Serializable, Calificacion {
  private int creditos;
  private String nombre;
  private Profesor profesor;
  private ArrayList<Nota> notas=new ArrayList<Nota>();   // Lista que guarda las notas de la asignatura
  private String detalles;

  // constructores
  public Asignatura() {
  }

  public Asignatura(int creditos, String nombre, Profesor p, String det) {
	this(creditos, nombre, det);
    this.profesor = p;
  }

  public Asignatura(int creditos, String nombre, String det) {
    this.creditos = creditos;
    this.nombre = nombre;
    this.detalles = det;
  }

  // metodos get y set
  public void setCreditos(int c) {
    this.creditos = c;
  }
  
  public boolean verfiPorcentaje( float porc,float nota) {
	  float c = 0;
      for (int i = 0; i < this.getNotas().size(); i++) {
        c = c + this.getNotas().get(i).getPorcentaje();
      }
      if ((c + porc) <= 1) {
        return false;
      } else {
    	  return true;
      }
  }

  public int getCreditos() {
    return this.creditos;
  }

  public void setNombre(String nom) {
    this.nombre = nom;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setProfesor(Profesor p) {
    this.profesor = p;
  }

  public Profesor getProfesor() {
    return this.profesor;
  }


  public void setDetalles(String text) {
    this.detalles = text;
  }

  public String getDetalles() {
    return this.detalles;
  }

  /**
   * Devuelve el estado de la asignatura.
   * @return Aprobada o No aprobada, junto a la nota de la asignatura.
   */

  public String estadoAsignatura() {
    if (!notas.isEmpty()) {
      float nota = this.promedio();
      if (nota >= 3.0) {
        return "Aprobada " + String.valueOf(nota);
      } else {
        return "No aprobada " + String.valueOf(nota);
      }
    }
    return "No aprobada 0.0";
  }

  /**
   * Muestra una lista de todas las notas de la asignatura.
   * @return Nombre y notas de la asignatura
   */
  public String mostrarNotas() {
    String comp = "Tus notas de " + this.nombre + " son:\n";
    for (int i = 0; i < notas.size(); i++) {
      comp = comp + notas.get(i).getNota() + " ";
    }
    return comp;
  }


public void agregarNota(Nota nota) {
	notas.add(nota);	
}

@Override
public ArrayList<Nota> getNotas() {
	return notas;
}

/**
 * Calcula el promedio de la asignatura.
 * @return Promedio de la asignatura
 */
@Override
public float promedio() {
	float cont = 0;
	for (int i = 0; i < notas.size(); i++) {
	  cont = cont + (notas.get(i).getNota() * notas.get(i).getPorcentaje());
	}
	return cont;

	}
}

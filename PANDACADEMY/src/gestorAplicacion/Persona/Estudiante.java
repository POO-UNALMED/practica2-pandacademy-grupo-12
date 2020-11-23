package gestorAplicacion.Persona;

import java.io.Serializable;
import java.util.*;

import gestorAplicacion.Academico.Semestre;


public class Estudiante extends Persona implements Serializable {
  private String planDeEstudio;
  private int creditosR; //Créditos requeridos del estudiante en su plan de estudios.
  private ArrayList<Semestre> semestres = new ArrayList<>();

  public Estudiante(long dni, String nombre, String correo) {
    super(dni,nombre,correo);
  }
  
  public Estudiante() {
	  semestres.add(new Semestre("semestre 0"));
}

public boolean asgAprobada(String nombre) {
	  boolean aux=true;
      for (int i = 0; i < this.getSemestres().size(); i++) {
          Semestre s = this.getSemestres().get(i);
          for (int j = 0; j < s.getAsignaturas().size(); j++) {
            if (s.getAsignatura(j).getNombre().equalsIgnoreCase(nombre)
                && s.getAsignatura(j).estadoAsignatura().indexOf("Aprobada") >= 0) {
              aux=false;
              break;
            }
          }
        }
      return aux;
  }
  
  public void setPlanDeEstudo(String planDeEstudio) {
    this.planDeEstudio = planDeEstudio;
  }

  public String getPlanDeEstudio() {
    return planDeEstudio;
  }

  public void setCreditosR(int c) {
    creditosR = c;
  }

  public int getCreditosR() {  
    return creditosR;
  }

  public ArrayList<Semestre> getSemestres() {
    return semestres;
  }

  public void addSemestre(Semestre semestre) {
    semestres.add(semestre);
    Collections.sort(semestres);
  }

  /**
  * Calcula el Promedio Aritmético Ponderado Acumulado (P.A.P.A) del estudiante.
  * @return PAPA del estudiante (float)
  */
  public float getPAPA() {
    float total = 0;
    int totalC=0;
    for (int i = 0; i < semestres.size(); i++) {
      Semestre s = semestres.get(i);
      total += s.promedioSemetre();
      totalC += s.totalCreditos();
    }
    total /= totalC;
    return total;
  }

  /**
   * Calcula el porcentaje de avance de carrera.
   * @return Porcentaje de avance (int)
   */
  public int avanceCarrera() {
    float avance = 0;
    int cap = 0;
    if (creditosR > 0) {
      for (Semestre semestre : semestres) {
        cap += semestre.creditosAprobados();
      }
      avance = (float) cap / creditosR;
      return Math.round(avance * 100);
    }
    return (int) avance;
  }

  public String toString() {
    String comp = "\nNOMBRE: " + this.getNombre() + "\nDOCUMENTO DE IDENTIDAD: " + this.getDni() + "\nCORREO: "
        + this.getCorreo() + "\n" + "PLAN DE ESTUDIOS: " + this.getPlanDeEstudio() + "\n";
    return comp;
  }

}

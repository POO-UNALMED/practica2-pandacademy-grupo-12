package gestorAplicacion;

import java.io.Serializable;

import gestorAplicacion.Academico.Asignatura;
/**
 * Objecto que representa un horario y guarda sus datos relevantes para su uso
 * 
 */
public class Horario implements Serializable {
  private String dia, horaInicio, horaFinal;
  private Asignatura asignatura;

  public Horario(String d, String i, String f) {
    dia = d;
    horaFinal = f;
    horaInicio = i;
  }

  public Horario(String d, String i, String f, Asignatura asg) {
    dia = d;
    horaFinal = f;
    horaInicio = i;
    asignatura = asg;
  }

  public String getDia() {
    return this.dia;
  }

  public String getInicio() {
    return this.horaInicio;
  }

  public String getFinal() {
    return this.horaFinal;
  }

  public String getAsignatString() {
    return this.asignatura.getNombre();
  }

  public String toString() {
    String horario = dia + "\n" + horaInicio + "\n" + horaFinal;
    return horario;
  }
  public Asignatura getAsignatura() {
	  return this.asignatura;
  }

}

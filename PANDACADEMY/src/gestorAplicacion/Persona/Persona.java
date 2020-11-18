package gestorAplicacion.Persona;

import java.io.Serializable;

public abstract class Persona implements Serializable {
  protected final long dni; //Documento Nacional de Identificación (Cédula de Ciudadanía, Cédula de Extranjería o Tarjeta de Identidad)
  protected String nombre;
  protected String correo;

  public Persona(long dni, String nombre, String correo) {
    this.dni = dni;
    this.nombre = nombre;
    this.correo = correo;
  }

  public Persona(){dni = 0;};

  public abstract String toString();
  
  public String getCorreo() {
    return correo;
  }

  public String getNombre() {
    return nombre;
  }

  public long getDni() {
    return dni;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;    
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }
}

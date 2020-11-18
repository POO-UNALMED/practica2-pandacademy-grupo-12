package gestorAplicacion.Academico;

import java.io.Serializable;
import java.util.*;

public interface Calificacion{

  public abstract void agregarNota(Nota nota);

  public abstract ArrayList<Nota> getNotas();
  
  public abstract float promedio();
}

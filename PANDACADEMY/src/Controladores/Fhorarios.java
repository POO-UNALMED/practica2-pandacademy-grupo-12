package Controladores;

import java.util.ArrayList;
import gestorAplicacion.Horario;
import gestorAplicacion.Academico.Semestre;

public class Fhorarios {
    public static boolean checkHorario(String dia, String h1, String h2, Semestre s) {
        ArrayList<Horario> horarios = s.getHorarios();
        boolean check = false;
        for (Horario horario : horarios) {
            if (horario.getDia().equalsIgnoreCase(dia)) {
                if (!horario.getInicio().equals(h1)) {
                    if (horario.getInicio().compareTo(h1) < 0) {
                        if (h1.compareTo(horario.getFinal()) >= 0) {
                            check = true;
                        } else {
                            return false;
                        }
                    } else {
                        if (h2.compareTo(horario.getInicio()) <= 0) {
                            check = true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            } else {
                check = true;
            }
        }
        return check;
    }
}

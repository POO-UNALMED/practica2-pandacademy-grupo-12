package Controladores;

import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.Estudiante;
import gestorAplicacion.Persona.Profesor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class Fasignatura {

    public boolean checkAsignatura(Estudiante est, String nombre, Semestre sa) {
        Estudiante e = est;
        boolean aux = true;
        for (int i = 0; i < e.getSemestres().size(); i++) {
            Semestre s = e.getSemestres().get(i);
            for (int j = 0; j < s.getAsignaturas().size(); j++) {
                if (s.getAsignatura(j).getNombre().equalsIgnoreCase(nombre)
                        && s.getAsignatura(j).estadoAsignatura().indexOf("Aprobada") >= 0) {
                    aux = false;
                    break;
                }
            }
        }
        if (aux) {
            for (int i = 0; i < sa.getAsignaturas().size(); i++) {
                if (sa.getAsignatura(i).getNombre().equalsIgnoreCase(nombre)) {
                    aux = false;
                    break;
                }
            }

        }
        return aux;
    }

    public void addAsignatura(Estudiante est, Semestre sa, int creditos, String nombre, Profesor profesor, String detalles) {
        if(checkAsignatura(est, nombre, sa)){
            sa.addAsignatura(new Asignatura(creditos, nombre, profesor, detalles));
        }
        else{
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setContentText("¡ESTA ASIGNATURA YA ESTA CREADA!");
            alerta.initStyle(StageStyle.UTILITY);
            alerta.showAndWait();
        }
    }
}

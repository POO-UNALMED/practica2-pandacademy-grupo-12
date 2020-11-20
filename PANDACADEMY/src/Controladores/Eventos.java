package Controladores;

import javafx.application.Platform;
import BaseDatos.*;
import gestorAplicacion.Persona.Estudiante;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class Eventos {

    /**
     * InnerEventos
     */
    public static class EventoDescripcion implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            Alert describe = new Alert(AlertType.INFORMATION);
            describe.setTitle("PANDACADEMY");
            describe.setHeaderText("Descripcion de la aplicacion:");
            describe.setContentText(LeerArchivo.leer("\\src\\recursos\\textos\\descripcion.txt"));
            describe.initStyle(StageStyle.UTILITY);
            describe.showAndWait();
        }

    }

    public static class EventoSalir implements EventHandler<ActionEvent> {

        Estudiante est;

        public EventoSalir(Estudiante est){
            this.est=est;
        }

        @Override
        public void handle(ActionEvent e){
            Serialization.serializarE(est);
            Platform.exit();
			System.exit(1);
        }
    }
    
    public static class EventoHojaVida implements EventHandler<ActionEvent> {
        String ruta;
        TextArea hojaVida;

        public EventoHojaVida(String ruta, TextArea area){
            this.ruta=ruta;
            hojaVida = area;
        }
        @Override
        public void handle(ActionEvent event) {
            hojaVida.clear();
			hojaVida.setText(LeerArchivo.leer(ruta));
        }
    }

}

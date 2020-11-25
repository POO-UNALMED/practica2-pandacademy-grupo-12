package paneles;

import Controladores.Fhorarios;
import gestorAplicacion.Horario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import vista.principal;

public class PanelHorarios {
	
	VBox prin = new VBox();
	Label titulo = new Label("HORARIO");
	Label desc= new Label("EN ESTA SECCION PODRAS VER TU HORARIO");
	GridPane hora= new GridPane();
	
	public PanelHorarios () {
		
		hora.prefWidthProperty().bind(prin.widthProperty());
		
		Label lunes = new Label("LUNES");
		hora.addColumn(0, lunes);
		lunes.prefWidthProperty().bind(hora.prefWidthProperty());
		lunes.setAlignment(Pos.CENTER);
		
		Label martes = new Label("MARTES");
		hora.addColumn(1, martes);
		martes.prefWidthProperty().bind(hora.prefWidthProperty());
		martes.setAlignment(Pos.CENTER);
		
		Label miercoles = new Label("MIERCOLES");
		hora.addColumn(2, miercoles);
		miercoles.prefWidthProperty().bind(hora.prefWidthProperty());
		miercoles.setAlignment(Pos.CENTER);
		
		
		Label jueves = new Label("JUEVES");
		hora.addColumn(3, jueves);
		jueves.prefWidthProperty().bind(hora.prefWidthProperty());
		jueves.setAlignment(Pos.CENTER);
		
		Label viernes = new Label("VIERNES");
		hora.addColumn(4, viernes);
		viernes.prefWidthProperty().bind(hora.prefWidthProperty());
		viernes.setAlignment(Pos.CENTER);
		
		Label sabado = new Label("SABADO");
		hora.addColumn(5, sabado);
		sabado.prefWidthProperty().bind(hora.prefWidthProperty());
		sabado.setAlignment(Pos.CENTER);
		
		
		for (int i =0; i< principal.sa.getHorarios().size(); i++) {
			Horario h = principal.sa.getHorario(i);
			Button asg= new Button(h.getAsignatura().getNombre().toUpperCase() + "\n \n" + 
					h.getInicio() + "\n"+ h.getFinal());
			asg.prefWidthProperty().bind(hora.widthProperty());
			asg.setPrefHeight(100);
			asg.setAlignment(Pos.CENTER);
			asg.setOnAction(event -> Fhorarios.EditHorario(h, asg, hora));
			if (h.getDia().equalsIgnoreCase("Lunes")) {
				hora.addColumn(0, asg);	
			}
			else if (h.getDia().equalsIgnoreCase("martes")) {
				hora.addColumn(1, asg);
			}
			else if (h.getDia().equalsIgnoreCase("miercoles")) {
				hora.addColumn(2, asg);
			}
			else if (h.getDia().equalsIgnoreCase("jueves")) {
				hora.addColumn(3, asg);
			}
			else if (h.getDia().equalsIgnoreCase("viernes")) {
				hora.addColumn(4, asg);
			}
			else if (h.getDia().equalsIgnoreCase("sabado")) {
				hora.addColumn(5, asg);
			}
		}
		
		Button agregarH = new Button ("AGREGAR HORARIO");
		agregarH.setOnAction(event -> Fhorarios.addHorario());

		hora.setVgap(10);
		hora.setHgap(40);
		titulo.setStyle("-fx-border-color: BLUE;");
		desc.setStyle("-fx-border-color: BLUE;");
		prin.setAlignment(Pos.TOP_CENTER);
		hora.setAlignment(Pos.CENTER);
		prin.setSpacing(10);
		prin.getChildren().addAll(titulo,desc,hora,agregarH);
		prin.setPadding(new Insets(10));
		
		prin.setStyle("-fx-background-color: #F4F4F4;");
		
	}
	
	public VBox getPanel() {
		return prin;
	}
}
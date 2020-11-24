package paneles;

import gestorAplicacion.Horario;
import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Academico.Semestre;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PanelHorarios {
	
	Semestre sa= new Semestre();
	
	VBox prin = new VBox();
	Label titulo = new Label("HORARIO");
	Label desc= new Label("EN ESTA SECCION PODRAS VER TU HORARIO");
	GridPane hora= new GridPane();
	
	public PanelHorarios () {
		
		Asignatura sss= new Asignatura();
		sss.setNombre("calculo");
		sa.addHorario(new Horario("martes","6:00", "8:00", sss));
		
		hora.prefWidthProperty().bind(prin.widthProperty());
		
		Label lunes = new Label("lunes");
		hora.addColumn(0, lunes);
		lunes.prefWidthProperty().bind(hora.prefWidthProperty());
		lunes.setAlignment(Pos.CENTER);
		
		Label martes = new Label("martes");
		hora.addColumn(1, martes);
		martes.prefWidthProperty().bind(hora.prefWidthProperty());
		martes.setAlignment(Pos.CENTER);
		
		Label miercoles = new Label("miercoles");
		hora.addColumn(2, miercoles);
		miercoles.prefWidthProperty().bind(hora.prefWidthProperty());
		miercoles.setAlignment(Pos.CENTER);
		
		
		Label jueves = new Label("jueves");
		hora.addColumn(3, jueves);
		jueves.prefWidthProperty().bind(hora.prefWidthProperty());
		jueves.setAlignment(Pos.CENTER);
		
		Label viernes = new Label("viernes");
		hora.addColumn(4, viernes);
		viernes.prefWidthProperty().bind(hora.prefWidthProperty());
		viernes.setAlignment(Pos.CENTER);
		
		Label sabado = new Label("sabado");
		hora.addColumn(5, sabado);
		sabado.prefWidthProperty().bind(hora.prefWidthProperty());
		sabado.setAlignment(Pos.CENTER);
		
		
		for (int i =0; i< sa.getHorarios().size();i++) {

			Button asg= new Button(sa.getHorario(i).getAsignatura().getNombre() + "\n \n" + 
					sa.getHorario(i).getInicio() + "\n"+ sa.getHorario(i).getFinal());
			asg.prefWidthProperty().bind(hora.widthProperty());
			asg.setPrefHeight(100);
			asg.setAlignment(Pos.CENTER);
			if (sa.getHorario(i).getDia()=="lunes") {
				hora.addColumn(0, asg);
				
			}
			else if (sa.getHorario(i).getDia()=="martes") {
				hora.addColumn(1, asg);
			}
			else if (sa.getHorario(i).getDia()=="miercoles") {
				hora.addColumn(2, asg);
			}
			else if (sa.getHorario(i).getDia()=="jueves") {
				hora.addColumn(3, asg);
			}
			else if (sa.getHorario(i).getDia()=="viernes") {
				hora.addColumn(4, asg);
			}
			else if (sa.getHorario(i).getDia()=="sabado") {
				hora.addColumn(5, asg);
			}
			
			
		
		}
		
		
		
		hora.setVgap(10);
		hora.setHgap(40);
		titulo.setStyle("-fx-border-color: BLUE;");
		desc.setStyle("-fx-border-color: BLUE;");
		prin.setAlignment(Pos.TOP_CENTER);
		hora.setAlignment(Pos.CENTER);
		prin.setSpacing(10);
		prin.getChildren().addAll(titulo,desc,hora);

		
		
		
	}
	
	public VBox getPanel() {
		return prin;
	}
}
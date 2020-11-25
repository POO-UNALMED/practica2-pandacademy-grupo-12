package paneles;

import gestorAplicacion.Horario;
import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Academico.Semestre;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelHorarios {
	
	Semestre sa= new Semestre();
	
	VBox prin = new VBox();
	Label titulo = new Label("HORARIO");
	Label desc= new Label("EN ESTA SECCION PODRAS VER TU HORARIO");
	GridPane hora= new GridPane();
	
	public PanelHorarios () {
		
		Asignatura sss= new Asignatura();
		sss.setNombre("algebra");
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
			
	        String[] criterios = new String[] { "ASIGNATURA","DIA", "HORA INICIO", "HORA FINAL"};
	        String[] valores = new String[] { sa.getHorario(i).getAsignatString(),sa.getHorario(i).getDia(),sa.getHorario(i).getInicio(),
	                sa.getHorario(i).getFinal() };
	        boolean[] habilitados = new boolean[] { false, true, true, true };
	        FieldPanel datosbasicos = new FieldPanel("DATOS", criterios, "", valores, habilitados);
			
			asg.setOnAction(event ->{
				Button guardar= new Button ("GUARDAR");
				Button borrar = new Button ("BORRAR");
				HBox butons= new HBox(guardar,borrar);
				butons.setSpacing(5);
				butons.setAlignment(Pos.CENTER);
				
				Label tit= new Label("EDITAR HORARIO");
				tit.setStyle("-fx-border-color: BLUE;");
				Label desc= new Label("AQUI PODRAS MODIFICAR EL HORARIO DE CLASE DE LA ASIGNATURA");
				desc.setStyle("-fx-border-color: BLUE;");
				
		        datosbasicos.getP().setVgap(10);
		        datosbasicos.getP().setHgap(10);
		        datosbasicos.getP().setAlignment(Pos.CENTER);
		        VBox total= new VBox(tit,desc,datosbasicos.getP(),butons);
		        total.setAlignment(Pos.CENTER);
		        total.setSpacing(10);
		        
		        total.setPadding(new Insets(10));
				Scene edit= new Scene(total);
				
				Stage edit1 = new Stage();
				edit1.setScene(edit);
				edit1.setResizable(false);
				edit1.show();
			
			});
		
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
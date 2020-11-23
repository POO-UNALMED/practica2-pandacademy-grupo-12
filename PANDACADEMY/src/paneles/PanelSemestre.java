package paneles;

import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.Estudiante;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class PanelSemestre {
	
	Estudiante est= new Estudiante();
	Button agregar= new Button("AGREGAR");
	Button borrar= new Button("BORRAR");
	Label titulo= new Label("SEMESTRES");
	Label desc= new Label("EN ESTA SECCION CAMBIAR DE SEMESTRE, AGREGAR NUEVOS SEMESTRES Y BORRAR SEMESTRES \n\nClick en el semestre para cambiar de semestre");
	
	GridPane principal = new GridPane();
	
	public PanelSemestre(){
		
		est.addSemestre(new Semestre("semestre 1"));
		est.addSemestre(new Semestre("semestre 2"));
		principal.setAlignment(Pos.CENTER);
		desc.setStyle("-fx-border-color: BLUE;");
		titulo.setStyle("-fx-border-color: BLUE;");
		principal.setVgap(20);
		principal.setHgap(20);
		VBox cajabot= new VBox();
		cajabot.setSpacing(10);
		for (int i=0; i<est.getSemestres().size();i++) {
			Button boton= new Button(est.getSemestres().get(i).getNombre());
			cajabot.getChildren().add(boton);
						
		}
		
		HBox s= new HBox(agregar,borrar);
		s.setSpacing(10);
		s.setAlignment(Pos.CENTER);
		
		principal.addColumn(0, titulo,desc,cajabot,s);
	}
	
	public GridPane getPanel() {
		return principal;
	}

}

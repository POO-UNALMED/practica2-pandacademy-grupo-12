package paneles;

import java.util.ArrayList;
import gestorAplicacion.Academico.*;
import gestorAplicacion.Persona.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelAsignatura {
	
	
	
	
	Estudiante estudent = new Estudiante();
	Semestre semestreActual = new Semestre();
	ArrayList<Button> botonesAsg= new ArrayList<Button>();
	
	GridPane prin= new GridPane();
	GridPane principal= new GridPane();
	ScrollPane scroll= new ScrollPane(principal);
	
	VBox cajaBotones= new VBox();  //VBox que contiene las asignaturas
	
	Label titulo = new Label("ASIGNATURAS");
	Label desc = new Label("EN ESTA SECCION PODRAS VER TUS ASIGNATURAS INSCRITAS,\n AGREGAR NUEVAS ASIGNATURAS Y BORRARLAS");
	
	Button agregarasg= new Button("AGREGAR");
	Button borrarasg= new Button("BORRAR");
	
	public PanelAsignatura(){
		
		
		principal.setVgap(30);
		principal.setHgap(20);
		titulo.setStyle("-fx-border-color: BLUE;");
		desc.setStyle("-fx-border-color: BLUE;");
		VBox t= new VBox(titulo);
		t.setAlignment(Pos.CENTER);
		VBox d=new VBox(desc);
		d.setAlignment(Pos.CENTER);
		
		semestreActual.addAsignatura(new Asignatura(4,"calculo"," ninguna"));  
		semestreActual.addAsignatura(new Asignatura(4,"algebra"," ninguna"));
	
		
		
		for (int i=0; i< semestreActual.getAsignaturas().size();i++) {
			
			Asignatura asg= semestreActual.getAsignatura(i);
			
			asg.agregarNota(new Nota((float) 4.0,(float) 0.5));
			asg.agregarNota(new Nota((float) 4.0,(float) 0.5));
			//asg.agregarNota(new Nota((float) 4.0,(float) 0.5));
			Button boton= new Button(asg.getNombre());
			
			HBox cajanotas= new HBox(); 
			cajanotas.setSpacing(10);

			
			for (int j=0;j<asg.getNotas().size();j++) {  //añadir las notas
				Label note= new Label(Float.toString(asg.getNotas().get(j).getNota()));
				cajanotas.getChildren().add(note);
			}
			
			boton.setOnAction(new NuevaVentana(asg));

			
			cajaBotones.getChildren().addAll(boton,cajanotas);
			botonesAsg.add(boton); // se añaden los botones de cada asignatura a una lista
			
		}

		HBox botones=new HBox(agregarasg,borrarasg);
		botones.setSpacing(10);
		botones.setAlignment(Pos.CENTER);
		cajaBotones.setSpacing(10);
		principal.addColumn(0,t,d,cajaBotones,botones);
		principal.setAlignment(Pos.CENTER);
		
		prin.addColumn(0, scroll);
		prin.setAlignment(Pos.CENTER);
		scroll.setPadding(new Insets(10));
	

		

	}
	
	public GridPane getPanel() {
		
		return prin;
	}
	
	class NuevaVentana implements EventHandler<ActionEvent>{
		Asignatura asg;
		NuevaVentana(Asignatura asg){
			this.asg=asg;
		}
		@Override
		public void handle(ActionEvent arg0) {
			Stage v= new Stage();
			Scene s= new Scene(new Label(asg.getNombre()),300,500);
			
			
			v.setScene(s);
			v.show();
			
		}
		
	}
	

}

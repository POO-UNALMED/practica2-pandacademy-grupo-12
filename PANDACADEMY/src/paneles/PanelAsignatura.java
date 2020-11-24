package paneles;

import java.util.ArrayList;

import Controladores.Fasignatura;
import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Academico.Nota;
import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.Estudiante;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.principal;

public class PanelAsignatura {
	
	ArrayList<Button> botonesAsg= new ArrayList<Button>();
	ArrayList<Button> papelera= new ArrayList<Button>();
	
	GridPane prin= new GridPane();
	GridPane root= new GridPane();
	ScrollPane scroll= new ScrollPane(root);
	
	VBox cajaBotones= new VBox();  //VBox que contiene las asignaturas
	
	Label titulo = new Label("ASIGNATURAS");
	Label desc = new Label("EN ESTA SECCION PODRAS VER TUS ASIGNATURAS INSCRITAS,\n AGREGAR NUEVAS ASIGNATURAS Y BORRARLAS");
	
	Button agregarasg= new Button("AGREGAR");
	Button borrarasg= new Button("BORRAR");
	
	public PanelAsignatura(){
		
		agregarasg.setOnAction(event -> {Fasignatura.addAsignatura();});
		
		root.setVgap(30);
		root.setHgap(20);
		titulo.setStyle("-fx-border-color: BLUE;");
		desc.setStyle("-fx-border-color: BLUE;");
		VBox t= new VBox(titulo);
		t.setAlignment(Pos.CENTER);
		VBox d=new VBox(desc);
		d.setAlignment(Pos.CENTER);
		
		for (int i=0; i< principal.sa.getAsignaturas().size();i++) {
			
			Asignatura asg= principal.sa.getAsignatura(i);

			Button boton= new Button(asg.getNombre());
			
			HBox asigyprom= new HBox(boton, new Label(String.valueOf(asg.estadoAsignatura())));
			asigyprom.setSpacing(60);
			
			HBox cajanotas= new HBox(); 
			cajanotas.setSpacing(15);

			
			for (int j=0;j<asg.getNotas().size();j++) {  //añadir las notas
				Label note= new Label(Float.toString(asg.getNotas().get(j).getNota()));
				cajanotas.getChildren().add(note);
			}
			
			boton.setOnAction(event -> {Fasignatura.PanelEdit(asg);});
			
			VBox cajaAsig= new VBox(); //VBOX QUE CONTIENE TODAS EL BOTON, LAS NOTA Y EL PROMEDIO 
			cajaAsig.getChildren().addAll(asigyprom,cajanotas);
			cajaBotones.getChildren().addAll(cajaAsig);
			botonesAsg.add(boton); // se añaden los botones de cada asignatura a una lista
			
		}

		HBox botones=new HBox(agregarasg,borrarasg);
		botones.setSpacing(10);
		botones.setAlignment(Pos.CENTER);
		cajaBotones.setSpacing(10);
		root.addColumn(0,t,d,cajaBotones,botones);
		root.setAlignment(Pos.CENTER);
		
		prin.addColumn(0, scroll);
		prin.setAlignment(Pos.CENTER);
		scroll.setPadding(new Insets(10));

	}
	
	public GridPane getPanel() {
		return prin;
	}
	
}
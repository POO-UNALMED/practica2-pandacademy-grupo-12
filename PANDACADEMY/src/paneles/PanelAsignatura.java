package paneles;

import java.util.ArrayList;

import Controladores.Fasignatura;
import gestorAplicacion.Academico.Asignatura;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
			
			BorderPane asigyprom = new BorderPane();
			asigyprom.setCenter(new Label(String.valueOf(asg.estadoAsignatura())));
			asigyprom.setLeft(boton);
			
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
			cajaBotones.setAlignment(Pos.CENTER);
			botonesAsg.add(boton); // se añaden los botones de cada asignatura a una lista
			
		}

		agregarasg.prefWidthProperty().bind(root.widthProperty());
		cajaBotones.setSpacing(10);
		root.addColumn(0,t,d,cajaBotones,agregarasg);
		root.setAlignment(Pos.CENTER);
		
		prin.addColumn(0, scroll);
		prin.setAlignment(Pos.CENTER);
		scroll.setPadding(new Insets(10));

		root.prefWidthProperty().bind(prin.widthProperty());
		root.prefHeightProperty().bind(prin.heightProperty());

		prin.setStyle("-fx-background-color: #F4F4F4;");

	}
	
	public GridPane getPanel() {
		return prin;
	}
	
}
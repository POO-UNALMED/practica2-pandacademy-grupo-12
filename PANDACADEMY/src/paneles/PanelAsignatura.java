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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelAsignatura {
	
	
	
	
	Estudiante estudent = new Estudiante();
	Semestre semestreActual = new Semestre();
	ArrayList<Button> botonesAsg= new ArrayList<Button>();
	
	GridPane prin= new GridPane();
	GridPane root= new GridPane();
	ScrollPane scroll= new ScrollPane(root);
	
	VBox cajaBotones= new VBox();  //VBox que contiene las asignaturas
	
	Label titulo = new Label("ASIGNATURAS");
	Label desc = new Label("EN ESTA SECCION PODRAS VER TUS ASIGNATURAS INSCRITAS,\n AGREGAR NUEVAS ASIGNATURAS Y BORRARLAS");
	
	Button agregarasg= new Button("AGREGAR");
	Button borrarasg= new Button("BORRAR");
	
	public PanelAsignatura(){
		
		
		root.setVgap(30);
		root.setHgap(20);
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
			
			asg.agregarNota(new Nota((float) 0.5,(float) 4));
			asg.agregarNota(new Nota((float) 0.25,(float) 3.2));
			asg.agregarNota(new Nota((float) 0.25,(float) 2));
			Button boton= new Button(asg.getNombre());
			
			HBox asigyprom= new HBox(boton, new Label(String.valueOf(asg.estadoAsignatura())));
			asigyprom.setSpacing(60);
			
			HBox cajanotas= new HBox(); 
			cajanotas.setSpacing(15);

			
			for (int j=0;j<asg.getNotas().size();j++) {  //añadir las notas
				Label note= new Label(Float.toString(asg.getNotas().get(j).getNota()));
				cajanotas.getChildren().add(note);
			}
			
			
			
			boton.setOnAction(new NuevaVentana(asg));
			
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
	
	class NuevaVentana implements EventHandler<ActionEvent>{
		Asignatura asg;
		NuevaVentana(Asignatura asg){
			this.asg=asg;
		}
		@Override
		public void handle(ActionEvent e) {
			
			Button guardar= new Button("GUARDAR");
			Button cancelar = new Button("CANCELAR");
			guardar.setAlignment(Pos.CENTER_RIGHT);
			Button agregarnotas= new Button("AGREGAR NOTAS");
			
			
			
			Label Tit= new Label(asg.getNombre().toUpperCase());
			Label desc = new Label("EN ESTA VENTANA PODRAS EDITAR LOS DATOS DE TU ASIGNATURA");			
			desc.setStyle("-fx-border-color: BLUE;");
			Tit.setStyle("-fx-border-color: BLUE;");
			
			String profesor="";
			if (asg.getProfesor()!=null) {
				profesor=asg.getProfesor().getNombre();
			}
			
			String[] criterios = new String[] {"NOMBRE","PROFESOR","DETALLES","CREDITOS"};
			String[] valores = new String[] { asg.getNombre(), profesor,asg.getDetalles(),String.valueOf(asg.getCreditos())};
			boolean[] habilitados = new boolean[] {true,true,true,true};
			FieldPanel datosbasicos= new FieldPanel("DATOS BASICOS",criterios, "", valores, habilitados);
			datosbasicos.getP().setVgap(10);
			
			
			GridPane notas= new GridPane();
			
			notas.setVgap(10);
			notas.setHgap(10);
			notas.addColumn(1, agregarnotas);
			notas.addColumn(0, new Label(""));
			notas.addColumn(2, new Label(""));
			notas.addColumn(0, new Label("periodos"));
			notas.addColumn(1, new Label("notas"));
			notas.addColumn(2, new Label("porcentaje"));
			
			for (int i=0; i<asg.getNotas().size();i++) {
				
				notas.addColumn(0,new Label(" PERIODO "+i));
				TextField n= new TextField(String.valueOf(asg.getNotas().get(i).getNota()));
				notas.addColumn(1, n);
				TextField p= new TextField(String.valueOf(asg.getNotas().get(i).getPorcentaje()));
				notas.addColumn(2, p);
			}
			notas.addColumn(1,guardar);
			
			HBox botonesprin= new HBox(guardar,cancelar);
			botonesprin.setAlignment(Pos.CENTER);
			botonesprin.setSpacing(10);
			GridPane root= new GridPane();
			root.setVgap(30);
			root.addColumn(0, Tit,desc,datosbasicos.getP(),notas,botonesprin);
			ScrollPane scroll= new ScrollPane(root);
			scroll.setPadding(new Insets(10));
			Stage v= new Stage();
			Scene s= new Scene(scroll,450,500);
			
			v.setResizable(false);	
			v.setScene(s);
			v.show();
			
		}
		
	}
	
}
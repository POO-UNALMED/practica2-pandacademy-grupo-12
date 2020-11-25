package paneles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class PanelInicio {
	
	BorderPane pane = new BorderPane();
	
	GridPane instrucciones = new GridPane();
	Button botonPerfil = new Button("Perfil");
	Button botonAsignaturas = new Button("Asignaturas");
	Button botonCalcularPAPA = new Button("Calcular P.A.P.A");
	Button botonHorario = new Button("Horario");
	Button botonProfesores = new Button("Profesores");
	Button botonSemestres = new Button("Semestres");
	
	Label inicio = new Label("Inicio - Instrucciones");
	
	public PanelInicio() {
		BackgroundImage fondo= new BackgroundImage(new Image("/recursos/Frame4.png"),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
		          new BackgroundSize(100, 100, true, true, true, false));
		
		pane.setBackground(new Background(fondo));
		
		
		pane.setTop(inicio);
		inicio.setAlignment(Pos.CENTER);
		inicio.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,new CornerRadii(5.0), new Insets(-5.0))));
		BorderPane.setAlignment(inicio, Pos.CENTER);
		inicio.setFont(new Font("Arial", 24));
		pane.setPadding(new Insets(10));
		inicio.setMaxWidth(5000);
		
		pane.setCenter(instrucciones);
		instrucciones.setAlignment(Pos.CENTER);
		instrucciones.setVgap(30);
		instrucciones.setHgap(15);
		instrucciones.setPadding(new Insets(25, 25, 25, 25));
		instrucciones.add(botonPerfil, 0, 0);						
		instrucciones.add(botonAsignaturas, 1, 0);				
		instrucciones.add(botonCalcularPAPA, 2, 0);			
		instrucciones.add(botonHorario, 0, 1);					
		instrucciones.add(botonProfesores, 1, 1);				
		instrucciones.add(botonSemestres, 2, 1);				
		
		botonSemestres.setPrefSize(150, 50);
		botonProfesores.setPrefSize(150, 50);
		botonHorario.setPrefSize(150, 50);	
		botonCalcularPAPA.setPrefSize(150, 50);	
		botonAsignaturas.setPrefSize(150, 50);
		botonPerfil.setPrefSize(150, 50);
		
		botonPerfil.setStyle("-fx-font-size:15");
		botonAsignaturas.setStyle("-fx-font-size:15");
		botonCalcularPAPA.setStyle("-fx-font-size:15");
		botonHorario.setStyle("-fx-font-size:15");
		botonProfesores.setStyle("-fx-font-size:15");
		botonSemestres.setStyle("-fx-font-size:15");
		
		
	}
	
	
	
	public BorderPane getPanel() {
		return pane;
	}
}

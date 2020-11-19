package vista;

import java.awt.Font;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VentanaInicio extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {
		
		/**
		 * creacion del panel principal
		 */
		GridPane principal= new GridPane();    
		GridPane p1= new GridPane();
		p1.setPadding(new Insets(5,10,10,10));
		p1.setVgap(50);
		
		/**
		 * saludo de bienvenidad + panel inicio de la aplicacion
		 */
		Image imageWelcome = new Image("/recursos/welcome.png");
		ImageView n = new ImageView(imageWelcome);
		n.setFitHeight(200);
		n.setFitWidth(400);
		
		GridPane inicioApp= new GridPane();
		inicioApp.setPadding(new Insets(15,15,25,15));
		inicioApp.setAlignment(Pos.CENTER);
		inicioApp.setVgap(40);
		inicioApp.setStyle("-fx-background-color: GRAY;");
		
		
		Image logo1 = new Image("/recursos/Group 2.png");
		ImageView logo = new ImageView(logo1);
		logo.setFitHeight(300);
		logo.setFitWidth(350);

		Button boton = new Button("INICIO");
		boton.setScaleX(4);
		boton.setScaleY(2);
		
		inicioApp.add(logo, 0, 0);
		inicioApp.add(boton, 0, 1);
		
		inicioApp.setHalignment(boton, HPos.CENTER);
		p1.add(n, 0, 0);
		p1.add(inicioApp, 0, 1);
		
		principal.add(p1,0,0);
		
		/**
		 * panel con las fotos y la hoja de vida de los creadores
		 */
		GridPane autores = new GridPane();
		autores.setPadding(new Insets(5,10,10,10));
		autores.setVgap(70);
		
		
		TextArea hojaVida= new TextArea("\r\n"
				+ "Patrick Galen Dempsey es un actor estadounidense \ny piloto de carreras, más conocido por su papel como el neurocirujano Derek \"McDreamy\" Shepherd en Grey's Anatomy.\n Tuvo un éxito temprano como actor, protagonizando una serie de películas\n en la década de 1980");
		hojaVida.setEditable(false);	
		autores.add(hojaVida, 0, 0);
		
		
		
		
		GridPane fotoAutores=new GridPane();
		
		Image foto1=new Image(getClass().getResourceAsStream("/recursos/fotos/Screen02.png"));
		ImageView view1 =new ImageView(foto1);
		view1.setFitHeight(200);
		view1.setFitWidth(200);
		Button juanP=new Button("",view1);

		
		Button cristian=new Button("asd");

		
		Button jhonatan=new Button("asdad");

		
		Button Brian=new Button("asdas");

		
		fotoAutores.add(juanP, 0, 0);
		fotoAutores.add(cristian, 0, 1);
		fotoAutores.add(jhonatan, 1, 0);
		fotoAutores.add(Brian, 1, 1);
		
		autores.add(fotoAutores, 0, 1);
		
		principal.add(autores, 1, 0);
		
		Scene primary= new Scene(principal,800,700);
		window.setScene(primary);
		window.setResizable(false);
		window.setTitle("Ventana de inicio");
		window.show();
		
		
		
	}

}

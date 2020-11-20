package vista;

import Controladores.Eventos.EventoDescripcion;
import Controladores.Eventos.EventoHojaVida;
import Controladores.Eventos.EventoSalir;
import gestorAplicacion.Persona.Estudiante;
import Controladores.Eventos.EventoDescripcion;
import Controladores.LeerArchivo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VentanaInicio extends Application {

	Estudiante est;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {

		javafx.scene.text.Font fuente = new javafx.scene.text.Font("Arial", 15);//archivo fuente
		/**
		 * creacion del menu
		 */
		MenuBar menu = new MenuBar();
		Menu Inicio = new Menu("Inicio");
		MenuItem salir = new MenuItem("salir");
		MenuItem descripcion = new MenuItem("descripcion");
		Inicio.getItems().addAll(descripcion, salir);
		menu.getMenus().add(Inicio);
		VBox top = new VBox(menu);

		/**
		 * control de eventos de la barra menu
		 */
		EventoSalir Esalir = new EventoSalir(est);
		salir.setOnAction(Esalir);
		EventoDescripcion Edescrip = new EventoDescripcion();
		descripcion.setOnAction(Edescrip);

		/**
		 * creacion del panel principal
		 */
		GridPane principal = new GridPane();

		GridPane p1 = new GridPane();
		p1.setPadding(new Insets(5, 10, 10, 10));
		p1.setVgap(50);

		/**
		 * saludo de bienvenidad + panel inicio de la aplicacion
		 */
		Image imageWelcome = new Image("/recursos/welcome.png");
		ImageView n = new ImageView(imageWelcome);
		n.setFitHeight(200);
		n.setFitWidth(400);

		GridPane inicioApp = new GridPane();
		inicioApp.setPadding(new Insets(15, 15, 25, 15));
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
		boton.setFont(fuente);

		inicioApp.add(logo, 0, 0);
		inicioApp.add(boton, 0, 1);

		inicioApp.setHalignment(boton, HPos.CENTER);
		p1.add(n, 0, 0);
		p1.add(inicioApp, 0, 1);

		principal.add(p1, 0, 0);

		/**
		 * configuracion del boton inicio
		 */

		boton.setOnAction(null);
		/**
		 * panel con las fotos y la hoja de vida de los creadores
		 */
		GridPane autores = new GridPane();
		autores.setPadding(new Insets(5, 10, 10, 10));
		autores.setVgap(70);

		TextArea hojaVida = new TextArea("Dar click en la foto de alguno de los creadores de esta app para ver una breve hoja de vida de cada uno.");
		hojaVida.setEditable(false);
		autores.add(hojaVida, 0, 0);
		hojaVida.setWrapText(true);
		hojaVida.setFont(fuente);

		/**
		 * creacion del gridpane con los autores del proyecto
		 */
		GridPane fotoAutores = new GridPane();

		Image foto1 = new Image(getClass().getResourceAsStream("/recursos/fotos/juan.png"));
		ImageView view1 = new ImageView(foto1);
		view1.setFitHeight(200);
		view1.setFitWidth(200);
		Button juanP = new Button("", view1);

		Image foto2 = new Image(getClass().getResourceAsStream("/recursos/fotos/cristian.png"));
		ImageView view2 = new ImageView(foto2);
		view2.setFitHeight(200);
		view2.setFitWidth(200);
		Button cristian = new Button("", view2);

		Image foto3 = new Image(getClass().getResourceAsStream("/recursos/fotos/jhonatan.png"));
		ImageView view3 = new ImageView(foto3);
		view3.setFitHeight(200);
		view3.setFitWidth(200);
		Button jhonatan = new Button("", view3);

		Image foto4 = new Image(getClass().getResourceAsStream("/recursos/fotos/jump.jpg"));
		ImageView view4 = new ImageView(foto4);
		view4.setFitHeight(200);
		view4.setFitWidth(200);
		Button Brian = new Button("", view4);

		fotoAutores.add(juanP, 0, 0);
		fotoAutores.add(cristian, 0, 1);
		fotoAutores.add(jhonatan, 1, 0);
		fotoAutores.add(Brian, 1, 1);

		autores.add(fotoAutores, 0, 1);
		principal.add(autores, 1, 0);

		/**
		 * mostrar hoja de vida al dar click en una foto
		 */
		EventoHojaVida HVcristian = new EventoHojaVida("\\src\\recursos\\textos\\cristian.txt",hojaVida);
		cristian.setOnAction(HVcristian);
		
		EventoHojaVida HVjuan = new EventoHojaVida("\\src\\recursos\\textos\\juan.txt",hojaVida);
		juanP.setOnAction(HVjuan);

		EventoHojaVida HVjhonatan = new EventoHojaVida("\\src\\recursos\\textos\\jhonatan.txt",hojaVida);
		jhonatan.setOnAction(HVjhonatan);

		EventoHojaVida HVbrian = new EventoHojaVida("\\src\\recursos\\textos\\brian.txt",hojaVida);
		Brian.setOnAction(HVbrian);
		/**
		 * creacion del Borderpane que contiene el gridpane y el menubar
		 */
		BorderPane root = new BorderPane();
		root.setTop(top);
		root.setCenter(principal);
		root.setStyle("-fx-background-color: GRAY;"); // color fondo

		Scene primary = new Scene(root, 875, 700);

		window.setScene(primary);
		window.setResizable(false);
		window.setTitle("Ventana de inicio");
		window.initStyle(StageStyle.UTILITY);

		window.show();

	}

}
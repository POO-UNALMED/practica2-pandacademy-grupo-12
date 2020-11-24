package vista;

import Controladores.LeerArchivo;
import gestorAplicacion.Persona.Estudiante;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

public class VentanaInicio {

	Estudiante est;
	Scene scene;
	Button boton;

	public VentanaInicio() {

		javafx.scene.text.Font fuente = new javafx.scene.text.Font("Arial", 15);// archivo fuente
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
		EventoSalir Esalir = new EventoSalir();
		salir.setOnAction(Esalir);
		EventoDescripcion Edescrip = new EventoDescripcion();
		descripcion.setOnAction(Edescrip);

		/**
		 * creacion del panel root
		 */
		GridPane root = new GridPane();

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

		boton = new Button("INICIO");
		boton.setScaleX(4);
		boton.setScaleY(2);
		boton.setFont(fuente);

		inicioApp.add(logo, 0, 0);
		inicioApp.add(boton, 0, 1);

		inicioApp.setHalignment(boton, HPos.CENTER);
		p1.add(n, 0, 0);
		p1.add(inicioApp, 0, 1);

		root.add(p1, 0, 0);

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

		TextArea hojaVida = new TextArea(
				"Dar click en la foto de alguno de los creadores de esta app para ver una breve hoja de vida de cada uno.");
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
		root.add(autores, 1, 0);

		/**
		 * mostrar hoja de vida al dar click en una foto
		 */
		EventoHojaVida HVcristian = new EventoHojaVida("\\src\\recursos\\textos\\cristian.txt", hojaVida);
		cristian.setOnAction(HVcristian);

		EventoHojaVida HVjuan = new EventoHojaVida("\\src\\recursos\\textos\\juan.txt", hojaVida);
		juanP.setOnAction(HVjuan);

		EventoHojaVida HVjhonatan = new EventoHojaVida("\\src\\recursos\\textos\\jhonatan.txt", hojaVida);
		jhonatan.setOnAction(HVjhonatan);

		EventoHojaVida HVbrian = new EventoHojaVida("\\src\\recursos\\textos\\brian.txt", hojaVida);
		Brian.setOnAction(HVbrian);
		/**
		 * creacion del Borderpane que contiene el gridpane y el menubar
		 */
		BorderPane root2 = new BorderPane();
		root2.setTop(top);
		root2.setCenter(root);
		root2.setStyle("-fx-background-color: GRAY;"); // color fondo

		scene = new Scene(root2, 875, 700);
	}

	/**
	 * Evento para finalizar el programa
	 */
	class EventoSalir implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			Platform.exit();
			System.exit(1);
		}
	}

	class EventoDescripcion implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            Alert describe = new Alert(AlertType.INFORMATION);
            describe.setTitle("PANDACADEMY");
            describe.setHeaderText(null);
            describe.setContentText(LeerArchivo.leer("\\src\\recursos\\textos\\descripcion.txt"));
			describe.initStyle(StageStyle.UTILITY);
            describe.showAndWait();
        }

    }
    
    class EventoHojaVida implements EventHandler<ActionEvent> {
        String ruta;
        TextArea hojaVida;

        public EventoHojaVida(String ruta, TextArea area){
            this.ruta=ruta;
            hojaVida = area;
        }
        @Override
        public void handle(ActionEvent event) {
            hojaVida.clear();
			hojaVida.setText(LeerArchivo.leer(ruta));
        }
    }

}
package vista;



import Controladores.LeerArchivo;
import gestorAplicacion.Persona.Estudiante;
import paneles.FieldPanel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class principal extends Application {
	
	public static Estudiante e = new Estudiante();
	
	public VentanaInicio p= new VentanaInicio();
	public VentanaUsuario p1= new VentanaUsuario();
	
	public static Estudiante getEstudiante() {
		return e;
	}

	@Override
	public void start(Stage window) throws Exception {
	
		p.getBoton().setOnAction(event ->{       // p.getBoton() obtiene el boton Inicio de la Ventana de inicio
			
			window.setScene(p1.getScene());
			window.setResizable(true);
			window.setTitle("Ventana de Usuario");			
			p1.getnombre().setCenter(new Pane());
			

		});
		
		p1.getsalir().setOnAction(event ->{    // p1.getSalir() obtiene el menutiem salir de la ventana de usuario
			window.setScene(p.getScene());
			window.setResizable(false);
			window.setTitle("Ventana de inicio");
		});
		
		
		window.setScene(p.getScene());
		window.setResizable(false);
		window.setTitle("Ventana de inicio");
		window.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}

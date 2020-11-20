package vista;

import Controladores.LeerArchivo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class principal extends Application {
	
	VentanaInicio p= new VentanaInicio();
	VentanaUsuario p1= new VentanaUsuario();


	@Override
	public void start(Stage window) throws Exception {
		
		p.getBoton().setOnAction(event ->{       // p.getBoton() obtiene el boton Inicio de la Ventana de inicio
			window.setScene(p1.getScene());
			window.setResizable(true);
			window.setTitle("Ventana de Usuario");
			

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

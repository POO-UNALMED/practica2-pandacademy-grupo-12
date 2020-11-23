package vista;

import Controladores.Eventos.ChangeStage;
import javafx.application.Application;
import javafx.stage.Stage;
import paneles.EditarProfesor;

public class principal extends Application {
	
	
	
	VentanaInicio p= new VentanaInicio();
	VentanaUsuario p1= new VentanaUsuario();
	EditarProfesor teachers1 = new EditarProfesor();

	@Override
	public void start(Stage window) throws Exception {
		
		ChangeStage startApp = new ChangeStage(p1.user, window);
		p.boton.setOnAction(startApp);
		
		ChangeStage exitReturn = new ChangeStage(p.scene, window);
		p1.salir.setOnAction(exitReturn);

		//ChangeStage EditTeacher = new ChangeStage(teachers1.scene,window);
		//p1.editarProfesores.setOnAction(EditTeacher);
		
		window.setScene(p.scene);
		window.setResizable(false);
		window.setTitle("PANDACADEMY");
		window.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}

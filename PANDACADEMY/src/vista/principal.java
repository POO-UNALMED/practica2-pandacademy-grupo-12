package vista;

import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.Estudiante;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import paneles.*;
import BaseDatos.*;

public class principal extends Application {

	

	
	
	public static Estudiante estudiante = new Estudiante();
	public static Semestre sa = estudiante.getSemestres().get(estudiante.getSemestres().size() - 1); // ultimo semestre
	VentanaInicio p = new VentanaInicio();
	VentanaUsuario p1 = new VentanaUsuario();
	
	@Override
	public void start(Stage window) throws Exception {

		ChangeStage startApp = new ChangeStage(p1.user, window);
		p.boton.setOnAction(startApp);

		ChangeStage exitReturn = new ChangeStage(p.scene, window);
		p1.salir.setOnAction(exitReturn);

		Handler evento = new Handler();
		p1.semestres.setOnAction(evento);
		p1.editarPerfil.setOnAction(evento);
		p1.profesores.setOnAction(evento);
		p1.mostrarPerfil.setOnAction(evento);
		p1.asignatura.setOnAction(evento);
		p1.calcularPAPA.setOnAction(evento);

		// ChangeStage EditTeacher = new ChangeStage(teachers1.scene,window);
		// p1.editarProfesores.setOnAction(EditTeacher);

		window.setScene(p.scene);
		window.setResizable(false);
		window.setTitle("PANDACADEMY");
		window.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

	/**
	 * Evento para cambiar el escenario de la ventana
	 */
	class ChangeStage implements EventHandler<ActionEvent> {

		Scene newImplements;
		Stage primaryFrame;

		public ChangeStage(Scene implement, Stage window) {
			newImplements = implement;
			primaryFrame = window;
		}

		@Override
		public void handle(ActionEvent event) {
			if (event.getEventType().equals(p.boton)) {
				estudiante = Deserialization.deserializarE();
			} else if (event.getSource().equals(p1.salir)) {
				Serialization.serializarE(estudiante);
			}
			primaryFrame.setScene(newImplements);
			primaryFrame.setResizable(false);

		}
	}

	/**
	 * Eventos controladores del menu de la vista de usuario
	 */

	class Handler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			Object control = e.getSource();

			if (control.equals(p1.editarPerfil)) {
				PanelEditP editp = new PanelEditP();
				p1.nombre.setCenter(editp.getPanel());

			} else if (control.equals(p1.mostrarPerfil)) {
				MostrarPerfil mostrarp = new MostrarPerfil();
				p1.nombre.setCenter(mostrarp.getPanel());
			}

			else if (control.equals(p1.asignatura)) {
				PanelAsignatura asig = new PanelAsignatura();
				p1.nombre.setCenter(asig.getPanel());
			}

			else if (control.equals(p1.profesores)) {
				
				ListaProfesores listaP = new ListaProfesores(sa.getProfesorList());
				ScrollPane s = new ScrollPane(listaP.getPanel());
				s.setPadding(new Insets(10));
				p1.nombre.setCenter(s);

			} else if (control.equals(p1.semestres)) {
				PanelSemestre semest = new PanelSemestre();
				p1.nombre.setCenter(semest.getPanel());

			} else if (control.equals(p1.calcularPAPA)){
				Alert papa = new Alert(AlertType.INFORMATION);
				papa.setTitle("P.A.P.A");
				papa.setHeaderText(null);
				papa.setContentText("Tu P.A.P.A actual es: "+estudiante.getPAPA());
				papa.showAndWait();
			}

		}

	}

}

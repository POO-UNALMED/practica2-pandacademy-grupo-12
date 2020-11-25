package vista;

import BaseDatos.Deserialization;
import BaseDatos.Serialization;
import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.Estudiante;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import paneles.ListaProfesores;
import paneles.MostrarPerfil;
import paneles.PanelAsignatura;
import paneles.PanelEditP;
import paneles.PanelHorarios;
import paneles.PanelSemestre;

public class principal extends Application {

	public static Estudiante estudiante = Deserialization.deserializarE();
	public static Semestre sa = estudiante.getSemestres().get(estudiante.getSemestres().size() - 1); // ultimo semestre
	VentanaInicio p = new VentanaInicio();
	VentanaUsuario p1 = new VentanaUsuario();

	@Override
	public void start(Stage window) throws Exception {

		ChangeStage cambStage = new ChangeStage(p, p1, window);

		p.boton.setOnAction(cambStage);
		p1.salir.setOnAction(cambStage);

		Handler evento = new Handler();
		p1.semestres.setOnAction(evento);
		p1.editarPerfil.setOnAction(evento);
		p1.profesores.setOnAction(evento);
		p1.mostrarPerfil.setOnAction(evento);
		p1.asignatura.setOnAction(evento);
		p1.calcularPAPA.setOnAction(evento);
		p1.horario.setOnAction(evento);

		// ChangeStage EditTeacher = new ChangeStage(teachers1.scene,window);
		// p1.editarProfesores.setOnAction(EditTeacher);

		window.setScene(p.scene);
		window.setResizable(false);
		window.setTitle("PANDACADEMY");
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
		Serialization.serializarE(principal.estudiante);
	}

	/**
	 * Evento para cambiar el escenario de la ventana
	 */
	class ChangeStage implements EventHandler<ActionEvent> {

		VentanaInicio SceneInicio;
		VentanaUsuario SceneUser;
		Stage primaryFrame;

		public ChangeStage(VentanaInicio implement, VentanaUsuario implement2, Stage window) {
			SceneInicio = implement;
			SceneUser = implement2;
			primaryFrame = window;
		}

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource().equals(SceneInicio.boton)) {
				principal.estudiante = Deserialization.deserializarE();
				primaryFrame.setScene(SceneUser.user);
				primaryFrame.setResizable(false);

			} else if (event.getSource().equals(SceneUser.salir)) {
				Serialization.serializarE(principal.estudiante);
				SceneUser.nombre.setCenter(null);
				primaryFrame.setScene(SceneInicio.scene);
				primaryFrame.setResizable(false);
			}
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
				editp.getPanel().prefHeightProperty().bind(p1.nombre.heightProperty());
				editp.getPanel().prefWidthProperty().bind(p1.nombre.widthProperty());

			} else if (control.equals(p1.mostrarPerfil)) {
				MostrarPerfil mostrarp = new MostrarPerfil();
				p1.nombre.setCenter(mostrarp.getPanel());
				mostrarp.getPanel().prefHeightProperty().bind(p1.nombre.heightProperty());
				mostrarp.getPanel().prefWidthProperty().bind(p1.nombre.widthProperty());
			}

			else if (control.equals(p1.asignatura)) {
				PanelAsignatura asig = new PanelAsignatura();
				p1.nombre.setCenter(asig.getPanel());
				asig.getPanel().prefHeightProperty().bind(p1.nombre.heightProperty());
				asig.getPanel().prefWidthProperty().bind(p1.nombre.widthProperty());
			}

			else if (control.equals(p1.profesores)) {

				ListaProfesores listaP = new ListaProfesores(sa.getProfesorList());
				ScrollPane s = new ScrollPane(listaP.getPanel());
				listaP.getPanel().prefWidthProperty().bind(p1.nombre.widthProperty());
				listaP.getPanel().prefHeightProperty().bind(p1.nombre.heightProperty());
				s.setPadding(new Insets(10));
				p1.nombre.setCenter(s);
				s.prefHeightProperty().bind(p1.nombre.heightProperty());
				s.prefWidthProperty().bind(p1.nombre.widthProperty());

			} else if (control.equals(p1.semestres)) {
				PanelSemestre semest = new PanelSemestre();
				p1.nombre.setCenter(semest.getPanel());
				semest.getPanel().prefHeightProperty().bind(p1.nombre.heightProperty());
				semest.getPanel().prefWidthProperty().bind(p1.nombre.widthProperty());

			} else if (control.equals(p1.calcularPAPA)) {
				Alert papa = new Alert(AlertType.INFORMATION);
				papa.setTitle("P.A.P.A");
				papa.setHeaderText(null);
				papa.setContentText("Tu P.A.P.A actual es: " + estudiante.getPAPA());
				papa.showAndWait();
			}

			else if (control.equals(p1.horario)) {
				PanelHorarios horar = new PanelHorarios();
				horar.getPanel().prefHeightProperty().bind(p1.nombre.heightProperty());
				horar.getPanel().prefWidthProperty().bind(p1.nombre.widthProperty());
				p1.nombre.setCenter(horar.getPanel());

			} else if(control.equals(p1.usuarioMenu)){
				p1.nombre.setCenter(null);
			}
		}

	}

}

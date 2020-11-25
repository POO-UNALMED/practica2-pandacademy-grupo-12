package paneles;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.Action;

import gestorAplicacion.Persona.Profesor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import vista.principal;

public class ListaProfesores {

	GridPane[] paneles;
	Button aceptar = new Button("ACEPTAR");
	Button borrar = new Button("BORRAR");
	GridPane todos = new GridPane();

	public ListaProfesores(ArrayList<Profesor> ejemploProfesores) {

		FieldPanel profesores;
		paneles = new GridPane[ejemploProfesores.size()];

		/*
		 * for(int i = 0; i < Semestre.profesores.size(); i++) { String[] criterios =
		 * new String[] {"Nombre", "Correo", "Detalles", "Asignatura"}; String[] valores
		 * = new String[] {Semestre.profesores.get(i).getNombre(),
		 * Semestre.profesores.get(i).getCorreo(),
		 * Semestre.profesores.get(i).getDetalles(),
		 * Semestre.profesores.get(i).getAsignatura().getNombre()}; boolean[]
		 * habilitados = new boolean[] {true,true,true,true}; profesores = new
		 * FieldPanel("Datos",criterios,"valores", valores, habilitados);
		 * 
		 * 
		 * }
		 */

		GridPane a = new GridPane();
		Label editProfe0 = new Label(" EDITAR PROFESOR ");
		editProfe0.setStyle("-fx-border-color: BLUE;");
		Label desc0 = new Label(" EN ESTE SECCION PODRAS VER Y EDITAR LOS DATOS DE TUS PROFESORES ");
		desc0.setStyle("-fx-border-color: BLUE;");

		a.addColumn(0, editProfe0, desc0);

		a.setAlignment(Pos.TOP_CENTER);
		a.setVgap(20);
		todos.add(a, 0, 0);
		todos.setHgap(20);

		for (int i = 0; i < ejemploProfesores.size(); i++) {

			String[] criterios = new String[] { "Nombre", "Correo", "Asignatura", "Detalles" };
			String[] valores = new String[] { ejemploProfesores.get(i).getNombre(),
					ejemploProfesores.get(i).getCorreo(), ejemploProfesores.get(i).getAsignatura().getNombre(),
					ejemploProfesores.get(i).getDetalles() };
			boolean[] habilitados = new boolean[] { true, true, false, true };
			profesores = new FieldPanel("DATOS", criterios, "", valores, habilitados);

			profesores.getP().setAlignment(Pos.CENTER);
			profesores.getP().setVgap(10);
			profesores.getP().setHgap(10);
			profesores.getP().setStyle("-fx-background-color: GRAY;");
			profesores.getP().prefWidthProperty().bind(todos.widthProperty());
			profesores.getP().prefHeightProperty().bind(todos.heightProperty());
			profesores.getP().setPadding(new Insets(10));

			Button guardar = new Button("GUARDAR"); // BOTONES DE GUARDAR Y BORRAR DE CADA PROFESOR
			guardar.setAlignment(Pos.CENTER_RIGHT);
			Button borrar = new Button("BORRAR");
			profesores.getP().addColumn(0, new Label(""));
			profesores.getP().addColumn(1, new Label(""));
			profesores.getP().addColumn(0, guardar);
			profesores.getP().addColumn(1, borrar);
			Handler boton = new Handler(ejemploProfesores.get(i), todos, profesores, guardar, borrar);
			guardar.setOnAction(boton);
			borrar.setOnAction(boton);

			todos.add(profesores.getP(), 0, i + 1);
			todos.setAlignment(Pos.CENTER);
			todos.setVgap(20);

		}

	}

	public GridPane getPanel() {
		return todos;
	}

	public Button getbotonaceptar() {
		return aceptar;
	}

	public Button getbotonborrar() {
		return borrar;
	}

	class Handler implements EventHandler<ActionEvent> {
		Profesor profesor;
		FieldPanel datosbasicos;
		GridPane lista;
		Button guardar, borrar;

		public Handler(Profesor profesor, GridPane list, FieldPanel datos, Button guardar, Button borrar) {
			this.profesor = profesor;
			datosbasicos = datos;
			lista = list;
			this.guardar = guardar;
			this.borrar = borrar;
		}

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource().equals(guardar)) {
				Alert aviso = new Alert(AlertType.CONFIRMATION);
				aviso.setHeaderText(null);
				aviso.setContentText("Estas seguro que deseas guardar estos cabios?");
				aviso.initStyle(StageStyle.UTILITY);
				Optional<ButtonType> resul = aviso.showAndWait();
				if (resul.get() == ButtonType.OK) {
					profesor.setNombre(datosbasicos.getValue("Nombre"));
					profesor.setCorreo(datosbasicos.getValue("Correo"));
					profesor.setDetalles(datosbasicos.getValue("Detalles"));
					Alert aviso2 = new Alert(AlertType.INFORMATION);
					aviso2.setHeaderText(null);
					aviso2.setContentText("Cambios guardados con exito");
					aviso2.showAndWait();
				}else{
					datosbasicos.clean();
				}

			} else if (event.getSource().equals(borrar)) {
				Alert aviso = new Alert(AlertType.CONFIRMATION);
				aviso.setHeaderText(null);
				aviso.setContentText("Estas seguro que deseas realizar esta accion?");
				aviso.initStyle(StageStyle.UTILITY);
				Optional<ButtonType> resul = aviso.showAndWait();
				if (resul.get() == ButtonType.OK) {
					principal.sa.getProfesorList().remove(profesor);
					lista.getChildren().remove(datosbasicos.getP());
				}
			}
		}

	}
}

package paneles;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import vista.principal;

public class MostrarPerfil {

	GridPane root = new GridPane();

	Label titulo = new Label("MOSTRAR PERFIL");
	Label desc = new Label(
			"EN ESTA SECCION PODRAS VER TUS DATOS COMO EL NOMBRE, EL CORREO, LA CC,\nEL PLAN DE ESTUDIOS Y TU AVANCE DE CARRERA");
	Label l1 = new Label("NOMBRE:   " + principal.estudiante.getNombre());

	Label l2 = new Label("DOCUMENTO DE IDENTIDAD:   " + principal.estudiante.getDni());
	Label l3 = new Label("CORREO:   " + principal.estudiante.getCorreo());
	Label l4 = new Label("PLAN DE ESTUDIOS:   " + principal.estudiante.getPlanDeEstudio());
	Label l5 = new Label("AVANCE DE CARRERA:   " + principal.estudiante.avanceCarrera());

	public MostrarPerfil() {
		titulo.setStyle("-fx-border-color: BLUE;");
		desc.setStyle("-fx-border-color: BLUE;");
		VBox tit = new VBox(titulo,desc);
		tit.setSpacing(20);
		tit.setAlignment(Pos.CENTER);
		VBox v1 = new VBox(l1, l2, l3, l4, l5);
		v1.setSpacing(15);
		v1.setAlignment(Pos.CENTER);

		root.addColumn(0, tit, v1);
		root.setAlignment(Pos.CENTER);
		root.setVgap(40);
		root.setHgap(40);

		root.setStyle("-fx-background-color: #F4F4F4;");

	}

	public GridPane getPanel() {
		return root;
	}

}

package paneles;

import java.util.ArrayList;

import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.Estudiante;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import vista.principal;

public class PanelSemestre {

	ArrayList<Button> papelera = new ArrayList<>();
	Button agregar = new Button("AGREGAR");
	Button borrar = new Button("BORRAR");
	Label titulo = new Label("SEMESTRES");
	Label desc = new Label(
			"EN ESTA SECCION CAMBIAR DE SEMESTRE, AGREGAR NUEVOS SEMESTRES Y BORRAR SEMESTRES \n\nClick en el semestre para cambiar de semestre");

	GridPane root = new GridPane();
	ScrollPane scroll = new ScrollPane(root);
	GridPane p = new GridPane();

	public PanelSemestre() {

		p.addColumn(0, scroll);
		p.setAlignment(Pos.CENTER);
		scroll.setPadding(new Insets(10));

		root.setAlignment(Pos.CENTER);
		desc.setStyle("-fx-border-color: BLUE;");
		titulo.setStyle("-fx-border-color: BLUE;");
		root.setVgap(20);
		root.setHgap(20);
		VBox cajabot = new VBox();
		cajabot.setSpacing(10);

		for (int i = 0; i < principal.estudiante.getSemestres().size(); i++) {
			Button boton = new Button(principal.estudiante.getSemestres().get(i).getNombre());
			boton.prefWidthProperty().bind(cajabot.widthProperty());
			cajabot.getChildren().add(boton);
			boton.addEventHandler(MouseEvent.MOUSE_CLICKED, new nClick(boton));

		}

		agregar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int num = 1 + Integer.valueOf(principal.estudiante.getSemestres()
						.get(principal.estudiante.getSemestres().size() - 1).getNombre().substring(9));
				principal.estudiante.addSemestre(new Semestre("Semestre " + num));
				Button boton = new Button("Semestre " + num);
				boton.prefWidthProperty().bind(cajabot.widthProperty());
				cajabot.getChildren().add(boton);
				boton.addEventHandler(MouseEvent.MOUSE_CLICKED, new nClick(boton));
			}
		});

		borrar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (Button button : papelera) {
					for (Semestre semestre : principal.estudiante.getSemestres()) {
						if (semestre.getNombre().equals(button.getText())) {
							principal.estudiante.getSemestres().remove(semestre);
							cajabot.getChildren().remove(button);
						}
					}
				}
				// TODO Auto-generated method stub
			}

		});

		HBox s = new HBox(agregar, borrar);
		s.setSpacing(10);
		s.setAlignment(Pos.CENTER);

		root.addColumn(0, titulo, desc, cajabot, s);
	}

	public GridPane getPanel() {
		return p;
	}

	class nClick implements EventHandler<MouseEvent> {
		Button boton;

		public nClick(Button boton) {
			this.boton = boton;
		}

		@Override
		public void handle(MouseEvent event) {
			if (event.getClickCount() == 1) {
				for (Button semestre : papelera) {
					if (semestre.equals((Button) event.getSource())) {
						boton.setStyle(null);
						papelera.remove((Button) event.getSource());
					} else {
						boton.setStyle("-fx-border-color: RED;");
						papelera.add((Button) event.getSource());
					}
				}
				if (papelera.isEmpty()) {
					boton.setStyle("-fx-border-color: RED;");
					papelera.add((Button) event.getSource());
				}
			} else if (event.getClickCount() == 2) {
				boton.setStyle(null);
				papelera.remove((Button) event.getSource());
				for (Semestre newS : principal.estudiante.getSemestres()) {
					if (boton.getText().equals(newS.getNombre())) {
						principal.sa = newS;
					}
				}
				Alert aviso = new Alert(AlertType.INFORMATION);
				aviso.setHeaderText(null);
				aviso.setContentText("Cambio de semestre realizado\nSemestre actual: " + principal.sa.getNombre());
				aviso.initStyle(StageStyle.UTILITY);
				aviso.showAndWait();
			}

		}

	}

}

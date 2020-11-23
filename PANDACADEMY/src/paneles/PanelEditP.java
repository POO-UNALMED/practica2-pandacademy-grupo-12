package paneles;

import vista.*;

import java.util.Optional;

import gestorAplicacion.Persona.Estudiante;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PanelEditP {

	GridPane m = new GridPane();
	Button aceptar = new Button("ACEPTAR");

	/*
	 * CREACION DEL FIELDPANEL
	 */
	String[] criterios = new String[] { "NOMBRE", "DOCUMENTO DE IDENTIDAD", "CORREO", "PLAN DE ESTUDIOS",
			"CREDITOS REQUERIDOS" };
	String[] valores = new String[] { principal.estudiante.getNombre(), Long.toString(principal.estudiante.getDni()),
			principal.estudiante.getCorreo(), principal.estudiante.getPlanDeEstudio(),
			String.valueOf(principal.estudiante.getCreditosR()) };
	boolean[] habilitados = new boolean[] { true, true, true, true, true };
	FieldPanel editarp = new FieldPanel("Datos", criterios, "valores", valores, habilitados);
	// --------

	Label editp = new Label(" EDITAR PERFIL ");
	Label desc = new Label(" EN ESTE SECCION PODRAS EDITAR LOS DATOS DE TU PERFIL ");

	public PanelEditP() {

		aceptar.setOnAction(event -> {
			principal.estudiante.setNombre("asddad");
		});

		editarp.getP().setAlignment(Pos.CENTER);
		editarp.getP().setVgap(10);
		editarp.getP().setHgap(100);

		desc.setStyle("-fx-border-color: BLUE;");
		editp.setStyle("-fx-border-color: BLUE;");
		VBox v1 = new VBox(editp);
		v1.setAlignment(Pos.CENTER);
		VBox v2 = new VBox(desc);
		v2.setAlignment(Pos.CENTER);

		m.addColumn(0, v1, v2, editarp.getP());

		m.setAlignment(Pos.CENTER);
		m.setVgap(20);

		editarp.getP().addColumn(0, aceptar);

		Handler evento = new Handler();
		aceptar.setOnAction(evento);

	}

	public GridPane getPanel() {
		return m;
	}
	/**
	 * Evento del boton aceptar para guardar los datos
	 */
	class Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (event.getSource().equals(aceptar)) {
				try {
					Alert aviso = new Alert(AlertType.CONFIRMATION);
					aviso.setHeaderText(null);
					aviso.setContentText("¿Quiere guardar los cambios?");
					Optional<ButtonType> result = aviso.showAndWait();
					if (result.get() == ButtonType.OK) {
						principal.estudiante.setNombre(editarp.getValue("NOMBRE"));
						principal.estudiante.setCorreo(editarp.getValue("CORREO"));
						principal.estudiante.setDni(Long.valueOf(editarp.getValue("DOCUMENTO DE IDENTIDAD")));
						principal.estudiante.setPlanDeEstudo(editarp.getValue("PLAN DE ESTUDIOS"));
						principal.estudiante.setCreditosR(Integer.valueOf(editarp.getValue("CREDITOS REQUERIDOS")));
						valores = new String[] { principal.estudiante.getNombre(),
								Long.toString(principal.estudiante.getDni()), principal.estudiante.getCorreo(),
								principal.estudiante.getPlanDeEstudio(),
								String.valueOf(principal.estudiante.getCreditosR()) };
						editarp.setValues(valores);
					} else {
						editarp.clean();
					}
				} catch (Exception e) {
					Alert aviso = new Alert(AlertType.ERROR);
					aviso.setHeaderText(null);
					aviso.setContentText("TIPO DE DATO NO VALIDO");
					aviso.showAndWait();
					editarp.clean();
				}
				// TODO Auto-generated method stub

			}

		}
	}
}
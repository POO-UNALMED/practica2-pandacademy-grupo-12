package paneles;

import java.util.ArrayList;

import gestorAplicacion.Persona.Profesor;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ListaProfesores {

	GridPane m;
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
		Label desc0 = new Label(" EN ESTE SECCION PODRAS EDITAR LOS DATOS DE TU PROFESOR ");
		desc0.setStyle("-fx-border-color: BLUE;");
		
		a.addColumn(0, editProfe0, desc0);

		a.setAlignment(Pos.TOP_CENTER);
		a.setVgap(20);
		todos.add(a, 0, 0);
		todos.setHgap(20);
		for (int i = 0; i < ejemploProfesores.size(); i++) {
			
			String nombre = "";
			String[] criterios = new String[] { "Nombre", "Correo", "Detalles", "Asignatura" };
			if(ejemploProfesores.get(i).getNombre() != null) {
				nombre = ejemploProfesores.get(i).getNombre();
			}
			String[] valores = new String[] { ejemploProfesores.get(i).getNombre(),
					ejemploProfesores.get(i).getCorreo(), ejemploProfesores.get(i).getDetalles(),
					ejemploProfesores.get(i).getAsignatura().getNombre() };
			boolean[] habilitados = new boolean[] { true, true, true, true };
			profesores = new FieldPanel("Datos", criterios, "valores", valores, habilitados);

			profesores.getP().setAlignment(Pos.CENTER);
			profesores.getP().setVgap(10);
			profesores.getP().setHgap(100);

			m = new GridPane(); // panel completo de editarperfil
			Label editProfe = new Label(" EDITAR PROFESOR ");
			editProfe.setStyle("-fx-border-color: BLUE;");
			Label desc = new Label(" EN ESTE SECCION PODRAS EDITAR LOS DATOS DE TU PROFESOR ");
			desc.setStyle("-fx-border-color: BLUE;"); 

			m.addColumn(1, profesores.getP());

			m.setAlignment(Pos.TOP_CENTER);
			m.setVgap(20);
			todos.add(m, 0, i+1);
			todos.setVgap(20);

			;

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

}

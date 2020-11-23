package paneles;
import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import paneles.FieldPanel;

public class ListaProfesores {
	
	GridPane m;
	GridPane[] paneles;
	Button aceptar=new Button("ACEPTAR");
	Button borrar=new Button("BORRAR");
	GridPane todos = new GridPane();
	
	public ListaProfesores(Profesor[] ejemploProfesores) {
		
		
		FieldPanel profesores;
		paneles = new GridPane[ejemploProfesores.length];
		
		/*for(int i = 0; i < Semestre.profesores.size(); i++) {
			String[] criterios = new String[] {"Nombre", "Correo", "Detalles", "Asignatura"};
			String[] valores = new String[] {Semestre.profesores.get(i).getNombre(), 
					Semestre.profesores.get(i).getCorreo(), 
					Semestre.profesores.get(i).getDetalles(), 
					Semestre.profesores.get(i).getAsignatura().getNombre()};
			boolean[] habilitados = new boolean[] {true,true,true,true};
			profesores = new FieldPanel("Datos",criterios,"valores", valores, habilitados);

			
		}*/
		
		for(int i = 0; i < ejemploProfesores.length; i++) {
			String[] criterios = new String[] {"Nombre", "Correo", "Detalles", "Asignatura"};
			String[] valores = new String[] {ejemploProfesores[i].getNombre(), 
					ejemploProfesores[i].getCorreo(), 
					ejemploProfesores[i].getDetalles(), 
					ejemploProfesores[i].getAsignatura().getNombre()};
			boolean[] habilitados = new boolean[] {true,true,true,true};
			profesores = new FieldPanel("Datos",criterios,"valores", valores, habilitados);

			profesores.getP().setAlignment(Pos.CENTER);
			profesores.getP().setVgap(10);
			profesores.getP().setHgap(100);
			
			 m = new GridPane();   //panel completo de editarperfil
			Label editProfe=new Label(" EDITAR PROFESOR ");
			editProfe.setStyle("-fx-border-color: BLUE;");
			Label desc=new Label(" EN ESTE SECCION PODRAS EDITAR LOS DATOS DE TU PROFESOR ");
			desc.setStyle("-fx-border-color: BLUE;");
			
			m.addColumn(0, editProfe,desc, profesores.getP());
			
			m.setAlignment(Pos.TOP_CENTER);
			m.setVgap(20);
			todos.add(m, 0, i);;
			

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

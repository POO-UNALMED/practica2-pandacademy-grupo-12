package paneles;

import gestorAplicacion.Persona.Estudiante;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MostrarPerfil {
	
	Estudiante estudent= new Estudiante();
	GridPane principal= new GridPane();
	
	Label titulo = new Label ("MOSTRAR PERFIL");
	Label desc= new Label("EN ESTA SECCION PODRAS VER TUS DATOS COMO EL NOMBRE, EL CORREO, LA CC,\nEL PLAN DE ESTUDIOS Y TU AVANCE DE CARRERA");
	Label l1 = new Label("NOMBRE:   " + estudent.getNombre());
	
	Label l2 = new Label("DOCUMENTO DE IDENTIDAD:   " + estudent.getDni());
	Label l3 = new Label("CORREO:   "+ estudent.getCorreo());
	Label l4 = new Label("PLAN DE ESTUDIOS:   " + estudent.getPlanDeEstudio());
	Label l5 = new Label ("AVANCE DE CARRERA:   "+ estudent.avanceCarrera());
	
	public MostrarPerfil() {
		titulo.setStyle("-fx-border-color: BLUE;");
		desc.setStyle("-fx-border-color: BLUE;");
		principal.addColumn(0, titulo,desc,l1,l2,l3,l4,l5);
		
		principal.setAlignment(Pos.CENTER);
		principal.setVgap(20);
		principal.setHgap(20);
		
	}
	
	public GridPane	getPanel() {
		return principal;
	}
	
	
	

}

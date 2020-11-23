package paneles;

import gestorAplicacion.Persona.Estudiante;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

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
		VBox tit=new VBox(titulo,desc);
		tit.setAlignment(Pos.CENTER);
		VBox v1=new VBox(l1,l2,l3,l4,l5);
		v1.setSpacing(15);
		tit.setSpacing(15);
		
		principal.addColumn(0, tit,v1);
		principal.setAlignment(Pos.CENTER);
		principal.setVgap(40);
		principal.setHgap(40);
		
	}
	
	public GridPane	getPanel() {
		return principal;
	}
	
	
	

}

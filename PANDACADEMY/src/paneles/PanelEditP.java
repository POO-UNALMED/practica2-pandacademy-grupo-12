package paneles;
import vista.*;
import gestorAplicacion.Persona.Estudiante;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PanelEditP {
	Estudiante estudent = new Estudiante();
	GridPane m= new GridPane();
	Button aceptar=new Button("ACEPTAR");
	Button borrar=new Button("BORRAR");
	
	/*
	 * CREACION DEL FIELDPANEL
	 */
	String[] criterios = new String[] {"NOMBRE","DOCUMENTO DE IDENTIDAD","CORREO","PLAN DE ESTUDIOS"};
	String[] valores = new String[] { estudent.getNombre(), Long.toString(estudent.getDni()) ,estudent.getCorreo(),estudent.getPlanDeEstudio()};
	boolean[] habilitados = new boolean[] {true,true,true,true};
	FieldPanel editarp=new FieldPanel("Datos",criterios,"valores",valores,habilitados);
	//--------
	
	Label editp=new Label(" EDITAR PERFIL ");
	Label desc=new Label(" EN ESTE SECCION PODRAS EDITAR LOS DATOS DE TU PERFIL ");

	
	public PanelEditP(){
		
		aceptar.setOnAction(event ->{
			estudent.setNombre("asddad");
		});
		
		editarp.getP().setAlignment(Pos.CENTER);
		editarp.getP().setVgap(10);
		editarp.getP().setHgap(100);

		desc.setStyle("-fx-border-color: BLUE;");
		editp.setStyle("-fx-border-color: BLUE;");
		VBox v1=new VBox(editp);
		v1.setAlignment(Pos.CENTER);
		VBox v2=new VBox(desc);
		v2.setAlignment(Pos.CENTER);

		
		m.addColumn(0,v1,v2,editarp.getP());
		
		m.setAlignment(Pos.CENTER);
		m.setVgap(20);

		editarp.getP().addColumn(0, aceptar);

		editarp.getP().addColumn(1,borrar);
		
		
	}
	
	public GridPane getPanel() {
		return m;
	}
	
	public Button getbotonaceptar() {
		return aceptar;
	}
	
	public Button getbotonborrar() {
		return borrar;
	}

}
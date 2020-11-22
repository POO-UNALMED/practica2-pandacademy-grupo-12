package paneles;
import vista.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PanelEditP {
	GridPane m;
	FieldPanel editarp;
	Button aceptar=new Button("ACEPTAR");
	Button borrar=new Button("BORRAR");
	
	
	public PanelEditP(){
		
		String[] criterios = new String[] {"NOMBRE","DOCUMENTO DE IDENTIDAD","CORREO","PLAN DE ESTUDIOS",};
		String[] valores = new String[] { "" ,"@ss","744554","inge",null};
		boolean[] habilitados = new boolean[] {true,true,true,true};
		
		editarp=new FieldPanel("Datos",criterios,"valores",null,habilitados);
		
		editarp.getP().setAlignment(Pos.CENTER);
		editarp.getP().setVgap(10);
		editarp.getP().setHgap(100);
		
		m= new GridPane();   //panel completo de editarperfil
		Label editp=new Label(" EDITAR PERFIL ");
		editp.setStyle("-fx-border-color: BLUE;");
		Label desc=new Label(" EN ESTE SECCION PODRAS EDITAR LOS DATOS DE TU PERFIL ");
		desc.setStyle("-fx-border-color: BLUE;");
		
		m.addColumn(0,editp,desc,editarp.getP(), new Label("AVANCE DE CARRERA: "));
		
		m.setAlignment(Pos.TOP_CENTER);
		m.setVgap(20);

		editarp.getP().addColumn(0, aceptar);

		editarp.getP().addColumn(1,borrar);
		
		
	}
	
	public GridPane getpanel() {
		return m;
	}
	
	public Button getbotonaceptar() {
		return aceptar;
	}
	
	public Button getbotonborrar() {
		return borrar;
	}

}
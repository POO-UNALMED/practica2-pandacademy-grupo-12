package vista;
import gestorAplicacion.Persona.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ListaProfesores {
	
	VBox lista;
	
	public ListaProfesores(Profesor profesor) {
		lista = new VBox(new TextField());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

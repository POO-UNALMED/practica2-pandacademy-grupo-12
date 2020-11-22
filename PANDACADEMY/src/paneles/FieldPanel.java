package paneles;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane {
	private GridPane panel;
	private String TituloCriterios;
	private String[] criterios;
	private ArrayList<TextField> valorcrit=new ArrayList<>();
	private String TituloValores;
	private String[] valores;
	private boolean[] habilitados;


	public FieldPanel(String TituloCriterios, String[] criterios,String TituloValores, String[] valores, boolean[] habilitados) {
		panel=new GridPane();
		this.TituloCriterios=TituloCriterios;
		this.TituloValores=TituloValores;
		this.criterios = criterios;
		this.valores=valores;
		this.habilitados=habilitados;
		
		panel.addColumn(0, new Label(this.TituloCriterios));
		panel.addColumn(1, new Label(this.TituloValores));
		
		for (int i=0; i< this.criterios.length;i++ ) {
			panel.addColumn(0, new Label(this.criterios[i]));
			if (this.valores==null) {
				TextField tf = new TextField();
				tf.setEditable(habilitados[i]);
				panel.addColumn(1, tf);
				
			}
			else if(this.valores[i]==null) {
				TextField tf =new TextField(this.valores[i]);
				tf.setEditable(habilitados[i]);
				panel.addColumn(1, tf );
				valorcrit.add(tf);
			}
			else {
				TextField tf =new TextField(this.valores[i]);
				tf.setEditable(habilitados[i]);
				panel.addColumn(1, tf);
				valorcrit.add(tf);
			}
		}

		
	}
	
	public GridPane getP() {
		return panel;
	}
	
	public String getValue(String criterio) {
		String aux="";
		for (int i=0;i<criterios.length;i++) {		
			if (criterios[i]==criterio) {
				aux= valorcrit.get(i).getText();
				break;
			}
		}
		return aux;
	}
}

	
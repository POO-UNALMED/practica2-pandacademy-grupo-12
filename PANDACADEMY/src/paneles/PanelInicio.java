package paneles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class PanelInicio {
	
	BorderPane pane = new BorderPane();
	
	Label inicio = new Label("Inicio");
	
	public PanelInicio() {
		BackgroundImage fondo= new BackgroundImage(new Image("/recursos/Frame4.png"),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
		          new BackgroundSize(100, 100, true, true, true, false));
		
		pane.setBackground(new Background(fondo));
		
		
		pane.setTop(inicio);
		inicio.setAlignment(Pos.CENTER);
		inicio.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,new CornerRadii(5.0), new Insets(-5.0))));
		BorderPane.setAlignment(inicio, Pos.CENTER);
		inicio.setFont(new Font("Arial", 24));
		pane.setPadding(new Insets(10));
		inicio.setMaxWidth(5000);
	}
	
	
	
	public BorderPane getPanel() {
		return pane;
	}
}

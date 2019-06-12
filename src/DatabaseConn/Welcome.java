package DatabaseConn;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Welcome extends BorderPane{
	public Button btn3 = new Button("<- Back");
	public Welcome() {
		GridPane pane = new GridPane();
		
		pane.setAlignment(Pos.CENTER);
		
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setHgap(5);
		pane.setVgap(5);
		Label label = new Label();
		
		label.setText("We'll have a welcome page here");

		label.setStyle("-fx-background-color:lightblue; -fx-font-size:15px;");
		pane.getChildren().add(label);

		
		//Button btn3 = new Button("<- Back");
		
		this.setCenter(pane);
		this.setTop(btn3);
	
	}
}

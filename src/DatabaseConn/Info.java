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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Info extends BorderPane{
	public Button btn3 = new Button("<- Back");
	public Info() {
		GridPane pane = new GridPane();
		
		pane.setAlignment(Pos.CENTER);
		
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setHgap(5);
		pane.setVgap(5);
		Label label = new Label();
		
		label.setText("We'll have an info page here");

		label.setStyle("-fx-background-color:lightblue; -fx-font-size:15px;");
		pane.getChildren().add(label);
//		
//		Stage helpAboutStage = new Stage();
//		
//		WebView browser = new WebView();
//
//		WebEngine webEngine = browser.getEngine();
//
//		String url = Info.class.getResource("info.html").toExternalForm();
//
//		System.out.println("Local URL: " + url);
//		
//		webEngine.load(url);
//
//		Scene sc = new Scene(browser, 500, 300);
//
//		helpAboutStage.setTitle("Help - About");
//		helpAboutStage.setScene(sc);
//
//		helpAboutStage.show();
		
		this.setCenter(pane);
		this.setTop(btn3);
	
	}
}

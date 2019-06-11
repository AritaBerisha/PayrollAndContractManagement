package DatabaseConn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class MainProgram {
	
	public static void createMainStage() {
		Stage mainStage = new Stage();
		
		HBox hbox = new HBox();
		
		Label mainLabel = new Label("Main stage shown!");
		
		hbox.getChildren().addAll(mainLabel);
		
		Scene scene = new Scene(hbox, 300, 300);
		
		mainStage.setTitle("Main program!");
		mainStage.setScene(scene);
		mainStage.show();
		
	}
	
	
}

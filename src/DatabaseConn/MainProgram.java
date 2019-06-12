package DatabaseConn;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class MainProgram {
	
	public static void createMainStage() {
		Stage mainStage = new Stage();
		MainContent mn = new MainContent();
		AddEmployee ae = new AddEmployee();
		UpdateEmployee ue = new UpdateEmployee();
		Welcome we = new Welcome();
		Info info = new Info();
		
		Scene scene = new Scene(mn, 800, 600);
		
		Scene sceneAdd= new Scene(ae,800,600);
		mn.btn.setOnAction(e->mainStage.setScene(sceneAdd));
		ae.btn3.setOnAction(e->mainStage.setScene(scene));
		
		Scene sceneUpdate = new Scene(ue,800,600);
		mn.btn1.setOnAction(e->mainStage.setScene(sceneUpdate));
		ue.btn4.setOnAction(e->mainStage.setScene(scene));
		
		Scene sceneWelcome= new Scene(we,800,600);
		we.btn3.setOnAction(e->mainStage.setScene(scene));
		
		Scene sceneInfo= new Scene(info,800,600);
		info.btn3.setOnAction(e->mainStage.setScene(scene));
		
		mn.menu1.mnW.setOnAction(e->mainStage.setScene(sceneWelcome));
		mn.menu1.mnI.setOnAction(e->mainStage.setScene(sceneInfo));
		mn.menu1.mnN.setOnAction( e-> mainStage.setScene(sceneAdd));
		mn.menu1.mnE.setOnAction(e-> Platform.exit());
		
		mainStage.setTitle("Main program!");
		mainStage.setScene(scene);
		mainStage.show();
		
	}
	public static void main(String[] args) {
	}

}

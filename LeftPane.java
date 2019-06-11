package DatabaseConn;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LeftPane extends VBox{
	Label  labelTitle = new Label("Add New Employee");
	
	TextField txtName = new TextField();
	TextField txtAge = new TextField();
	TextField txtYear = new TextField();
	
	Button btnSave = new Button("Save");
	Button btnUpdate = new Button("Update");
	Button btnDelete = new Button("Delete");
	
	public LeftPane() {
		
		txtName.setFont(new Font(20));
		txtYear.setFont(new Font(20));
		txtAge.setFont(new Font(20));
		
		txtName.setPromptText("Enter Name");
		txtAge.setPromptText("Enter Age");
		txtYear.setPromptText("Enter Year");
		
		
		btnSave.setPrefWidth(160);
		btnUpdate.setPrefWidth(160);
		btnDelete.setPrefWidth(160);
		
		btnSave.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 18;-fx-text-fill:#4DD0E1");
		btnUpdate.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 18;-fx-text-fill:#4DD0E1");
		btnDelete.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 18;-fx-text-fill:#4DD0E1");
		
		labelTitle.setStyle("-fx-font-size: 20px;-fx-text-fill:#FFF");
		
		this.setStyle("-fx-background-color: lightblue");
		this.setSpacing(20);
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(labelTitle,txtName,txtAge,txtYear,btnSave,btnUpdate,btnDelete);
		 
	}

}

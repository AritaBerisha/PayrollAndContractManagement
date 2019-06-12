package DatabaseConn;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LeftPane extends VBox{
	Label  labelTitle = new Label("Employee");
	
	public TextField txtID = new TextField();
	public TextField txtSalary = new TextField();
	
	
	
	Button btnUpdate = new Button("Update");
	Button btnDelete = new Button("Delete");
	
	public LeftPane() {
		
		txtID.setFont(new Font(20));
		
		txtSalary.setFont(new Font(20));
	
		txtID.setPromptText("Enter Employee ID:");
		
		txtSalary.setPromptText("Enter Salary:");
		
		
		
		btnUpdate.setPrefWidth(160);
		btnDelete.setPrefWidth(160);
		
		
		btnUpdate.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 18;-fx-text-fill:#4DD0E1");
		btnDelete.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 18;-fx-text-fill:#4DD0E1");
		
		labelTitle.setStyle("-fx-font-size: 20px;-fx-text-fill:#FFF");
		
		this.setStyle("-fx-background-color: lightblue");
		this.setSpacing(20);
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(labelTitle,txtID,txtSalary,btnUpdate,btnDelete);
		 
	}

}

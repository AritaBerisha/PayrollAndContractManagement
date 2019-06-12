package DatabaseConn;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
		
		
		btnUpdate.setTextFill(Color.rgb(186, 201, 209));
	       btnUpdate.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
	          		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
	          		"    -fx-background-color: #2C3E48");
		btnDelete.setTextFill(Color.rgb(186, 201, 209));
	       btnDelete.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
	          		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
	          		"    -fx-background-color: #2C3E48");
		
		labelTitle.setStyle("-fx-font-size: 20px;-fx-text-fill:rgb(186, 201, 209)");
		
		this.setStyle("-fx-background-color:  #53788D");
		this.setSpacing(18);
		this.setPadding(new Insets(18));
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(labelTitle,txtID,txtSalary,btnUpdate,btnDelete);
		 
	}

}

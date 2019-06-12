package DatabaseConn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class UpdateEmployee extends BorderPane{
	public Button btn4 = new Button("<- Back");
	LeftPane leftpane = new LeftPane();
	RightPane rightpane = new RightPane();
		
		
	public UpdateEmployee() {
		

	    HBox main = new HBox();
			  
	    main.getChildren().addAll(leftpane,rightpane);
			
		leftpane.prefWidthProperty().bind(main.widthProperty().divide(4));
		rightpane.prefWidthProperty().bind(main.widthProperty().subtract(main.widthProperty().divide(4)));
		//Button btn4 = new Button("<- Back");
		
		leftpane.btnUpdate.setOnAction(e->UpdateEmp());
		leftpane.btnDelete.setOnAction(e->DeleteEmp());
		this.setCenter(main);
	    this.setTop(btn4); 
	    
	}
	public void UpdateEmp() {
		
		String query = "Update payment set Employee_netto_salary='"+leftpane.txtSalary.getText()+"' where empId='"+leftpane.txtID.getText()+"'";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DBConnection.setConnection().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Update");
			alert.setHeaderText(null);
			alert.setContentText("Update was sucessful!");
			alert.showAndWait();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void DeleteEmp() {
		String query = "Delete from employees where Employee_id='"+leftpane.txtID.getText()+"'";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DBConnection.setConnection().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Delete");
			alert.setHeaderText(null);
			alert.setContentText("Deletion was sucessful!");
			alert.showAndWait();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}

package DatabaseConn;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AddEmployee extends BorderPane{
	public Button btn3 = new Button("<- Back");
	
	TextField empId = new TextField();
	TextField empName = new TextField();
	TextField empSurname = new TextField();
	TextField empBirth = new TextField();
	TextField empEmail = new TextField();
	TextField empContact = new TextField();
	TextField empAddress = new TextField();
	TextField empHours = new TextField();
	TextField empIdConBeg = new TextField();
	TextField empIdConEnd = new TextField();
	TextField empDep = new TextField();
	TextField empJob = new TextField();
	CheckBox activeChb = new CheckBox("Married");
	TextField empNetto = new TextField();
	TextField empBonus = new TextField();
	TextField empDeduct = new TextField();
	TextField empSalary = new TextField();
	Button btAdd = I18N.buttonForKey("addrecord");	
	private Integer numSwitches = 0;
	
	public AddEmployee() {
		GridPane pane = new GridPane();
	
		pane.setAlignment(Pos.CENTER);
		
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setHgap(5);
		pane.setVgap(5);
		Label label = new Label();
		
		label.setText("Employee Details");

		label.setStyle("-fx-font-size:15px;-fx-color:rgb(186, 201, 209)");
		pane.getChildren().add(label);
		
		
		pane.add(I18N.getLabel("employeeID"), 0, 1);
		pane.add(empId, 1, 1);
		pane.add(I18N.getLabel("firstname"), 0, 2);
		pane.add(empName, 1, 2);
		pane.add(I18N.getLabel("lastname"), 0, 3);
		pane.add(empSurname, 1, 3);
		pane.add(I18N.getLabel("dtb"), 0, 4);
		pane.add(empBirth, 1, 4);
		pane.add(I18N.getLabel("email"), 0, 5);
		pane.add(empEmail, 1, 5);
		pane.add(I18N.getLabel("contact"), 0, 6);
		pane.add(empContact, 1, 6);
		pane.add(I18N.getLabel("address"), 0, 7);
		pane.add(empAddress, 1, 7);
		pane.add(I18N.getLabel("hourwork"), 0, 8);
		pane.add(empHours, 1, 8);
		pane.add(I18N.getLabel("contractbgndate"), 0, 9);
		pane.add(empIdConBeg, 1, 9);
		pane.add(I18N.getLabel("contractduedate"), 0, 10);
		pane.add(empIdConEnd, 1, 10);
		pane.add(I18N.getLabel("department"), 2, 1);
		pane.add(empDep, 3, 1);
		pane.add(I18N.getLabel("jobtitle"), 2, 2);
		pane.add(empJob, 3, 2);
		pane.add(I18N.getLabel("status"), 2, 3);
		pane.add(activeChb, 3, 3);
		pane.add(I18N.getLabel("netto"), 2, 4);
		pane.add(empNetto, 3, 4);
		pane.add(I18N.getLabel("bonus"), 2, 5);
		pane.add(empBonus, 3, 5);
		pane.add(I18N.getLabel("deduction"), 2, 6);
		pane.add(empDeduct, 3, 6);
		pane.add(I18N.getLabel("salary"), 2, 7);
		pane.add(empSalary, 3, 7);
		
		
		btAdd.setTextFill(Color.rgb(186, 201, 209));
	       btAdd.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
	          		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
	          		"    -fx-background-color: #2C3E48");
		pane.add(btAdd, 2, 8);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
		Button btAd1 = I18N.buttonForKey("clear");
		btAd1.setTextFill(Color.rgb(186, 201, 209));
	       btAd1.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
	          		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
	          		"    -fx-background-color: #2C3E48");
		pane.add(btAd1, 3, 8);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
		

		btAd1.setOnAction(e->clear());
		
		btn3.setStyle( "    -fx-padding: 3px 10px 3px 10px;\r\n" + 
          		"    -fx-background-color: #2C3E48");
		btn3.setTextFill(Color.rgb(186, 201, 209));
		
		this.setCenter(pane);
		this.setTop(btn3);
		this.setStyle("-fx-background-color:  #53788D");
	
		progressi pp = new progressi();
		this.setBottom(pp);
		
		RightPane rightpane = new RightPane();
		
		btAdd.setOnAction(e->{
			AddEmp();
			 pp.ii += 0.1; 
             pp.pb.setProgress(pp.ii);
             clear();
             rightpane.refresh_table(rightpane.EmployersTable);
             
		});
				
		
		
	}
	
	public void AddEmp() {
		String query = "Insert into employees(Employee_id, Employee_name, Employee_surname,	Employee_birthday, status, Employee_number, Employee_email, Employee_address, Employee_hours) " + 
				"values ('"+empId.getText()+"','"+empName.getText()+"','"+empSurname.getText()+"','"+empBirth.getText()+"','"+activeChb.isSelected()+"','"+empContact.getText()+"','"+empEmail.getText()+"','"+empAddress.getText()+"','"+empHours.getText()+"')";
		
		String query2 ="Insert into contracts(Contract_date_begin, Contract_date_due, job_title, department,EmpId,empSalary )"+
		         "values ('"+empIdConBeg.getText()+"','"+empIdConEnd.getText()+"','"+empJob.getText()+"','"+empDep.getText()+"','"+empId.getText()+"','"+empSalary.getText()+"')";
		
		String query3 ="Insert into payment(Employee_netto_salary, payment_bonus, tax_ammount,empId)"+
		         "values ('"+empNetto.getText()+"','"+empBonus.getText()+"','"+empDeduct.getText()+"','"+empId.getText()+"')";
		try {
			PreparedStatement preparedStatement = DBConnection.setConnection().prepareStatement(query);
				
			preparedStatement.executeUpdate(query);
			
			PreparedStatement preparedStatement2 = DBConnection.setConnection().prepareStatement(query2);
			
			preparedStatement2.executeUpdate(query2);
			
			PreparedStatement preparedStatement3 = DBConnection.setConnection().prepareStatement(query3);
			
			preparedStatement3.executeUpdate(query3);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Added");
			alert.setHeaderText(null);
			alert.setContentText("The Employer was added successfully!");
			alert.showAndWait();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void clear() {
		empId.setText("");
		empName.setText("");
		empSurname.setText("");
		empBirth.setText("");
		empContact.setText("");
		empEmail.setText("");
		empAddress.setText("");
		empIdConBeg.setText("");
		empIdConEnd.setText("");
		empHours.setText("");
		empDep.setText("");
		empJob.setText("");
		empBonus.setText("");
		empDeduct.setText("");
		empNetto.setText("");
		empSalary.setText("");
	}
	public void switchLanguage(Locale locale) {
		numSwitches++;
		I18N.setLocale(locale);
	}
}

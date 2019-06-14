package DatabaseConn;

import java.util.List;
import java.util.Locale;

import com.sun.javafx.scene.control.skin.TableViewSkinBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RightPane extends VBox {
	
	HBox searchPane = new HBox();
	
	
	Button btnSearch = I18N.buttonForKey("searchbtn");
	
	Label label = new Label("Look up the contracts and decide!");
	private Integer numSwitches = 0;

	TableView EmployersTable= new TableView();
	
	public RightPane() {	
		
		
		// Employers table
		       TableColumn<String, Employer> column1 = new TableColumn<>("Employer Id");
				column1.setCellValueFactory(new PropertyValueFactory("EmpId"));
				column1.setPrefWidth(136);
				
				TableColumn<String, Employer> column2 = new TableColumn<>("Position");
				column2.setCellValueFactory(new PropertyValueFactory("job_title"));
				column2.setPrefWidth(136);
				
				TableColumn<String, Employer> column3 = new TableColumn<>("Department");
				column3.setCellValueFactory(new PropertyValueFactory("department"));
				column3.setPrefWidth(136);
				
				TableColumn<String, Employer> column4 = new TableColumn<>("Salary");
				column4.setCellValueFactory(new PropertyValueFactory("empSalary"));
				column4.setPrefWidth(136);
				

				
				
				EmployersTable.getColumns().add(column1);
				EmployersTable.getColumns().add(column2);
				EmployersTable.getColumns().add(column3);
				EmployersTable.getColumns().add(column4);
		
				
				EmployersTable.setPrefWidth(640);
				EmployersTable.setPrefHeight(800);

				
	searchPane.getChildren().addAll(label,btnSearch);
	searchPane.setSpacing(10);
	searchPane.setPadding(new Insets(20));
	searchPane.setAlignment(Pos.CENTER);
	
	
	btnSearch.setOnAction(e->refresh_table(EmployersTable));
	
	this.setPadding(new Insets(20));
	this.getChildren().addAll(searchPane,EmployersTable);
	this.setStyle("-fx-background-color:  #53788D");
	this.btnSearch.setTextFill(Color.rgb(186, 201, 209));
	this.btnSearch.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
      		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
      		"    -fx-background-color: #2C3E48");
	
	
	}
	public void showEmployers() {
		List<Employer> Employers = Employer.getEmployers();
		
		ObservableList<Employer> EmployerList = FXCollections.observableArrayList();
		
		
		for(int i = 0; i < Employers.size(); i++) {
			EmployerList.add(Employers.get(i));
		}
		
		EmployersTable.setItems(EmployerList);
		
		
		
       
		
	}
	public static void refresh_table(TableView table)
	{
        List<Employer> Employers = Employer.getEmployers();
		
		ObservableList<Employer> EmployerList = FXCollections.observableArrayList();
		
		
		for(int i = 0; i < Employers.size(); i++) {
			EmployerList.add(Employers.get(i));
		}
		
		table.setItems(EmployerList);
		
	}
	public void switchLanguage(Locale locale) {
		numSwitches++;
		I18N.setLocale(locale);
	}
}

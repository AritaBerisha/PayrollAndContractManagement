package Employer;

import java.sql.*;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import main.Employer;

public class MainEmp extends Application {

	
	private TextField idTxt = new TextField();
	private TextField positionTxt = new TextField();
	private TextField deptTxt = new TextField();
	private TextField salaryTxt = new TextField();
	

	private Button insertBtn = new Button("Insert");
	private Button updateBtn = new Button("Update");
	private Button deleteBtn = new Button("Delete");
	private Button clearBtn = new Button("Clear");
	
	
	
	
	private TableView EmployersTable = new TableView();
	
	
	public void start(Stage primaryStage) {
		
		insertBtn.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 15;-fx-text-fill:#4DD0E1");
		updateBtn.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 15;-fx-text-fill:#4DD0E1");
		deleteBtn.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 15;-fx-text-fill:#4DD0E1");
		clearBtn.setStyle("-fx-background-color: #ECEFF1;-fx-font-size: 15;-fx-text-fill:#4DD0E1");
		
		// Form pane
		GridPane formPane = new GridPane();
		
		formPane.addRow(0, new Label("Employer ID: "), idTxt);
		formPane.addRow(1, new Label("Position: "), positionTxt);
		formPane.addRow(2, new Label("Department: "), deptTxt);
		formPane.addRow(3, new Label("Salary: "), salaryTxt);
		
		formPane.setHgap(10);
		formPane.setVgap(10);
		
		idTxt.setDisable(true);
		
		// Buttons pane
		HBox buttonsPane = new HBox(10);
		
		buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn);
		
		insertBtn.setOnAction(e -> {
			insertEmployer();
		});
		
		clearBtn.setOnAction(e -> {
			clearForm();
		});
		
		deleteBtn.setOnAction( e -> {
			deleteEmployer();
		});
		
		updateBtn.setOnAction( e -> {
			updateEmployer();
		});
		
		// Left Pane
		
		VBox leftPane = new VBox(15);
		
		leftPane.getChildren().addAll(formPane, buttonsPane);
		
		
		// Employers table
		TableColumn<String, Employer> column1 = new TableColumn<>("Employer ID");
		column1.setCellValueFactory(new PropertyValueFactory("id"));
		column1.setPrefWidth(60);
		
		TableColumn<String, Employer> column2 = new TableColumn<>("Position");
		column2.setCellValueFactory(new PropertyValueFactory("position"));
		column2.setPrefWidth(150);
		
		TableColumn<String, Employer> column3 = new TableColumn<>("Department");
		column3.setCellValueFactory(new PropertyValueFactory("dept"));
		column3.setPrefWidth(150);
		
		TableColumn<String, Employer> column4 = new TableColumn<>("Salary");
		column4.setCellValueFactory(new PropertyValueFactory("salary"));
		column4.setPrefWidth(120);
		
		
		EmployersTable.setRowFactory(tv -> {
            TableRow<Employer> row = new TableRow<>();
            
            row.setOnMouseClicked(event -> {
               idTxt.setText( String.valueOf(row.getItem().getId()));
               positionTxt.setText(row.getItem().getPosition());
               deptTxt.setText(row.getItem().getDept());
               salaryTxt.setText( String.valueOf(row.getItem().getSalary()));
              
            });
            
            return row ;
        });

package DatabaseConn;

import com.sun.prism.Image;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Menus extends Application {
	Stage window;
	BorderPane layout;

	public static void main (String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
	  window = primaryStage;
	  window.setTitle("Payroll And Contract Management");
	  
	  //File menu 
	  Menu fileMenu = new Menu("_File");
	  fileMenu.getItems().add(new MenuItem("New"));
	  fileMenu.getItems().add(new MenuItem("Open"));
	  fileMenu.getItems().add(new MenuItem("Save"));
	  fileMenu.getItems().add(new SeparatorMenuItem());
	  fileMenu.getItems().add(new MenuItem("Exit..."));
	  
	  //Edit menu
	  Menu editMenu = new Menu("_Edit");
	  editMenu.getItems().add(new MenuItem("Out"));
	  editMenu.getItems().add(new MenuItem("Copy"));
	  editMenu.getItems().add(new MenuItem("Paste"));
	  
	  //Search menu
	  Menu search = new Menu("_Search");
	  
	  //Add menu
	  Menu AddMenu = new Menu("_Add");
	 
	 
	  //Language menu
	  Menu LangMenu = new Menu("_Language");
	  ToggleGroup LangToggle = new ToggleGroup();
	  
	  RadioMenuItem English = new RadioMenuItem("English");
	  RadioMenuItem Albanian = new RadioMenuItem("Albanian");
	  
	  English.setToggleGroup(LangToggle);
	  Albanian.setToggleGroup(LangToggle);
	  
	  LangMenu.getItems().addAll(English, Albanian);
	  
	  //Help menu
	  Menu helpMenu = new Menu("_Help");
	  helpMenu.getItems().add(new MenuItem("Welcome"));
	  helpMenu.getItems().add(new MenuItem("Help Content"));
	  
	  
	  //Main menu bar
	  MenuBar menuBar = new MenuBar();
	  menuBar.getMenus().addAll(fileMenu, editMenu, search, AddMenu,LangMenu, helpMenu);
	  
	 
		 GridPane pane = new GridPane();
		
		pane.setAlignment(Pos.CENTER);
		
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setHgap(5);
		pane.setVgap(5);
		Label label = new Label();
		
		label.setText("Employee Details");

		label.setStyle("-fx-background-color:lightblue; -fx-font-size:15px;");
		pane.getChildren().add(label);

		pane.add(new Label("Employee ID:"), 0, 1);
		pane.add(new TextField(), 1, 1);
		pane.add(new Label("First Name:"), 0, 2);
		pane.add(new TextField(), 1, 2);
		pane.add(new Label("Surname:"), 0, 3);
		pane.add(new TextField(), 1, 3);
		pane.add(new Label("Date Of Birth:"), 0, 4);
		pane.add(new TextField(), 1, 4);
		pane.add(new Label("Email"), 0, 5);
		pane.add(new TextField(), 1, 5);
		
	 
	  HBox hbox = new HBox();
          Button btn = new Button("Add New Employee");
	  btn.setStyle("-fx-font: 20 arial; -fx-base:lightblue");
		
	  Button btn1 = new Button("Update Employee");
	  btn1.setStyle("-fx-font: 20 arial; -fx-base:lightblue");
		
	  hbox.setAlignment(Pos.CENTER);
	  hbox.setPadding(new Insets(20,20,20,20));
	  hbox.setSpacing(15);
	  hbox.getChildren().addAll(btn,btn1);
		
	  layout = new BorderPane();
	  layout.setTop(menuBar);
	  layout.setBottom(hbox);
	  layout.setStyle("-fx-background-image: url(DatabaseConn/images/bk2.jpg)");
		
	  Scene scene = new Scene(layout, 900, 500);
	  window.setScene(scene);
	  window.show();
	}

}

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
		//alt+f e hap File menu
	  Menu fileMenu = new Menu("_File");
	  
	 MenuItem mnN = new MenuItem("New");
	  fileMenu.getItems().add(mnN);
	  mnN.setAccelerator(new KeyCodeCombination(KeyCode.N,  KeyCombination.CONTROL_DOWN));
	   //CTRL+N e hap File/New
		 
	  MenuItem mnO = new MenuItem("Open");
	  fileMenu.getItems().add(mnO); 
	  mnO.setAccelerator(new KeyCodeCombination(KeyCode.O,  KeyCombination.CONTROL_DOWN));
	  	   //CTRL+O e hap File/Open

	  
	  MenuItem mnS = new MenuItem("Save");
	  fileMenu.getItems().add(mnS); 
	  mnS.setAccelerator(new KeyCodeCombination(KeyCode.S,  KeyCombination.CONTROL_DOWN));
	 
	
	  fileMenu.getItems().add(new SeparatorMenuItem());
	  MenuItem mnE = new MenuItem("Exit...");
	  fileMenu.getItems().add(mnE); 
	  mnE.setAccelerator(new KeyCodeCombination(KeyCode.X,  KeyCombination.CONTROL_DOWN));
	  
	  //Edit menu
		
		//alt+e e hap Edit menu
	  Menu editMenu = new Menu("_Edit");
	  editMenu.getItems().add(new MenuItem("Cut"));
	  editMenu.getItems().add(new MenuItem("Copy"));
	  editMenu.getItems().add(new MenuItem("Paste"));
	  
	  //Search menu
		//ALT+S e hap search menu
	  Menu search = new Menu("_Search");
	  
	  //Add menu
		
	  Menu AddMenu = new Menu("_Add");
	 
	 
	  //Language menu
	//ALT+L e hap language menu

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
		pane.add(new Label("Contact"), 0, 6);
		pane.add(new TextField(), 1, 6);
		pane.add(new Label("Address Line 1:"), 0, 7);
		pane.add(new TextField(), 1, 7);
		pane.add(new Label("Address Line 2"), 0, 8);
		pane.add(new TextField(), 1, 8);
		pane.add(new Label("Apt./House No:"), 0, 9);
		pane.add(new TextField(), 1, 9);
		pane.add(new Label("Post Code"), 0, 10);
		pane.add(new TextField(), 1, 10);
		pane.add(new Label("Department:"), 2, 1);
		pane.add(new TextField(), 3, 1);
		pane.add(new Label("Designation:"), 2, 2);
		pane.add(new TextField(), 3, 2);
		pane.add(new Label("Status:"), 2, 3);
		pane.add(new TextField(), 3, 3);
		pane.add(new Label("Date Hired:"), 2, 4);
		pane.add(new TextField(), 3, 4);
		pane.add(new Label("Basic Salary:"), 2, 5);
		pane.add(new TextField(), 3, 5);
		pane.add(new Label("Job Title:"), 2, 6);
		pane.add(new TextField(), 3, 6);
		
		Button btAdd = new Button("Add Record");
		btAdd.setStyle("-fx-font: 15 arial; -fx-base:lightblue");
		pane.add(btAdd, 2, 7);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
		Button btAd1 = new Button("Clear");
		btAd1.setStyle("-fx-font: 15 arial; -fx-base: lightblue");
		pane.add(btAd1, 3, 7);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
	 
	 HBox hbox = new HBox();
	  
	  Button btn = new Button("New Employee");
	  btn.setStyle("-fx-font: 20 arial; -fx-base:lightblue");
	  
	  Button btn1 = new Button("Update Employee");
	  btn1.setStyle("-fx-font: 20 arial; -fx-base:lightblue");
	  
	  hbox.setAlignment(Pos.CENTER);
	  hbox.setPadding(new Insets(20,20,20,20));
	  hbox.setSpacing(15);
	  hbox.getChildren().addAll(btn,btn1);
	  
	  Button btn3 = new Button("<- Back");
	  BorderPane bp = new BorderPane();
	  bp.setCenter(pane);
	  bp.setTop(btn3);
	 

	  Scene scene1 = new Scene(bp,900,500);
	  btn.setOnAction(e -> window.setScene(scene1)); 
	  
	  layout = new BorderPane();
	  layout.setTop(menuBar);
	  layout.setBottom(hbox);
	  layout.setStyle("-fx-background-image: url(DatabaseConn/images/bk2.jpg)");

	  
	  Scene scene = new Scene(layout, 900, 500);
	  btn3.setOnAction(e-> window.setScene(scene));
	  
	  mnN.setOnAction( e-> window.setScene(scene1));
	  mnE.setOnAction( e-> Platform.exit());


		LeftPane leftpane = new LeftPane();
		RightPane rightpane = new RightPane();


			HBox main = new HBox();
			main.getChildren().addAll(leftpane,rightpane);
			
			leftpane.prefWidthProperty().bind(main.widthProperty().divide(4));
			rightpane.prefWidthProperty().bind(main.widthProperty().subtract(main.widthProperty().divide(4)));
			
			
			 Button btn4 = new Button("<- Back");
			  BorderPane bp1 = new BorderPane();
			  bp1.setCenter(main);
			  bp1.setTop(btn4);
			  Scene scene3 = new Scene(bp1,900,500);
			  btn1.setOnAction(e -> window.setScene(scene3)); 
			  btn4.setOnAction(e -> window.setScene(scene));
	  window.setScene(scene);
	  window.show();
	}
}

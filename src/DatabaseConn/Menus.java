package DatabaseConn;

import javafx.application.Application;
//import .sun.prism.Image;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Menus extends MenuBar {
//	Stage window;
//	BorderPane layout;

	public MenuItem mnN = new MenuItem("New");
	public MenuItem mnW = new MenuItem("Welcome");
	public MenuItem mnI = new MenuItem("Info");
	public MenuItem mnE = new MenuItem("Exit...");
	
	
	
	public Menus() {
	 
	  //File menu 
		//alt+f e hap File menu
		 Menu fileMenu = new Menu("_File");
		  
		 mnN = new MenuItem("New");
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

		  fileMenu.getItems().add(mnE); 
		  mnE.setAccelerator(new KeyCodeCombination(KeyCode.X,  KeyCombination.CONTROL_DOWN));
		  
		  //Edit menu
			
			//alt+e e hap Edit menu
		  Menu editMenu = new Menu("_Edit");
		  editMenu.getItems().add(new MenuItem("Cut"));
		  editMenu.getItems().add(new MenuItem("Copy"));
		  editMenu.getItems().add(new MenuItem("Paste"));
		  
		
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
		  //helpMenu.getItems().add(new MenuItem("Welcome"));
		  mnW = new MenuItem("Welcome");
		  helpMenu.getItems().add(mnW);
		  //mnI = new MenuItem("Help Content");
		  helpMenu.getItems().add(mnI);

		  Menu search = new Menu("_Search");
		  Menu AddMenu = new Menu("_Add Menu");
	  
	  //Main menu bar
	 
	  this.getMenus().addAll(fileMenu, editMenu, search, AddMenu,LangMenu, helpMenu);
	  this.setStyle("-fx-background-color:#53788D");
	  

	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

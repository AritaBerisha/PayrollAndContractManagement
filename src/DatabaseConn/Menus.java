package DatabaseConn;

import java.util.Locale;

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

	public MenuItem mnN = I18N.MenuItemForKey("new");
	public MenuItem mnW = I18N.MenuItemForKey("welcome");
	public MenuItem mnI = I18N.MenuItemForKey("info");
	public MenuItem mnE = I18N.MenuItemForKey("exit");
	private Integer numSwitches = 0;
	public Menus() {
	 
	  //File menu 
		//alt+f e hap File menu
		 Menu fileMenu = I18N.menuForKey("file");
		  
		 mnN = I18N.MenuItemForKey("new");
		  fileMenu.getItems().add(mnN);
		  mnN.setAccelerator(new KeyCodeCombination(KeyCode.N,  KeyCombination.CONTROL_DOWN));
		   //CTRL+N e hap File/New
			 
		  MenuItem mnO = I18N.MenuItemForKey("open");
		  fileMenu.getItems().add(mnO); 
		  mnO.setAccelerator(new KeyCodeCombination(KeyCode.O,  KeyCombination.CONTROL_DOWN));
		  	   //CTRL+O e hap File/Open

		  
		  MenuItem mnS = I18N.MenuItemForKey("save");
		  fileMenu.getItems().add(mnS); 
		  mnS.setAccelerator(new KeyCodeCombination(KeyCode.S,  KeyCombination.CONTROL_DOWN));
		 
		
		  fileMenu.getItems().add(new SeparatorMenuItem());

		  fileMenu.getItems().add(mnE); 
		  mnE.setAccelerator(new KeyCodeCombination(KeyCode.X,  KeyCombination.CONTROL_DOWN));
		  
		  //Edit menu
			
			//alt+e e hap Edit menu
		  Menu editMenu =I18N.menuForKey("edit");
		  editMenu.getItems().add(I18N.MenuItemForKey("cut"));
		  editMenu.getItems().add(I18N.MenuItemForKey("copy"));
		  editMenu.getItems().add(I18N.MenuItemForKey("paste"));
		  
		
		  //Language menu
		//ALT+L e hap language menu

		  Menu LangMenu = I18N.menuForKey("language");
		  ToggleGroup LangToggle = new ToggleGroup();
		  
		  RadioMenuItem English = I18N.radioMenuItemForKey("radioitem.english");
		  English.setOnAction((e)->switchLanguage(Locale.ENGLISH));
		  RadioMenuItem German = I18N.radioMenuItemForKey("radioitem.german");
		  German.setOnAction((e)->switchLanguage(Locale.GERMAN));
		  
		  English.setToggleGroup(LangToggle);
		  German.setToggleGroup(LangToggle);
		  
		  LangMenu.getItems().addAll(English,German);
		  
		  //Help menu
		  Menu helpMenu = I18N.menuForKey("help");
		  //helpMenu.getItems().add(new MenuItem("Welcome"));
		  mnW = I18N.MenuItemForKey("welcome");
		  helpMenu.getItems().add(mnW);
		  //mnI = new MenuItem("Help Content");
		  helpMenu.getItems().add(mnI);

		  Menu search = I18N.menuForKey("search");
		  Menu AddMenu =I18N.menuForKey("addmenu");
	  
	  //Main menu bar
	 
	  this.getMenus().addAll(fileMenu, editMenu, search, AddMenu,LangMenu, helpMenu);
	  this.setStyle("-fx-background-color:#53788D");
	  

	}
	public void switchLanguage(Locale locale) {
		numSwitches++;
		I18N.setLocale(locale);
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

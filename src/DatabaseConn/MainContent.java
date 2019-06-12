package DatabaseConn;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainContent extends BorderPane {
     Button btn = new Button("Add Employee");
     Button btn1 = new Button("Update Employee");
     Menus menu1 = new Menus();
     HBox hbox2= new HBox();
	public MainContent() {
        Menus menu = new Menus();
      
       
		BorderPane bp = new BorderPane();
		//bp.setPadding(new Insets(10,10,10,10));
		
	   // HBox hbox2= new HBox();
		hbox2.setPadding(new Insets(50,50,50,50));
		
		VBox vbox1 = new VBox();
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setSpacing(10);
		VBox vbox2 = new VBox();
		vbox2.setSpacing(10);
		vbox2.setAlignment(Pos.CENTER);
		Image searchImage = new Image("file:Images/search.png");
		ImageView SImageView = new ImageView(searchImage);
		SImageView.setFitHeight(200);
		SImageView.setFitWidth(200);
		
		
		Image AddImage = new Image("file:Images/employee.png");
		ImageView AImageView = new ImageView(AddImage);
		AImageView.setFitHeight(200);
		AImageView.setFitWidth(200);
		
		
		  btn.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
		       		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
		       		"    -fx-background-color: #53788D");
		  btn.setTextFill(Color.rgb(186, 201, 209));

		  
		 
		  btn1.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
		       		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
		       		"    -fx-background-color: #53788D");
		  btn1.setTextFill(Color.rgb(186, 201, 209));

		  
		  vbox1.getChildren().addAll(SImageView,btn1);
		  vbox2.getChildren().addAll(AImageView,btn);
		 
		  
		  Button btn3 = new Button("<- Back");
		  
		hbox2.getChildren().addAll(vbox1,vbox2);
		hbox2.setSpacing(10);
		hbox2.setAlignment(Pos.CENTER);
			
		 
	 
	         
	        VBox vbox3= new VBox();
	        //vbox3.getChildren().addAll(menu1,tab);
		this.setTop(menu1);
		this.setCenter(hbox2);
		this.setStyle("-fx-background-color:#2B4857;");
		
	}
	

}

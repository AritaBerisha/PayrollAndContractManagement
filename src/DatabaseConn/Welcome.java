package DatabaseConn;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Welcome extends BorderPane{
	public Button btn3 = new Button("<- Back");
	public Welcome() {
		StackPane pane = new StackPane();
		
		pane.setAlignment(Pos.CENTER);
		
		
		
	    Image usernameIcon = new Image("file:Images/welcome.png");
	    ImageView usernameIconIV = new ImageView(usernameIcon);
	        usernameIconIV.setFitWidth(500);
	        usernameIconIV.setFitHeight(200);
		
	   Text text = new Text();
	   text.setText("Welcome to this company's payroll and contract managment program!");
	  
	   text.setFill(Color.rgb(186, 201, 209));

	   VBox vbox = new VBox();
	   vbox.getChildren().addAll(usernameIconIV,text);
	   vbox.setSpacing(30);
	   vbox.setAlignment(Pos.CENTER);
		
		pane.getChildren().add(vbox);

		
		
		
		this.setCenter(pane);
		this.setTop(btn3);
	
		this.setStyle("-fx-background-color:  #53788D");
		btn3.setStyle( "    -fx-padding: 3px 10px 3px 10px;\r\n" + 
          		"    -fx-background-color: #2C3E48");
		btn3.setTextFill(Color.rgb(186, 201, 209));
	}
}

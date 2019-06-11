package DatabaseConn;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class UpdateEmployee extends BorderPane{
	public Button btn4 = new Button("<- Back");
	
	public UpdateEmployee() {
		LeftPane leftpane = new LeftPane();
		RightPane rightpane = new RightPane();


	    HBox main = new HBox();
			  
	    main.getChildren().addAll(leftpane,rightpane);
			
		leftpane.prefWidthProperty().bind(main.widthProperty().divide(4));
		rightpane.prefWidthProperty().bind(main.widthProperty().subtract(main.widthProperty().divide(4)));
		//Button btn4 = new Button("<- Back");
		this.setCenter(main);
	    this.setTop(btn4); 
	}

}

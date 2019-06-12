package DatabaseConn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainPane extends Application{
	
	LeftPane leftpane = new LeftPane();
	RightPane rightpane = new RightPane();
	Menus menu = new Menus();

	public static void main(String[] args)
               {    
		launch(args);
		}
	@Override
	public void start(Stage primaryStage) throws Exception{
		BorderPane bp = new BorderPane();
		HBox main = new HBox();
		main.getChildren().addAll(leftpane,rightpane);
		
		//bp.setTop(menu);
		bp.setCenter(main);
		leftpane.prefWidthProperty().bind(main.widthProperty().divide(4));
		rightpane.prefWidthProperty().bind(main.widthProperty().subtract(main.widthProperty().divide(4)));
		
		Scene scene = new Scene(bp,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}


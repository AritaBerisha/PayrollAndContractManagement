package DatabaseConn;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RightPane extends VBox {
	
	HBox searchPane = new HBox();
	
	TextField txtSearch = new TextField();
	Button btnSearch = new Button("Search!");
	Button search = new Button("Search");
	

	TableView table = new TableView();
	
	public RightPane() {	
		
	searchPane.getChildren().addAll(txtSearch,btnSearch);
	searchPane.setSpacing(10);
	searchPane.setPadding(new Insets(20));
	searchPane.setAlignment(Pos.CENTER);
	
	table.setPrefHeight(800);
	this.setPadding(new Insets(20));
	this.getChildren().addAll(searchPane,table);
	this.setStyle("-fx-background-color:  #53788D");
	this.btnSearch.setTextFill(Color.rgb(186, 201, 209));
	this.btnSearch.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
      		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
      		"    -fx-background-color: #2C3E48");
	
	}
}

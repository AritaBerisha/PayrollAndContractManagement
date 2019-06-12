package DatabaseConn;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RightPane extends VBox {
	
	HBox searchPane = new HBox();
	
	TextField txtSearch = new TextField();
	Button btnSearch = new Button("Search!");
	

	TableView table = new TableView();
	
	public RightPane() {	
		
	searchPane.getChildren().addAll(txtSearch,btnSearch);
	searchPane.setSpacing(10);
	searchPane.setPadding(new Insets(20));
	searchPane.setAlignment(Pos.CENTER);
	
	table.setPrefHeight(800);
	this.setPadding(new Insets(20));
	this.getChildren().addAll(searchPane,table);
	
	}
}

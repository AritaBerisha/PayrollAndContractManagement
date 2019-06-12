package DatabaseConn;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Help {
	
	public void about() {
		Tab newtab = new Tab(); 
		TabPane tbpane = new TabPane();
		 
		 Stage helpAboutStage = new Stage();
	    newtab.setOnSelectionChanged(e-> {if (newtab.isSelected())  
        { 
			
            Tab tab = new Tab("Tab_" ); 
      
    		WebView browser = new WebView();

    		WebEngine webEngine = browser.getEngine();

    		String url = Help.class.getResource("info.html").toExternalForm();

    		System.out.println("Local URL: " + url);
    		
    		webEngine.load(url);
    		
    		tab.setContent(browser);
            
            tbpane.getTabs().add( 
                    tbpane.getTabs().size() - 1, tab); 

            
            tbpane.getSelectionModel().select( 
                    tbpane.getTabs().size() - 2); 
        } }); 
	    
	   tbpane.getTabs().add(newtab);

		Scene sc = new Scene(tbpane, 500, 300);

		helpAboutStage.setTitle("Help - About");
		helpAboutStage.setScene(sc);

		helpAboutStage.show();

	}
}

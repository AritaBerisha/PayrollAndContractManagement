package DatabaseConn;


import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.TilePane;

public class progressi extends TilePane{

	static double ii = 0; 
	ProgressIndicator pb = new ProgressIndicator(); 
    public progressi() { 
        
        this.getChildren().add(pb); 
       
    } 
  
}

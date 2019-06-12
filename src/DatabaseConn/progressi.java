package ProjektiNew;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import java.io.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.Label; 
import javafx.stage.Stage; 
import java.net.*; 
public class progressi extends Application { 
  
    static double ii = 0; 
   
    public void start(Stage s) throws Exception 
    { 
        
        ProgressIndicator pb = new ProgressIndicator(); 
       
        TilePane r = new TilePane(); 
  
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                
                ii += 0.1; 
                pb.setProgress(ii); 
               } 
  
        }; 
     Button b = new Button("loading..."); 
    
        b.setOnAction(event); 
        b.setStyle("-fx-background-color:#60a3bc");
  
   r.getChildren().add(pb); 
        r.getChildren().add(b); 
        
  

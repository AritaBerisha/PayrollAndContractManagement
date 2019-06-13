package DatabaseConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
  

public class Login extends Application {
  
	
	private TextField emailTxt = new TextField();
	private PasswordField passwordTxt = new PasswordField();
	private TextField userTxt = new TextField();

	
	private Stage mainStage;
	
    public static void main(String[] args) {
        launch(args);
    }
      
    @Override
    public void start(Stage primaryStage) {
    	
    	mainStage = primaryStage;
    	 
         emailTxt.setPromptText("Email");
         passwordTxt.setPromptText("Password");
         userTxt.setPromptText("Username");
 
         BorderPane bp = new BorderPane();
         bp.setPadding(new Insets(10,50,50,50));
         
       
         HBox hb = new HBox();
         hb.setPadding(new Insets(20,20,2,30));
         
       
         GridPane gridPane = new GridPane();
         gridPane.setPadding(new Insets(20,20,20,20));
         gridPane.setHgap(5);
         gridPane.setVgap(5);
   
        Image usernameIcon = new Image("file:Images/icon.png");
        ImageView usernameIconIV = new ImageView(usernameIcon);
        usernameIconIV.setFitWidth(20);
        usernameIconIV.setFitHeight(20);
  
        Image usernameIcon2 = new Image("file:Images/icon3.png");
        ImageView usernameIconIV2 = new ImageView(usernameIcon2);
        usernameIconIV2.setFitWidth(20);
        usernameIconIV2.setFitHeight(20);
        
        Image usernameIcon3 = new Image("file:Images/email.png");
        ImageView usernameIconIV3 = new ImageView(usernameIcon3);
        usernameIconIV3.setFitWidth(20);
        usernameIconIV3.setFitHeight(20);
 
        HBox hb2=new HBox();
        hb2.setPadding(new Insets(5,20,0,5));
        Button btnLogin = new Button("Login");
         btnLogin.setTextFill(Color.rgb(186, 201, 209));
        btnLogin.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
        		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
        		"    -fx-background-color: #2C3E48");
        Button btnRegister = new Button("Register");
        btnRegister.setTextFill(Color.rgb(186, 201, 209));
       btnRegister.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
       		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
       		"    -fx-background-color: #2C3E48");
       
       
       hb2.getChildren().addAll(btnLogin,btnRegister);
       hb2.setSpacing(5);
        
        
       
        btnLogin.setOnAction(e-> loginUser());
        
        
        
        gridPane.add(usernameIconIV, 0, 0);
        gridPane.add(userTxt, 1, 0);
        gridPane.add(usernameIconIV2, 0, 1);
        gridPane.add(passwordTxt, 1, 1);
        gridPane.add(hb2, 1, 2);
        
        
          
        gridPane.setStyle("-fx-background-color: #53788D  ;\r\n" + 
        		" -fx-padding: 20 10 10 10;\r\n" + 
        		" -fx-background-radius: 20;");
        
         
        
        Text text = new Text("Login");
        text.setTextAlignment(TextAlignment.CENTER);
     
        text.setStyle("-fx-font-family: Pacifico;-fx-font-size:30");
        text.setFill(Color.rgb(196, 206, 212));
  
        
        hb.getChildren().add(text);
   
        hb.setAlignment(Pos.CENTER);
        
       bp.setStyle("-fx-background-color:#2B4857;");
        bp.setTop(hb);
        bp.setCenter(gridPane);  
        
        
        
        
     Scene scene = new Scene(bp);
   
     scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Pacifico&display=swap");
 
     
     
     
     
     /////////////////////////SIGN UP/////////////////
    

     SignUp signup = new SignUp();
     
     Scene scene2 = new Scene(signup);
     
     
     signup.btnLogIn.setOnAction(e->{
    	 primaryStage.setScene(scene);
         primaryStage.setTitle("Login");
       primaryStage.setResizable(false);
     });
     
     scene2.getStylesheets().add("https://fonts.googleapis.com/css?family=Pacifico&display=swap");
     btnRegister.setOnMouseClicked(e->{
    	 primaryStage.setScene(scene2);
    	 primaryStage.setTitle("Sign up");
         primaryStage.setResizable(false);
         signup.emailTxt.setText("");
	     signup.passwordTxt.setText("");
	     signup.userTxt.setText("");
     });
     
   
     
     //////////////////////////////////////////////////////////////////////
     
     
     
     primaryStage.setScene(scene);
       primaryStage.setTitle("Login");
     primaryStage.setResizable(false);
   
    
     primaryStage.show();
    gridPane.requestFocus();
    
    }
    
    
    
    
    ///////////DataBase///////////////////////////////////////////////
    
   
    
    
    private void loginUser() {
    	
    	if(userTxt.getText().isEmpty() || passwordTxt.getText().isEmpty()) {
			 Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Please fill up");
				alert.showAndWait();
		 }
    	else{
    		String query = "Select * from managers where username = ? AND upassword = ?";
    		try {
    			
    			PreparedStatement preparedStatement = DBConnection.setConnection().prepareStatement(query);
    		
    				preparedStatement.setString(1, userTxt.getText());
    				preparedStatement.setString(2, passwordTxt.getText());
    			
    			ResultSet result = preparedStatement.executeQuery();
    			
    			if(result.next()) {
    				
    				
    				mainStage.hide();
    				MainProgram.createMainStage();
    				
    			} else {
    				Alert alert = new Alert(AlertType.ERROR);
    				alert.setTitle("Login result");
    				alert.setHeaderText(null);
    				alert.setContentText("Email or password is wrong!");
    				alert.showAndWait();
    				
    			}
    			
    		} catch(SQLException ex) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Database problem2");
    			alert.setHeaderText(null);
    			alert.setContentText(ex.getMessage());
    			alert.showAndWait();
    			ex.printStackTrace();
    			System.exit(0);
    		}
    	
    	}
		
    }
    
    	
}



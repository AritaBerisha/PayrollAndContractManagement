package DatabaseConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
  

public class Login extends Application {
  
	
	private TextField emailTxt = new TextField();
	private PasswordField passwordTxt = new PasswordField();

	private Connection dbConnection;
	private Stage mainStage;
	
    public static void main(String[] args) {
        launch(args);
    }
      
    @Override
    public void start(Stage primaryStage) {
    	//kta e kom kriju edhe e kom perdor te loginUser pasi qe login osht me sukses 
    	 mainStage = primaryStage;
    	 setConnection();
         emailTxt.setPromptText("Email");
         passwordTxt.setPromptText("Password");
         
 
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
        
        
        //lidhja e butonit me metoden LoginUser
        btnLogin.setOnAction(e-> loginUser());
        
       //ktu e kom bo me shortcut me u log in..nese e shtyp CTRL+L munesh mu login
        btnLogin.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.L && e.isShortcutDown()) {
            	loginUser();	
            }
        }); btnLogin.requestFocus();
        
        
        
        gridPane.add(usernameIconIV, 0, 0);
        gridPane.add(emailTxt, 1, 0);
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
    
    
        
     Text textSignUp = new Text("Sign Up");
     textSignUp.setTextAlignment(TextAlignment.CENTER);
  
     textSignUp.setStyle("-fx-font-family: Pacifico;-fx-font-size:30");
     textSignUp.setFill(Color.rgb(196, 206, 212));
     
     Button btnSignUp = new Button("Sign Up");
     btnSignUp.setTextFill(Color.rgb(186, 201, 209));
    btnSignUp.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
    		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
    		"    -fx-background-color: #2C3E48");
    
//    Button btnLogIn = new Button(" Login ");
//    btnLogIn.setTextFill(Color.rgb(186, 201, 209));
//   btnLogIn.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
//   		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
//   		"    -fx-background-color: #2C3E48");
    
     HBox hbSignUp = new HBox();
     
     hbSignUp.getChildren().add(textSignUp);
     hbSignUp.setPadding(new Insets(20,20,2,30));
     hbSignUp.setAlignment(Pos.CENTER);
     
     BorderPane bpSignUp = new BorderPane();
     bpSignUp.setPadding(new Insets(10,50,50,50));
     
     GridPane gridPaneSU = new GridPane();
     gridPaneSU.setPadding(new Insets(20,20,20,20));
     gridPaneSU.setHgap(5);
     gridPaneSU.setVgap(5);
     
     HBox hbSignUp2= new HBox();
     hbSignUp2.setPadding(new Insets(5,30,10,5));
     hbSignUp2.getChildren().addAll(btnSignUp);
     hbSignUp2.setSpacing(5);
     

//     gridPaneSU.add(usernameIconIV, 0, 0);
//     gridPaneSU.add(emailTxt, 1, 0);
//     gridPaneSU.add(usernameIconIV2, 0, 1);
//     gridPaneSU.add(passwordTxt, 1, 1);
//     gridPaneSU.add(hbSignUp2, 1, 2);
     
     gridPaneSU.setStyle("-fx-background-color: #53788D  ;\r\n" + 
     		" -fx-padding: 20 10 10 10;\r\n" + 
     		" -fx-background-radius: 20;");
     
     bpSignUp.setStyle("-fx-background-color:#2B4857;");
     bpSignUp.setTop(hbSignUp);
     bpSignUp.setCenter(gridPaneSU);
     
     Scene scene2 = new Scene(bpSignUp);
     
     btnSignUp.setOnAction(e->SignUpUser());
     
     scene2.getStylesheets().add("https://fonts.googleapis.com/css?family=Pacifico&display=swap");
     btnRegister.setOnMouseClicked(e->{
    	 gridPaneSU.add(usernameIconIV, 0, 0);
         gridPaneSU.add(emailTxt, 1, 0);
         gridPaneSU.add(usernameIconIV2, 0, 1);
         gridPaneSU.add(passwordTxt, 1, 1);
         gridPaneSU.add(hbSignUp2, 1, 2);
    	 primaryStage.setScene(scene2);
    	 primaryStage.setTitle("Sign up");
         primaryStage.setResizable(false);
     });
     
   
     
     //////////////////////////////////////////////////////////////////////
     
     
     
     primaryStage.setScene(scene);
       primaryStage.setTitle("Login");
     primaryStage.setResizable(false);
   
    
     primaryStage.show();
    gridPane.requestFocus();
    
    }
    
    
    
    
    ///////////DataBase///////////////////////////////////////////////
    
    private void setConnection() {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			//dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/knkproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			
		} catch (Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem1");
			alert.setHeaderText(null);
			alert.setContentText("Can not connect to database");
			alert.showAndWait();
			ex.printStackTrace();
			System.exit(0);
		}
    }
    
    private void loginUser() {
		String query = "Select * from users where Employee_email = ? AND Employee_pass = ?";
		try {
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
		
				preparedStatement.setString(1, emailTxt.getText());
				preparedStatement.setString(2, passwordTxt.getText());
			
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login result");
				alert.setHeaderText(null);
				alert.setContentText("You are logged in!");
				alert.showAndWait();
				
				mainStage.hide();
				MainProgram.createMainStage();
				
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
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
			System.exit(0);
		}
	}
    private void SignUpUser() {
    	
    	String query1 = "Insert into users(Employee_email,Employee_pass) values ('"+emailTxt.getText()+"','"+passwordTxt.getText()+"')";
        try {
			
		
			Statement statement = dbConnection.createStatement();
			statement.executeUpdate(query1);
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sign Up");
			alert.setHeaderText(null);
			alert.setContentText("Sign Up was sucessful!");
			alert.showAndWait();
			
			mainStage.hide();
			MainProgram.createMainStage();
				
			}
			
		 catch(SQLException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem2");
			alert.setHeaderText(null);
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
			System.exit(0);
		}
	}
    	
}



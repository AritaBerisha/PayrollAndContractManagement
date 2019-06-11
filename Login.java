package DatabaseConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
         
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
         
       
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
         
       
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
      

        Label lblUserName = new Label("Username");
        Label lblPassword = new Label("Password");
        Button btnLogin = new Button("Login");
         btnLogin.setTextFill(Color.WHITE);
        btnLogin.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" + 
        		"    -fx-padding: 3px 10px 3px 10px;\r\n" + 
        		"    -fx-background-color: linear-gradient(CORNFLOWERBLUE , lightblue);");
        
        
        //lidhja e butonit me metoden LoginUser
        btnLogin.setOnAction(e-> loginUser());
        
       //ktu e kom bo me shortcut me u log in..nese e shtyp CTRL+L munesh mu login
        btnLogin.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.L && e.isShortcutDown()) {
            	loginUser();
            	
            }
        }); btnLogin.requestFocus();
        
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(emailTxt, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(passwordTxt, 1, 1);
        gridPane.add(btnLogin, 2, 1);
         
                 
        // Reflection i gridpanes
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);
        gridPane.setStyle("-fx-background-color:  linear-gradient(lightblue, CORNFLOWERBLUE);\r\n" + 
        		" -fx-border-color: white;\r\n" + 
        		" -fx-border-radius: 20;\r\n" + 
        		" -fx-padding: 10 10 10 10;\r\n" + 
        		" -fx-background-radius: 20;");
        
        
        //Efekti Drop Shadow per tekst
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);
        dropShadow.setColor(Color.CADETBLUE);
         
        
        Text text = new Text("Login here");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);
         text.setStyle("-fx-fill:  linear-gradient(CORNFLOWERBLUE , lightblue);");
      
        hb.getChildren().add(text);
    
       
        bp.setTop(hb);
        bp.setCenter(gridPane);  
         
        
     Scene scene = new Scene(bp);
    
     primaryStage.setScene(scene);
       primaryStage.setTitle("Login");
     primaryStage.setResizable(false);
    
     primaryStage.show();
    gridPane.requestFocus();
    }
    
    
    private void setConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","nihon123");
			
		} catch (Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText("Can not connect to database");
			alert.showAndWait();
			System.exit(0);
		}
    }
    
    private void loginUser() {
		String query = "Select * from users where email = ? AND pass = ?";
		
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
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
			System.exit(0);
		}
	}
}



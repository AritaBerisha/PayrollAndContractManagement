package DatabaseConn;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DBConnection {

	private static Connection dbConnection;
	
	 public static Connection setConnection() {
			try {
				//Class.forName("com.mysql.cj.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
				//dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/knkproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				
			} catch (Exception ex) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Database problem1");
				alert.setHeaderText(null);
				alert.setContentText("Can not connect to database");
				alert.showAndWait();
				ex.printStackTrace();
				System.exit(0);
			}
			
			return dbConnection;
	    }
 
}

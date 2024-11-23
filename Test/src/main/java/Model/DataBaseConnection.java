package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {


	  private static Connection connection;
	  
	  static {
	 	 
	 		 try {
	 			 Class.forName("com.mysql.jdbc.Driver");
	 			 connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/scorejeux","root","")	;
	 			 
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 	 
	  }

	 public static Connection getConnection() {
	 	return connection;
	 }
	  
	  
	  
	 	
}

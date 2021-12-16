package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

<<<<<<< HEAD
	//mac
	public static Connection getConnectionMac() {
		 
		String url = "jdbc:mysql://localhost:8889/";
		String dbName = "pepon";
=======
	public static Connection getConnection() {
		 
		String url = "jdbc:mysql://localhost:8889/";
		String dbName = "pepon";
		//Windows
>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
		String user="root";
		String pwd="root";
		
		
		Connection connect = null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");

		     try {
		    	 connect = DriverManager.getConnection(url+dbName,user,pwd);
				System.out.println("OK for connect");
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connect;
<<<<<<< HEAD
	}
	
	//windows
	public static Connection getConnectionWindows() {
		 
		String url = "jdbc:mysql://localhost/";
		String dbName = "pepon";
		String user="root";
		String pwd="";
		
		
		Connection connect = null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");

		     try {
		    	 connect = DriverManager.getConnection(url+dbName,user,pwd);
				System.out.println("OK for connect");
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connect;
	}
=======
		}
>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
}

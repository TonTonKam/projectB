package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	public static Connection getConnection() {
		 
		String url = "jdbc:mysql://localhost:8889/";
		String dbName = "pepon";
		//Windows
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
		}
}

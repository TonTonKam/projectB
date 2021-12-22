package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.JDBCType;
import javax.swing.JTable;

import model.User;

public class UserDao {
	//Appel de la connection
		Connection connect = GetConnection.getConnectionMac();
		//Connection connect = GetConnection.getConnectionWindows();
		public static User currentUser ;
		private JTable table;
		
		public boolean mailExist(String email) {
			Boolean msg = false;
			try {
				PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email = ?");
				
				sql.setString(1, email);
				
				ResultSet rs = sql.executeQuery();
				
				if(!rs.next()) {
					msg = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return msg;
		}
		
		public void inscription(User user) {
			
			try {
				PreparedStatement sql = connect.prepareStatement("INSERT INTO user (nom, prenom, email, mot_passe)"
						+ " VALUES (?,?,?,PASSWORD(?))");
				sql.setString(1, user.getNom());
				sql.setString(2, user.getPrenom());
				sql.setString(3, user.getEmail());
				sql.setString(4, user.getMotPasse());
				
				sql.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public boolean login(String identifiant, String motPasse) {
			  
			Boolean msg = false;
			try {
				PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email=? AND mot_passe=PASSWORD(?)");
				sql.setString(1, identifiant);
				sql.setString(2, motPasse);
				
				///System.out.println(sql);
				ResultSet rs = sql.executeQuery();
				
				if(rs.next()) {
					currentUser = new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("mot_passe"));
					msg = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return msg;
			
		}

		public boolean isAdmin(String identifiant, String motPasse) {
			  
			Boolean msg = false;
			try {
				PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email=? AND mot_passe=PASSWORD(?)");
				sql.setString(1, identifiant);
				sql.setString(2, motPasse);
				
				///System.out.println(sql);
				ResultSet rs = sql.executeQuery();
				
				if(rs.next()) {
					currentUser = new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("mot_passe"),rs.getInt("id_statut"));
					if(rs.getInt("id_statut")==2) {
					msg = true;}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return msg;
			
		}


}
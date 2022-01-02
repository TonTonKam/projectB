package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.JDBCType;
import javax.swing.JTable;

import model.Article;
import model.User;
import model.VarStatic;

public class UserDao {
	//Appel de la connection

		//Connection connect = GetConnection.getConnectionMac();
		Connection connect = GetConnection.getConnectionWindows();

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
				PreparedStatement sql = connect.prepareStatement("INSERT INTO user (nom, prenom, email, mot_passe, id_statut)"
						+ " VALUES (?,?,?,PASSWORD(?), 1)");
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

					VarStatic.currentUserStatic = new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("mot_passe"),rs.getInt("id_statut"), rs.getInt("id_user"));
					msg = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return msg;
			
		}
		
		public boolean isAdmin(User user) {
			
			Boolean msg = false;
			
			if(user.getIdStatut() == 1) {
				msg = true;
			}
				
			return msg;
			
		}


}
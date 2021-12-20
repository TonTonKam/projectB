package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class ControllerArticleAdmin {
	//Appel de la connection
	//Connection connect = GetConnection.getConnectionMac();
	Connection connect = GetConnection.getConnectionWindows();
	
	public void afficherTableArticle(JTable table) {
		
		try {
			//récupération des info de  table article
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM article");
			// Conversion de la requete en tableau d'objets
			ResultSet rs =sql.executeQuery();
			/*
			 * J'appelle la méthode setModel pour inserer les objets dans notre table
			 * table = objet Jtable 
			 * j'appelle setModel de l'objet Jtable.
			 * setModel a comme parametre :
			 * DbUtils = la libraire ?
			 * la méthode resultSetToTableModel modifie la table Model.
			 * cette méthode prend comme param notre tableau d'objet rs.
			 * 
			 * ca Modifie la variable table de type Jtable avec les instructions resultSetToTableModel
			 *  qui contient le rs
			 */
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Méthode pour chercher un article  par id
	public void findById(String id, JTextField nom_article, JTextField nutripoint,JTextField prix, JTextField id_categorie) {
		try { 
			PreparedStatement sql = connect.prepareStatement("SELECT  nom_article, nutripoint, prix, id_categorie  FROM article WHERE id_article = ?");
			
			sql.setNString(1, id);
			
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) {
				//String id = rs.getString(1);
				String name_product = rs.getString(1);
				String nutripointe = rs.getString(2);
				String price = rs.getString(3);
				String category = rs.getString(4);
				
			
				nom_article.setText(name_product);
				nutripoint.setText(nutripointe);
				prix.setText(price);
				id_categorie.setText(category);
			}else {
				nom_article.setText("");
				nutripoint.setText("");
				prix.setText("");
				id_categorie.setText("");
			}
			
		} catch (SQLException event) {
			// TODO Auto-generated catch block
			event.printStackTrace();
		}
	}
	
	//Méthode  pour vider les champs
	public void viderChamps(JTextField a,JTextField b,JTextField c,JTextField d,JTextField f) {
		a.setText("");
		b.setText("");
		c.setText("");
		d.setText("");
		f.requestFocus();		
	}
	
	
}

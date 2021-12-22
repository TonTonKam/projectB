package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Article;
import model.User;
import net.proteanit.sql.DbUtils;

public class ControllerArticleAdmin {
	//Appel de la connection
	//Connection connect = GetConnection.getConnectionMac();
	Connection connect = GetConnection.getConnectionWindows();
	
	public void afficherTableArticle(JTable table) {
		
		try {
			//récupération des info de  table article
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM article");
			
			ResultSet rs =sql.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Méthode pour vérifier l'existance deja du produit
	public boolean articleExist(String art) {
		Boolean msg = false;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM article WHERE nom_article = ?");
			
			sql.setString(1, art);
			
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
	
	//Méthode pour ajouter uu article 
	public void ajouter(Article art) {
		
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO article (nom_article, nutripoint, prix, id_categorie)"
					+ " VALUES (?,?,?,?)	");
			sql.setString(1, art.getNomArticle());
			sql.setInt(2, art.getNutripoint());
			sql.setFloat(3, (float) art.getPrix());
			sql.setInt(4, art.getIdCategorie());
			
			sql.executeUpdate();
			
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
	// Méthode pour modifier un article 
	public void modifier( String nomArticle, int nutripoint, double prix_saisie, int  idCategorie, String idTextArticle) {
		try {
			PreparedStatement sql = connect.prepareStatement("UPDATE article set nom_article= ?,nutripoint = ?,prix= ?,id_categorie = ?" 
					+ " where id_article =?");
			sql.setString(1, nomArticle);
			sql.setInt(2, nutripoint);
			sql.setDouble(3,(double) prix_saisie);
			sql.setInt(4, idCategorie);
			
			sql.setString(5, idTextArticle);
			
			sql.executeUpdate();
			JOptionPane.showMessageDialog(null, "l'article " + " "+ nomArticle +" a été bien modifié." );
		} catch (SQLException event) {
			// TODO Auto-generated catch block
			event.printStackTrace();
		}
		
	}
	
	public void supprimer(String textIdArticle) {
		try {
			PreparedStatement sql = connect.prepareStatement("delete from article where id_article =?");
			
			sql.setString(1,textIdArticle);
			
			sql.executeUpdate();
			JOptionPane.showMessageDialog(null,"l'article qui a l'id n°: "+ textIdArticle +" a été bien supprimé." );
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

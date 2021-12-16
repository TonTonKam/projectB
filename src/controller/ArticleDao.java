package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Article;

public class ArticleDao {

	Connection connect = GetConnection.getConnection();
	
	public boolean ajout(Article object) {
		
		boolean message = false;
		try {
			
			PreparedStatement req = connect.prepareStatement("INSERT INTO article"
					+ "(nom_article,nutripoint,prix,categorie) VALUES (?,?,?,?,?) ");
			
			req.setString(1, object.getNom_article());
			req.setInt(2, object.getNutripoint());
			req.setDouble(3, object.getPrix());
			req.setInt(4, object.getCategorie());
			
			req.executeUpdate();
			message = true;
			System.out.println("Insertion OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
			
		}
		return message;
		
	}

	//Affichage des articles
		public List<Article> read() {
			List<Article> listeArticle = new ArrayList<>();
			
			try {
				PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
				
				ResultSet rs = req.executeQuery();
				//System.out.println(req);
				while(rs.next()) {
					//String nom_article, int nutripoint, double prix, int categorie
					Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("categorie"),rs.getInt("id_article"));
				
					
					listeArticle.add(article);
				}
				//System.out.println("-------------------"+listeArticle);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Insertion KO - KO - KO");
			}
			return listeArticle;
		}

		public List<Article> findById(int id) {
			List<Article> listearticle = new ArrayList<>();
			try {
				PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id=?");
				req.setInt(1, id);
				
				ResultSet rs = req.executeQuery();
				
				while(rs.next()) {
					Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("categorie"),rs.getInt("id_article"));
					
					listearticle.add(article);
				}
				System.out.println(listearticle);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Insertion KO - KO - KO");
			}
			return listearticle;
		}

}

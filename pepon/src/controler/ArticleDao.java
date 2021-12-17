package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Article;

public class ArticleDao {

	Connection connect = GetConnection.getConnectionWindows();
	
	public boolean ajout(Article object) {
		
		boolean message = false;
		try {

			PreparedStatement req = connect.prepareStatement("INSERT INTO article"
					+ "(nom_article,nutripoint,prix,categorie) VALUES (?,?,?,?,?) ");
			
			req.setString(1, object.getNomArticle());
			req.setInt(2, object.getNutripoint());
			req.setDouble(3, object.getPrix());
			req.setInt(4, object.getIdCategorie());
			
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
	public List<Article>  readArt(){
		List<Article> listeArticle = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
			
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				//String nom_article, int nutripoint, double prix, int categorie
				Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
			
				
				listeArticle.add(article);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeArticle;
	}
	
	public List<Article>  readCategorieLegumes(){
		List<Article> listeArticle = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id_categorie = 2");
			
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				//String nom_article, int nutripoint, double prix, int categorie
				Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
				
				
				listeArticle.add(article);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeArticle;
	}
	
	public List<Article>  readCategorieFruits(){
		List<Article> listeArticle = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id_categorie = 1");
			
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				//String nom_article, int nutripoint, double prix, int categorie
				Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
				
				
				listeArticle.add(article);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeArticle;
	}
	
	public List<Article>  readCategorieCharcuteries(){
		List<Article> listeArticle = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id_categorie = 4");
			
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				//String nom_article, int nutripoint, double prix, int categorie
				Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
				
				
				listeArticle.add(article);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeArticle;
	}
	
	public List<Article>  readCategorieBoisson(){
		List<Article> listeArticle = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id_categorie = 3");
			
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				//String nom_article, int nutripoint, double prix, int categorie
				Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
				
				
				listeArticle.add(article);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeArticle;
	}
	
	public List<Article>  readCategorieConcerves(){
		List<Article> listeArticle = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id_categorie = 5");
			
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				//String nom_article, int nutripoint, double prix, int categorie
				Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
				
				listeArticle.add(article);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeArticle;
	}

	public List<Article> findById(int id) {
		List<Article> listearticle = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id_article=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
				
				listearticle.add(article);
			}
			System.out.println(listearticle);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listearticle;
	}
	
	public String idCategorieToString(int idCategorie) {
		String nomCate = null; 
		try {
			PreparedStatement req = connect.prepareStatement("SELECT libelle FROM categorie WHERE id_categorie=?");
			req.setInt(1, idCategorie);
			
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				nomCate = rs.getString("libelle");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomCate;
	}

}

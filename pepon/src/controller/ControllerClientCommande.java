package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.VarStatic;

public class ControllerClientCommande {
	
	Connection connect = GetConnection.getConnectionWindows();
	//Connection connect = GetConnection.getConnectionMac();

	/*
	 * montant total
	 * moyenne des nutripoints
	 * quantite de chaque article
	 * quantite total d'article achete
	 * 
	 * fair une ligne ObjectArticleCommande avec nom, quantite, prix unitaire, nutripoint, totalArticle
	 */
	
	//on recupere la quantite pour la mettre dans la presentation du modelCommande
	public int getQuantPanier(Article article) {
		int quantite = 0;
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT quantite FROM panier WHERE id_article = ?");
			sql.setInt(1, article.getIdArticle());
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				quantite = rs.getInt("quantite");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quantite;
	}
	
	//on affiche le panier.id_article.prixArticle * panier.quantite dans total
	public double getPrixTotal(Article article, int qte) {
		double result = 0;
		
		result = article.getPrix() * qte;
		
		return result;
	}
	
	//on affiche tous les articles de la commande
	public List<Article> afficherListCommand(){
		ArrayList<Article> listArt = new ArrayList();
		
		try {
			//les id_article lier a la commande X
			PreparedStatement sql = connect.prepareStatement("SELECT id_article FROM panier WHERE id_commande = ?");
			sql.setInt(1, VarStatic.idCommandeStatic);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listArt;
		
	}
}

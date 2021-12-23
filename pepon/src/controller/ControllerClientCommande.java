package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Article;
import model.PanelModelArtCommande;
import model.VarStatic;
import vue.PanelClientCommande;

public class ControllerClientCommande {
	
	Connection connect = GetConnection.getConnectionWindows();
	//Connection connect = GetConnection.getConnectionMac();

	private ArticleDao artDao = new ArticleDao();
	private PanelModelArtCommande panelModelArtComm;
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
	
	//list tout les articles de la commande
	private ArrayList<Article> listCommand(){
		ArrayList<Article> listArt = new ArrayList();
		
		try {
			//les id_article lier a la commande X
			PreparedStatement sql = connect.prepareStatement("SELECT id_article FROM panier WHERE id_commande = ?");
			sql.setInt(1, VarStatic.idCommandeStatic);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				listArt.add(artDao.readIdArticle(rs.getInt("id_article")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listArt;
	}
	
	//integre les elements de la liste commande
	public void afficheModelArtCommande(JPanel reception, int longueurM) {
		for(int i = 0; i < listCommand().size(); i++) {
			reception.add(new PanelModelArtCommande(listCommand().get(i), longueurM)) ;
		}
	}
	
	//afficher le nombre article total que le client a mis dans son panier
	private String afficheNbArticleTotal() {
		
		int resultat = 0;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT quantite FROM panier WHERE id_commande = ?");
			sql.setInt(1, VarStatic.idCommandeStatic);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				resultat =+ rs.getInt("quantite");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(resultat);
	}
	
	//affiche et ajout dans la bdd
	private String afficherMontantTotal() {
		
		ArrayList<Integer> listQuantite = new ArrayList();
		int prixTotal = 0;
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT quantite FROM panier WHERE id_commande = ?");
			sql.setInt(1, VarStatic.idCommandeStatic);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				listQuantite.add(rs.getInt("quantite"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < listCommand().size(); i++) {
			prixTotal += listCommand().get(i).getPrix() * listQuantite.get(i);
		}
		
		return String.valueOf(prixTotal);
	}
	
	//afficher la moyenne des nutritripoints
	private String moyenneNutripoint() {
		
		int resultat = 0;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT article.nutripoint, AVG(article.nutripoint) AS moyenneNut "+
					"FROM article, panier WHERE article.id_article = panier.id_article AND panier.id_commande = ?");
			
			sql.setInt(1, VarStatic.idCommandeStatic);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				resultat = rs.getInt("moyenneNut");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(resultat);
	}
	
	//modifier le panelClientCommande quand on appuye sur le bouton "voir commande"
	public void modifPanel(PanelClientCommande panelExpedition) {
		if(VarStatic.idCommandeStatic != 0) {
			panelExpedition.setLabelAfficheMoyenNutripoint(moyenneNutripoint());
			panelExpedition.setLabelAfficheNbArticleTotal(afficheNbArticleTotal());
			panelExpedition.setLabelAffichePrixTotal(afficherMontantTotal());
		}
	}

}

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Article;
import model.PanelModelArticle;
import model.VarStatic;
import vue.PanelClientArticleSelect;

public class ControllerClientArticle {

	Connection connect = GetConnection.getConnectionWindows();
	//Connection connect = GetConnection.getConnectionMac();
	
	//actualisation du panelClientArticle par rapport a la valeur de l'idArticle
	public void modifPanArticle(PanelClientArticleSelect panelArticle) {
		ArticleDao artDao = new ArticleDao();
		
		/*
		 * quand le programmme ce lance, idArticleStatic est null, se qui oblige le programme a integer la valeur null dans les labels
		 * pour remedier a ca, quand la selection de la l'article ce fait, on actualise a ce moment la le contenu du panel
		 */
		if(VarStatic.IdArticleStatic != 0) {
			artDao.readIdArticle(VarStatic.IdArticleStatic);
			
			panelArticle.setLabelNom(artDao.readIdArticle(VarStatic.IdArticleStatic).getNomArticle());
			panelArticle.setLabelNomCategorie(artDao.idCategorieToString(artDao.readIdArticle(VarStatic.IdArticleStatic).getIdCategorie()));
			panelArticle.setLabelNutripoint(String.valueOf(artDao.readIdArticle(VarStatic.IdArticleStatic).getNutripoint()) + " /100");
			panelArticle.setLabelPrix(Double.toString(artDao.readIdArticle(VarStatic.IdArticleStatic).getPrix()) +" €");
			
		}
	}
	
	//creation d'une commande, avec fonction ajout au panier
	public void creerCommandeAndAddPanier(int quantiteArticl) {
		
		//on verifie que la commande n'est pas deja creer
		if(VarStatic.idCommandeStatic == 0) {
			System.out.println(VarStatic.idCommandeStatic + " : valeur idCommande controllerClientArticle ligne 44");
			int user = VarStatic.currentUserStatic.getIdUser();
			try {
				//on creer la commande, attention la commande dans un premier temps n'est pas lier a l'utilisateur, car l'id_commande n'est associer a aucun client dans JAVA
				PreparedStatement req = connect.prepareStatement("INSERT INTO commande (id_commande, prix_total, date_achat, id_user) VALUES (null, null, now(), ?)");
				req.setInt(1, user);
				
				req.executeUpdate();
				
				//cette requete recupere la derniere valeur de l'id_commande creer dans la table commande afin qu'elle puisse etre associer au client
				PreparedStatement sql = connect.prepareStatement("SELECT MAX(id_commande) AS idCommande FROM commande");
				
				ResultSet rs = sql.executeQuery();
				
				while(rs.next()) {
					VarStatic.idCommandeStatic = rs.getInt("idCommande");
				}
				//maintenant que l'id_commmande existe dans JAVA elle va permettre de creer des commandes associer avec l'utilisateur actuellement connecte
				ajouterDetail(VarStatic.idCommandeStatic, VarStatic.IdArticleStatic, quantiteArticl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//si id_commande existe deha dans java on ajoute l'article au panier
			ajouterDetail(VarStatic.idCommandeStatic, VarStatic.IdArticleStatic, quantiteArticl);
		}
	}
	
	//ajouter des elements au panier
	private void ajouterDetail(int idCommande, int idArticle, int quantiteArticle) {
		
		//verification de la commande par not null
		if(VarStatic.idCommandeStatic != 0) {
			
			try {
				//on verifie que la commande n'existe pas dans le panier
				PreparedStatement sql = connect.prepareStatement("SELECT COUNT(*) AS count FROM panier WHERE id_commande = ? AND id_article = ?");
				sql.setInt(1, idCommande);
				sql.setInt(2, idArticle);
				
				ResultSet rs = sql.executeQuery();
				if(rs.next()) {
					//si la commande existe pas dans le panier on la cree et on la rajoute
					//panier id_commande / id_article / quantite
					PreparedStatement req = connect.prepareStatement("INSERT INTO panier (id_commande, id_article, quantite) VALUE (?, ?, ?)");
					req.setInt(1, idCommande);
					req.setInt(2, idArticle);
					req.setInt(3, quantiteArticle);
					
					req.executeUpdate();
					JOptionPane.showMessageDialog(null, "Article Ajoute avec succes");
					
				}else {
					// si la commande existe dans le panier, on change la derniere valeur que le client a rentré
					PreparedStatement req = connect.prepareStatement("UPDATE panier SET quantite = ? WHERE panier.id_commande = ? AND panier.id_article = ?");
					req.setInt(1, quantiteArticle);
					req.setInt(2, idCommande);
					req.setInt(3, idArticle);
					
					req.executeUpdate();
					JOptionPane.showMessageDialog(null, "Cette article est deja dans votre panier, nous remplacons la quantite par : "+ quantiteArticle);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

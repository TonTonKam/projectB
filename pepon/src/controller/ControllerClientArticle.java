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
	
	public void modifPanArticle(PanelClientArticleSelect panelArticle) {
		ArticleDao artDao = new ArticleDao();
		
		if(VarStatic.IdArticleStatic != 0) {
			artDao.readIdArticle(VarStatic.IdArticleStatic);
			
			panelArticle.setLabelNom(artDao.readIdArticle(VarStatic.IdArticleStatic).getNomArticle());
			panelArticle.setLabelNomCategorie(artDao.idCategorieToString(artDao.readIdArticle(VarStatic.IdArticleStatic).getIdCategorie()));
			panelArticle.setLabelNutripoint(String.valueOf(artDao.readIdArticle(VarStatic.IdArticleStatic).getNutripoint()) + " /100");
			panelArticle.setLabelPrix(Double.toString(artDao.readIdArticle(VarStatic.IdArticleStatic).getPrix()) +" €");
			
		}
	}
	
	//creer une commande
	public void creerCommandeAndAddPanier(int quantiteArticl) {

		if(VarStatic.idCommandeStatic == 0) {
			int user = VarStatic.currentUserStatic.getIdUser();
			try {
				PreparedStatement req = connect.prepareStatement("INSERT INTO commande (id_commande, prix_total, date_achat, id_user) VALUES (null, null, now(), ?)");
				req.setInt(1, user);
				
				req.executeUpdate();
				
				//cette requete recupere la derniere valeur de l'id cree
				PreparedStatement sql = connect.prepareStatement("SELECT MAX(id_commande) AS idCommande FROM commande");
				
				ResultSet rs = sql.executeQuery();
				
				while(rs.next()) {
					VarStatic.idCommandeStatic = rs.getInt("idCommande");
				}
				ajouterDetail(VarStatic.idCommandeStatic, VarStatic.IdArticleStatic, quantiteArticl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			ajouterDetail(VarStatic.idCommandeStatic, VarStatic.IdArticleStatic, quantiteArticl);
		}
	}
	
	//ajouter des elements au panier
	private void ajouterDetail(int idCommande, int idArticle, int quantiteArticle) {
		
		/*
		 * faire un control sur la duplication de cle
		 */
		
		if(VarStatic.idCommandeStatic != 0) {
			//panier id_commande / id_article / quantite
			try {
				PreparedStatement req = connect.prepareStatement("INSERT INTO panier (id_commande, id_article, quantite) VALUE (?, ?, ?)");
				req.setInt(1, idCommande);
				req.setInt(2, idArticle);
				req.setInt(3, quantiteArticle);
				
				req.executeUpdate();
				JOptionPane.showMessageDialog(null, "Article Ajouter avec succee");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

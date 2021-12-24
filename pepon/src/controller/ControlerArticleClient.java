package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Article;
import model.PanelModelArticle;
import model.VarStatic;
import vue.PanelArticleSelectClient;

public class ControlerArticleClient {
	//Connection connect = GetConnection.getConnectionWindows();
	Connection connect = GetConnection.getConnectionMac();
	public void modifPanArticle(PanelArticleSelectClient panelArticle) {
		ArticleDao artDao = new ArticleDao();
		
		if(VarStatic.IdArticleStatic != 0) {
			artDao.readIdArticle(VarStatic.IdArticleStatic);
			
			panelArticle.setLabelNom(artDao.readIdArticle(VarStatic.IdArticleStatic).getNomArticle());
			panelArticle.setLabelNomCategorie(artDao.idCategorieToString(artDao.readIdArticle(VarStatic.IdArticleStatic).getIdCategorie()));
			panelArticle.setLabelNutripoint(String.valueOf(artDao.readIdArticle(VarStatic.IdArticleStatic).getNutripoint()) + " /100");
			panelArticle.setLabelPrix(Double.toString(artDao.readIdArticle(VarStatic.IdArticleStatic).getPrix()) +" �");
			
		}
		
	}
	
	public int creerCommande() {
		
		//int user = UserDao.currentUser.getIdUser();
		if(VarStatic.idCommandeStatic == 0) {
			VarStatic.idCommandeStatic = 0;
			int user = 5;
			try {
				PreparedStatement req = connect.prepareStatement("INSERT INTO commande (id_commande, prix_total, date_achat, id_user) VALUES (null, null, now(), ?)");
				req.setInt(1, user);
				
				req.executeUpdate();
				
				//cree un count
				PreparedStatement sql = connect.prepareStatement("SELECT LAST_INSERT_ID() FROM commande WHERE id_user = ?");
				sql.setInt(1, user);
				
				ResultSet rs = sql.executeQuery();
				
				while(rs.next()) {
					VarStatic.idCommandeStatic++;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return VarStatic.idCommandeStatic;
	}
	
	public void ajouterDetail(int idCommande, int idArticle, int quantiteArticle) {
		
		//panier id_commande / id_article / quantite
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO panier (id_commande, id_article, quantite) VALUE (?, ?, ?)");
			req.setInt(1, idCommande);
			req.setInt(2, idArticle);
			req.setInt(3, quantiteArticle);
			
			req.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ajouterPanier(String nomArticle, double prix, int qteArticle) {
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO Panie (designation, prix, quantite) VALUE (?, ?, ?)");
			req.setString(1, nomArticle);
			req.setDouble(2, prix);
			req.setInt(3, qteArticle);
			
			
			req.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


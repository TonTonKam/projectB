package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.PanelModelArticle;
import model.VarStatic;
import vue.PanelMenuPanier;

public class ControllerMenuPanier {

	private PanelMenuPanier panelMenu;
	
	public void affichePanierClient() {
		//int idUser = UserDao.currentUser.getIdClient;
		int idUser = VarStatic.currentUserStatic;
		int idArticle = VarStatic.IdArticleModelStatic;
		
		Connection connect = GetConnection.getConnectionWindows();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT id_article, quantite FROM panier WHERE id_commande");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

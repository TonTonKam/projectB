package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import model.PanelModelArticle;
import model.VarStatic;
import vue.PanelMenuPanier;

public class ControllerMenuPanier {
	
	public void affichePanierClient(PanelMenuPanier panelExpedition) {
		int idUser = VarStatic.currentUserStatic.getIdUser();
		//int idUser = VarStatic.currentUserStatic;
		int idArticle = VarStatic.IdArticleStatic;
		int idCommand = VarStatic.idCommandeStatic;
		
		String text = "Vos articles : ";
		//Connection connect = GetConnection.getConnectionWindows();
		Connection connect = GetConnection.getConnectionMac();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT id_article, quantite FROM panier WHERE id_commande = ?");
			sql.setInt(1, idCommand);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				text = rs.getInt("id_article") + " " + rs.getInt("quantite") +"\n";
				System.out.println(text);
			}
			panelExpedition.setAreaPanier(text);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

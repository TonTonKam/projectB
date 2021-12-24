package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import model.PanelModelArticle;
import model.VarStatic;
import vue.PanelClientPanierMenu;

public class ControllerClientMenuPanier {
	
	Connection connect = GetConnection.getConnectionWindows();
	//Connection connect = GetConnection.getConnectionMac();
	
	//BUG cette fonction n'est appeler qu'au moment de la creation du panelPanierMenu
	//on affiche le panier du client pour chaque
	public void affichePanierClient(PanelClientPanierMenu panelExpedition) {

		int idCommand = VarStatic.idCommandeStatic;
		
		String text = "Vos articles : ";
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT id_article, quantite FROM panier WHERE id_commande = ?");
			sql.setInt(1, idCommand);
			
			ResultSet rs = sql.executeQuery();
			
			//on affiche le texte qui va etre mis dans le JTextArea
			while(rs.next()) {
				text += "- Id article : "+ rs.getInt("id_article") + ", quantite du produit : " + rs.getInt("quantite") +"\n";
			}
			panelExpedition.setAreaPanier(text);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

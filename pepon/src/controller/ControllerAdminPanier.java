package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ControllerAdminPanier {
	//Appel de la connection
		//Connection connect = GetConnection.getConnectionMac();
		Connection connect = GetConnection.getConnectionWindows();
		//AFFICHER id_commande, d_user, id_article et date_achat et quantite et prix_total quand id_commande et commun entre commande et panier
		public void afficherTableCommandePanier(JTable table) {
			
			try {
				//recuperation des info de  table article
				PreparedStatement sql = connect.prepareStatement("SELECT * FROM commande, panier WHERE panier.id_commande = commande.id_commande;");
				
				ResultSet rs =sql.executeQuery();

				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

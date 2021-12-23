package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ControllerAdminPanier {
	//Appel de la connection
		//Connection connect = GetConnection.getConnectionMac();
		Connection connect = GetConnection.getConnectionWindows();
		//AFFICHER id_commande, d_user, id_article et date_achat et quantite et prix_total quand id_commande et commun entre commande et panier
		public void afficherTableCommandePanier(JTable table) {
			
			try {
				//recuperation des info de  table article
				PreparedStatement sql = connect.prepareStatement("SELECT commande.* , panier.id_article, quantite, user.nom  FROM commande,"
						+ " panier, user WHERE panier.id_commande = commande.id_commande and user.id_user = commande.id_user;");
				
				ResultSet rs =sql.executeQuery();

				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Methode pour selectionner une ligne dans le tableau
		
		public void seletRow( JTextField textIdCommande, JTextField textIdArticle, JTextField textQuantite,JTable table) {
			int i = table.getSelectedRow();
			DefaultTableModel model =(DefaultTableModel) (table.getModel());
			textIdCommande.setText(model.getValueAt(i, 0).toString());
			textIdArticle.setText( model.getValueAt(i, 4).toString());
			textQuantite.setText( model.getValueAt(i, 5).toString());
		}
		
		// Methode pour modifier la quantite d'article
		
		public void modifier(int idArticle, int  quantite, String idCommande, String idArticle1) {
			try {
				
				PreparedStatement sql = connect.prepareStatement("UPDATE panier set id_article = ?,quantite = ?  WHERE id_commande =? AND id_article =?");
				sql.setInt(1, idArticle);
				sql.setInt(2, quantite);
				sql.setString(3, idCommande);
				sql.setString(4, idArticle1);
				
				sql.executeUpdate();
				JOptionPane.showMessageDialog(null, "la commande n: " + " "+ idCommande +" a bien ete modifiee." );
			} catch (SQLException event) {
				// TODO Auto-generated catch block
				event.printStackTrace();
			}
		}
		
		
		
}

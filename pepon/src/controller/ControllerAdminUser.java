package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.User;
import net.proteanit.sql.DbUtils;

public class ControllerAdminUser {
	
			//Appel de la connection
			//Connection connect = GetConnection.getConnectionMac();
			Connection connect = GetConnection.getConnectionWindows();
			
			//public static User currentUser ;
			
			public void switchPanels(JPanel panel,JLayeredPane layeredPane) {
				layeredPane.removeAll();
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			
			public boolean mailExist(String mail) {
				Boolean msg = false;
				try {
					PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email = ?");
					
					sql.setString(1, mail);
					
					ResultSet rs = sql.executeQuery();
					
					if(!rs.next()) {
						msg = true;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return msg;
			}
			
			//M�thode pour ajouter un utilisateur 
			public void ajouter(User user) {
				
				try {
					PreparedStatement sql = connect.prepareStatement("INSERT INTO user (nom, prenom, email, mot_passe, id_statut)"
							+ " VALUES (?,?,?,PASSWORD(?),?)	");
					sql.setString(1, user.getNom());
					sql.setString(2, user.getPrenom());
					sql.setString(3, user.getEmail());
					sql.setString(4, user.getMotPasse());
					sql.setInt(5, user.getIdStatut());
					
					sql.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Activer le bouton Ajouter quant'il tous les champs sont saisis pour plus de s�curit�
			
			public void activerBtnAjouter( JTextField nom, JTextField prenom, JTextField email, JTextField password,JTextField statut ,JButton btn) {
				String nom_saisie = nom.getText();
				String prenom_saisie = prenom.getText();
				String email_saisie = email.getText();
				String pass_saisie = password.getText();
				String statut_saisie = statut.getText();
				
				if((!nom_saisie.isEmpty()) && (!prenom_saisie.isEmpty()) && (!email_saisie.isEmpty())&& (!pass_saisie.isEmpty())&& (!statut_saisie.isEmpty())) {
					btn.setEnabled(true);
				}else {
					btn.setEnabled(false);
				}
			}
			
			//M�thode  pour vider les champs
			public void viderChamps(JTextField a,JTextField b,JTextField c,JTextField d,JTextField status,JTextField f) {
				a.setText("");
				b.setText("");
				c.setText("");
				d.setText("");
				status.setText("");
				//status.setToolTipText("");
				f.requestFocus();		
			}
			
			public void afficherTable(JTable table) {
				
				try {
					//r�cup�ration des info de  table user
					PreparedStatement sql = connect.prepareStatement("SELECT * FROM user");
					// Conversion de la requete en tableau d'objets
					ResultSet rs =sql.executeQuery();
					/*
					 * J'appelle la m�thode setModel pour inserer les objets dans notre table
					 * table = objet Jtable 
					 * j'appelle setModel de l'objet Jtable.
					 * setModel a comme parametre :
					 * DbUtils = la libraire ?
					 * la m�thode resultSetToTableModel modifie la table Model.
					 * cette m�thode prend comme param notre tableau d'objet rs.
					 * 
					 * ca Modifie la variable table de type Jtable avec les instructions resultSetToTableModel
					 *  qui contient le rs
					 */
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			//M�thode pour chercher un utilisateur par id
			public void findById(String id, JTextField nom, JTextField prenom, JTextField email, JTextField status) {
				try { 
					PreparedStatement sql = connect.prepareStatement("SELECT  nom, prenom, email, id_statut  FROM user WHERE id_user = ?");
					
					sql.setNString(1, id);
					
					ResultSet rs = sql.executeQuery();
					
					if(rs.next()) {
						//String id = rs.getString(1);
						String name = rs.getString(1);
						String lastname = rs.getString(2);
						String mail = rs.getString(3);
						int statut = rs.getInt(4);
						
					
						nom.setText(name);
						prenom.setText(lastname);
						email.setText(mail);
						//status.setToolTipText(statut);
						status.setText(String.valueOf(statut));
					}else {
						nom.setText("");
						prenom.setText("");
						email.setText("");
					}
					
				} catch (SQLException event) {
					// TODO Auto-generated catch block
					event.printStackTrace();
				}
			}
			
			//M�thode pour modifier un utilisateur 
			
				public void modifier( String nom, String prenom, String email, int statu, String id) {
					try {
						PreparedStatement sql = connect.prepareStatement("UPDATE user set nom= ?,prenom = ?,email= ?,id_statut = ?" 
								+ " where id_user =?");
						sql.setString(1, nom);
						sql.setString(2, prenom);
						sql.setString(3, email);
						sql.setInt(4, statu);
						sql.setString(5,id);
						
						sql.executeUpdate();
						JOptionPane.showMessageDialog(null, nom + " "+prenom +" a ete bien modifie(e)." );
					} catch (SQLException event) {
						// TODO Auto-generated catch block
						event.printStackTrace();
					}
					
				}
				
				//M�thode pour supprimer un utilisateur 

				public void supprimer(String id) {
					try {
						PreparedStatement sql = connect.prepareStatement("delete from user where id_user =?");
						
						sql.setString(1,id);
						
						sql.executeUpdate();
						JOptionPane.showMessageDialog(null,"l'utilisateur qui a l'id n: "+ id +" a ete bien supprime." );
					} catch (SQLException event) {
						// TODO Auto-generated catch block
						event.printStackTrace();
					}
					
				}
				
				public void state(int a) {
					if(a == 1) {
						System.out.println("Client");
					}else {
						System.out.println("Admin");
					}
				}
				
				
}

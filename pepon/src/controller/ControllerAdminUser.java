package controller;
import java.awt.Component;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

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
			
			//Methode pour ajouter un utilisateur 
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
			
			//Activer le bouton Ajouter quant'il tous les champs sont saisis pour plus de securite
			
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
			
			//Methode  pour vider les champs
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
					//recuperation des info de  table user
					PreparedStatement sql = connect.prepareStatement("SELECT user.*,statut.libelle FROM statut, user where user.id_statut = statut.id_statut");
					// Conversion de la requete en tableau d'objets
					ResultSet rs =sql.executeQuery();
					/*
					 * J'appelle la methode setModel pour inserer les objets dans notre table
					 * table = objet Jtable 
					 * j'appelle setModel de l'objet Jtable.
					 * setModel a comme parametre :
					 * DbUtils = la libraire ?
					 * la methode resultSetToTableModel modifie la table Model.
					 * cette methode prend comme param notre tableau d'objet rs.
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
			
			public void nbrClient(JTable table) {
				
				try {
					
					PreparedStatement sql = connect.prepareStatement("SELECT count(id_user) as NombreClient from user where user.id_statut = 1");
					// Conversion de la requete en tableau d'objets
					ResultSet rs =sql.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			//Methode pour chercher un utilisateur par id
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
			
			//Methode pour modifier un utilisateur 
			
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
				//Ferifier pendant la modif de l'utilisateur
				public void verifModifier(JTextField a, JTextField b, JTextField c,JTextField d,JTextField e, JTable table ) {
					String id, firstname, lastname, mail;
					int stat;
					firstname =a.getText();
					lastname = b.getText();
					mail  = c.getText();
					stat = Integer.parseInt(d.getText());
					id = e.getText();	

					//Appel de la méthode modifier
					if(!firstname.isEmpty()|| !(lastname.isEmpty()) || !(mail.isEmpty()) || !(stat == 0)) {
						modifier(firstname, lastname, mail, stat, id);
						//afficher la table modifiée
						afficherTable(table);
					}
				}
				
				//Methode pour supprimer un utilisateur 

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
				
				//Ferifier pendant la suppression de l'utilisateur
				
				public void verifSupp(JTextField a, JTextField b, JTextField c,JTextField d,JTextField e, JTable table) {
					String idAsupp, firstname, lastname, mail;
					int state;
					firstname =a.getText();
					lastname = b.getText();
					mail  = c.getText();
					state = Integer.parseInt(d.getText());
					idAsupp = e.getText();
					
					if(!firstname.isEmpty()|| !(lastname.isEmpty()) || !(mail.isEmpty()) || !(state == 0)) {
						supprimer(idAsupp);
						afficherTable(table);
						viderChamps(a, b, c, d, e, a);
					}	 
				}
				
				public void state(int a) {
					if(a == 1) {
						System.out.println("Client");
					}else {
						System.out.println("Admin");
					}
				}
				
				//Activer le bouton ajouter
				
				public void ActivBtn(JTextField a, JTextField b, JTextField c,JTextField d,JTextField f, JButton btn) {
					
					a.addCaretListener(new CaretListener(){
						@Override
						public void caretUpdate(CaretEvent e) {
							activerBtnAjouter(a, b, c, d, f, btn);	
						}
					});
					b.addCaretListener(new CaretListener(){
						@Override
						public void caretUpdate(CaretEvent event) {
							activerBtnAjouter(a, b, c, d, f, btn);	
						}
					});
					c.addCaretListener(new CaretListener(){
						@Override
						public void caretUpdate(CaretEvent e) {
							activerBtnAjouter(a, b, c, d, f, btn);	
						}
					});	
					d.addCaretListener(new CaretListener(){
						@Override
						public void caretUpdate(CaretEvent e) {
							activerBtnAjouter(a, b, c, d, f, btn);	
						}
					});	
					f.addCaretListener(new CaretListener(){
						@Override
						public void caretUpdate(CaretEvent e) {
							activerBtnAjouter(a, b, c, d, f, btn);	
						}
					});	
				}
				
				// METHODE AJOUTER
				
				public void ajoutBtn(JTextField a, JTextField b, JTextField c,JTextField d,JTextField e, JTable table) {
					String nom_saisie = a.getText();
					String prenom_saisie = b.getText();
					String email_saisie = c.getText();
					String pass_saisie = d.getText();
					int statut_saisie = Integer.parseInt(e.getText());
					String msg;
					if (statut_saisie == 1) {
						msg = "client";
					}else {
						msg = "Admin";
					}
					
					User nouvelUser = new User(nom_saisie, prenom_saisie, email_saisie, pass_saisie,statut_saisie);
					
						ControllerAdminUser vider = new ControllerAdminUser();
						
						if(nom_saisie.isEmpty() || prenom_saisie.isEmpty() || email_saisie.isEmpty() || pass_saisie.isEmpty() || statut_saisie == 0) {
							JOptionPane.showMessageDialog(null, "Remplissez tous les champs svp!","Error",JOptionPane.ERROR_MESSAGE);
						}else if(!email_saisie.isEmpty() && !(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", email_saisie))){
							JOptionPane.showMessageDialog(null, "Mail pas valide","Error",JOptionPane.ERROR_MESSAGE);
						}else {					
							
							if(mailExist(email_saisie)) {
								ajouter(nouvelUser);
								
								JOptionPane.showMessageDialog(null, "vous etes bien inscrit(e) tant que "+ " "+ msg);
								
							}else {
								JOptionPane.showMessageDialog(null, "Ce mail existe deja !","Error",JOptionPane.ERROR_MESSAGE);		
							}	
						}
					
						afficherTable(table);
						vider.viderChamps(a, b, c, d,e,a);
				}
				
				
}

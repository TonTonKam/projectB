package vue;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;


import controller.ControllerUserAdmin;
import model.ColorPanel;
import model.User;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class PanelAdminUser extends JPanel {

	//attributs
	private JTextField textIdUser;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textEmail;
	private JTextField textPassword;
	private JTable table;
	private JTextField textStatut;
	
	//Instanciation d'un objet user 
	ControllerUserAdmin us = new ControllerUserAdmin();
	
	
	//constructor
	public PanelAdminUser() {
		
		setBounds(10, 0, 964, 550);
		setBackground(Color.BLACK);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(30, 90, 900, 450);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Utilistaeur = new JPanel();
		layeredPane.add(Utilistaeur, "name_165769075441000");
		Utilistaeur.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des utilisateurs");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(281, 5, 211, 59);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		Utilistaeur.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(25, 65, 98, 33);
		Utilistaeur.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(25, 109, 98, 33);
		Utilistaeur.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(25, 153, 98, 33);
		Utilistaeur.add(lblNewLabel_1_2);
		
		JLabel Password = new JLabel("Mot de passe");
		Password.setFont(new Font("Tahoma", Font.BOLD, 14));
		Password.setBounds(25, 201, 98, 33);
		Utilistaeur.add(Password);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Statut");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(25, 255, 98, 33);
		Utilistaeur.add(lblNewLabel_1_3_1);
		
		textNom = new JTextField();
		textNom.setBounds(133, 65, 213, 28);
		Utilistaeur.add(textNom);
		textNom.setColumns(10);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(133, 113, 213, 28);
		Utilistaeur.add(textPrenom);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(133, 157, 213, 28);
		Utilistaeur.add(textEmail);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(133, 201, 213, 28);
		Utilistaeur.add(textPassword);
		
		textStatut = new JTextField();
		textStatut.setColumns(10);
		textStatut.setBounds(133, 249, 98, 28);
		Utilistaeur.add(textStatut);
		
		//*********************Ajouter un utilisateur ********************************
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setEnabled(false);
		
		textNom.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(textNom, textPrenom, textEmail, textPassword, textStatut, btnAjouter);

			}
		});	
		textPrenom.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(textNom, textPrenom, textEmail, textPassword, textStatut, btnAjouter);

			}
		});
		textEmail.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(textNom, textPrenom, textEmail, textPassword, textStatut, btnAjouter);

			}
		});
		textPassword.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(textNom, textPrenom, textEmail, textPassword, textStatut, btnAjouter);

			}
		});
		textStatut.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(textNom, textPrenom, textEmail, textPassword, textStatut, btnAjouter);

			}
		});
		
		
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String nom_saisie = textNom.getText();
				String prenom_saisie = textPrenom.getText();
				String email_saisie = textEmail.getText();
				String pass_saisie = textPassword.getText();
				int statut_saisie = Integer.parseInt(textStatut.getText());
				String msg;
				if (statut_saisie == 1) {
					msg = "client";
				}else {
					msg = "Admin";
				}
				
				User nouvelUser = new User(nom_saisie, prenom_saisie, email_saisie, pass_saisie,statut_saisie);
				
					ControllerUserAdmin vider = new ControllerUserAdmin();
					
					if(nom_saisie.isEmpty() || prenom_saisie.isEmpty() || email_saisie.isEmpty() || pass_saisie.isEmpty() || statut_saisie == 0) {
						JOptionPane.showMessageDialog(null, "Remplissez tous les champs svp!","Error",JOptionPane.ERROR_MESSAGE);
					}else if(!email_saisie.isEmpty() && !(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", email_saisie))){
						JOptionPane.showMessageDialog(null, "Mail pas valide","Error",JOptionPane.ERROR_MESSAGE);
					}else {					
						
						if(us.mailExist(email_saisie)) {
							us.ajouter(nouvelUser);
							
							JOptionPane.showMessageDialog(null, "vous etes bien inscrit(e) tant que "+ " "+ msg);
							
						}else {
							JOptionPane.showMessageDialog(null, "Ce mail existe deja !","Error",JOptionPane.ERROR_MESSAGE);		
						}	
					}
				
					us.afficherTable(table);
					vider.viderChamps(textNom, textPrenom, textEmail, textPassword,textStatut,textNom);
			}
		});
		
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBounds(25, 299, 87, 33);
		Utilistaeur.add(btnAjouter);
	
		//*********************Modifier un utilisateur par id*************************************
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id, firstname, lastname, mail;
				//Object stat;
				int stat;
				firstname =textNom.getText();
				lastname = textPrenom.getText();
				mail  = textEmail.getText();
				stat = Integer.parseInt(textStatut.getText());
				id = textIdUser.getText();	

				//Appel de la méthode modifier
				if(!firstname.isEmpty()|| lastname.isEmpty() || mail.isEmpty() || stat == 0) {
					us.modifier(firstname, lastname, mail, stat, id);
					
					//afficher la table modifiée
					us.afficherTable(table);
				}

				//Appel de la methode
				us.modifier(firstname, lastname, mail, stat, id);
				//afficher la table modifiï¿½e
				us.afficherTable(table);

			}
		});
		
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBounds(133, 299, 87, 33);
		Utilistaeur.add(btnModifier);
		
		//********************************Supprimer un utilisateur******************************
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, firstname, lastname, mail;
				int state;
				firstname =textNom.getText();
				lastname = textPrenom.getText();
				mail  = textEmail.getText();
				state = Integer.parseInt(textStatut.getText());
				String idTextUser = textIdUser.getText();
				
				if(!firstname.isEmpty()|| lastname.isEmpty() || mail.isEmpty() || state == 0) {
					us.supprimer(idTextUser);
					us.afficherTable(table);
				}
					
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBounds(248, 299, 98, 33);
		Utilistaeur.add(btnSupprimer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 63, 532, 268);
		Utilistaeur.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBorder(new TitledBorder(null, "Chercher", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 348, 322, 91);
		Utilistaeur.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID Utilisateur");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 38, 90, 24);
		panel.add(lblNewLabel_2);
		
		//*********************Chercher un utilisateur par id*****************************************
		
		textIdUser = new JTextField();
		textIdUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String id = textIdUser.getText();				
				us.findById(id,textNom,textPrenom,textEmail,textStatut);
			}
		});
		textIdUser.setBounds(110, 41, 190, 20);
		panel.add(textIdUser);
		textIdUser.setColumns(10);
		
		//*****************Effacer les champs apres recherche par id***********************************
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				us.viderChamps(textNom, textPrenom, textEmail, textPassword,textStatut,textNom);
				textIdUser.setText("");
			}
		});
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEffacer.setBounds(422, 364, 166, 59);
		Utilistaeur.add(btnEffacer);
		//********************Quitter l'appli***********************************************************
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuitter.setBounds(666, 364, 166, 59);
		Utilistaeur.add(btnQuitter);
		
		//***************************Ajouter les panels dans le panel mere***************************
		PanelAdminCategorie categorie = new PanelAdminCategorie();
		layeredPane.add(categorie, "name_165783077019800");
		categorie.setLayout(null);
		
		PanelAdminCommande commande = new PanelAdminCommande();
		layeredPane.add(commande, "name_165783077019800");
		commande.setLayout(null);
		
		PanelAdminArticle articles = new PanelAdminArticle();
		layeredPane.add(articles, "name_165783077019800");
		articles.setLayout(null);
		
		//Appliquer la méthode switch sur les boutons de notre panels mere
		
		JButton btnUtilisateur = new JButton("Utilistaeurs");
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControllerUserAdmin toto = new ControllerUserAdmin();
				toto.switchPanels(Utilistaeur,layeredPane);
			}
		});
		
		btnUtilisateur.setBounds(65, 23, 134, 44);
		
		setLayout(null);
	
		btnUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(btnUtilisateur);
	

		JButton btnArticle = new JButton("Articles");
		btnArticle.setBounds(301, 23, 134, 44);
		btnArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUserAdmin toto = new ControllerUserAdmin();
				toto.switchPanels(articles,layeredPane);
			}
		});
		
		btnArticle.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(btnArticle);
		
		JButton btnCommandes = new JButton("Commandes");
		btnCommandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUserAdmin toto = new ControllerUserAdmin();
				toto.switchPanels(commande,layeredPane);
			}
		});
		
		btnCommandes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCommandes.setBounds(537, 23, 134, 44);
		add(btnCommandes);
		
		JButton btnCatgories = new JButton("Cat\u00E9gories");
		btnCatgories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUserAdmin toto = new ControllerUserAdmin();
				toto.switchPanels(categorie,layeredPane);
			}
		});
		
		btnCatgories.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCatgories.setBounds(766, 23, 134, 44);
		add(btnCatgories);
		
		//Afficher la table des utilisateurs des qu'on lance l'appli
		us.afficherTable(table);

	}
}

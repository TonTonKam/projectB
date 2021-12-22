package vue;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.*;
import javax.swing.JLayeredPane;

import controller.ControllerUserAdmin;
import model.User;

public class PanelAdminUser extends JPanel {

	//attributs
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JTextField password;
	private JTextField textIdUser;
	private JTable table;
	private JPanel panelUser;
	
	//Instanciation d'un objet user
	ControllerUserAdmin us = new ControllerUserAdmin();
	
	//constructor
	public PanelAdminUser() {
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 64, 964, 486);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		// panelAdminUser
		panelUser = new JPanel();
		panelUser.setForeground(Color.BLACK);
		panelUser.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(panelUser, "name_727897292437400");
		panelUser.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion d'utilisateurs");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(383, 5, 187, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelUser.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(40, 47, 71, 22);
		panelUser.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(40, 91, 71, 22);
		panelUser.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(40, 140, 71, 22);
		panelUser.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mot passe");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(40, 185, 71, 22);
		panelUser.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Statut");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3_1.setBounds(40, 229, 71, 22);
		panelUser.add(lblNewLabel_1_3_1);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(154, 49, 212, 20);
		panelUser.add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(154, 93, 212, 20);
		panelUser.add(prenom);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(154, 142, 212, 20);
		panelUser.add(email);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(154, 187, 212, 20);
		panelUser.add(password);
		
		JTextField status = new JTextField();
		status.setColumns(10);
		status.setBounds(154, 230, 212, 22);
		panelUser.add(status);
		
		/*
		JComboBox status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] {"client", "admin"}));
		status.setBounds(154, 230, 212, 22);
		user.add(status);
		*/
		//*****************************************Ajouter un utilisateur********************************************//
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setEnabled(false);
		
		nom.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(nom, prenom, email, password, btnAjouter);
				
			}
		});	
		prenom.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(nom, prenom, email,password, btnAjouter);
				
			}
		});
		email.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(nom, prenom, email,password, btnAjouter);
				
			}
		});
		password.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				us.activerBtnAjouter(nom, prenom, email,password, btnAjouter);
				
			}
		});
		
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomSaisie = nom.getText();
				String prenomSaisie = prenom.getText();
				String emailSaisie = email.getText();
				String pwdSaisie = password.getText();
				int statutSaisie = Integer.parseInt(status.getText());
				//Object statutSaisie = status.getSelectedItem();
				User nouvel = new User(nomSaisie, prenomSaisie, emailSaisie, pwdSaisie,statutSaisie);
				ControllerUserAdmin vider = new ControllerUserAdmin();
				
				if(nomSaisie.isEmpty() || prenomSaisie.isEmpty() || emailSaisie.isEmpty() || pwdSaisie.isEmpty() ||(statutSaisie) == 0) {
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs svp!","Error",JOptionPane.ERROR_MESSAGE);
				
				}else if(!emailSaisie.isEmpty() && !(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", emailSaisie))){
					JOptionPane.showMessageDialog(null, "Mail pas valide","Error",JOptionPane.ERROR_MESSAGE);
				}else {					
					
					if(us.mailExist(emailSaisie)) {
						us.ajouter(nouvel);
						JOptionPane.showMessageDialog(null, "vous etes bien inscrit(e) tant que "+ " "+ statutSaisie );
					}else {
						JOptionPane.showMessageDialog(null, "Ce mail existe deja !","Error",JOptionPane.ERROR_MESSAGE);		
					}	
				}
				
				us.afficherTable(table);
				
				vider.viderChamps(nom, prenom, email, password, status, nom);
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBounds(30, 310, 98, 40);
		panelUser.add(btnAjouter);
		
		//*********************Modifier un utilisateur par id*******************************************************
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String id, firstname, lastname, mail;
				//Object stat;
				int stat;
				firstname =nom.getText();
				lastname = prenom.getText();
				mail  = email.getText();
				//stat = status.getSelectedItem();
				stat = Integer.parseInt(status.getText());
				id = textIdUser.getText();	
				//Appel de la m�thode
				us.modifier(firstname, lastname, mail, stat, id);
				//afficher la table modifi�e
				us.afficherTable(table);
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBounds(144, 310, 105, 40);
		panelUser.add(btnModifier);
		
		//*********************Supprimer un utilisateur**********************************************************
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textIdUser.getText();
				us.supprimer(id);
				us.afficherTable(table);	
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBounds(268, 310, 98, 40);
		panelUser.add(btnSupprimer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Chercher", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(30, 390, 351, 85);
		panelUser.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID utilisateur");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 29, 116, 20);
		panel_1.add(lblNewLabel_2);
		
		//*********************Chercher un utilisateur par id*******************************************************
		
		textIdUser = new JTextField();
		textIdUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String id = textIdUser.getText();				
				us.findById(id,nom,prenom,email,status);
			}
		});
		textIdUser.setColumns(10);
		textIdUser.setBounds(136, 30, 171, 20);
		panel_1.add(textIdUser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 47, 574, 319);
		panelUser.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//Afficher la table des utilisateurs
				us.afficherTable(table);
				
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				us.viderChamps(nom, prenom, email, password, status, nom);
				textIdUser.setText("");
			}
		});
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEffacer.setBounds(480, 406, 178, 55);
		panelUser.add(btnEffacer);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuitter.setBounds(710, 409, 178, 52);
		panelUser.add(btnQuitter);
	}

}

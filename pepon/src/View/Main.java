package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.ControllerPanelMenuAdmin;
import Controller.ControllerUserAdmin;
import Controller.GetConnection;
import Model.User;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Main extends JFrame {
	//Atributs
	
	private JPanel contentPane;
	private final int hauteur = 600;
	private final int longueur = 1000;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel article;
	private JPanel user;
	private JPanel categorie;
	private JPanel commande;
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JTextField password;
	private JTextField text_id_user;
	private JTable table;
	
	
	Connection connect = GetConnection.getConnection();
	
	/**
	 * Create the frame.
	 */
	//Constructeur de la casse Main
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, longueur, hauteur);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 64, 964, 486);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		user = new JPanel();
		user.setForeground(Color.BLACK);
		user.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(user, "name_727897292437400");
		user.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion d'utilisateurs");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(383, 5, 187, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		user.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(40, 47, 71, 22);
		user.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(40, 91, 71, 22);
		user.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(40, 140, 71, 22);
		user.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mot passe");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(40, 185, 71, 22);
		user.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Statut");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3_1.setBounds(40, 229, 71, 22);
		user.add(lblNewLabel_1_3_1);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(154, 49, 212, 20);
		user.add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(154, 93, 212, 20);
		user.add(prenom);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(154, 142, 212, 20);
		user.add(email);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(154, 187, 212, 20);
		user.add(password);
		
		JComboBox status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] {"client", "admin"}));
		status.setBounds(154, 230, 212, 22);
		user.add(status);
		
		//*****************************************Ajouter un utilisateur********************************************
		
		JButton btnAjouter = new JButton("Ajouter");
		//Instanciation d'un objet user 
		ControllerUserAdmin us = new ControllerUserAdmin();
		
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nom_saisie = nom.getText();
				String prenom_saisie = prenom.getText();
				String email_saisie = email.getText();
				String pwd_saisie = password.getText();
				Object statut_saisie = status.getSelectedItem();
				User nouvel = new User(nom_saisie, prenom_saisie, email_saisie, pwd_saisie,statut_saisie);
				if(!(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", email_saisie) )) {
					JOptionPane.showMessageDialog(null, "Mail pas valide","Error",JOptionPane.ERROR_MESSAGE);
				}else {					
					
					if(us.mailExist(email_saisie)) {
						us.ajouter(nouvel);
						JOptionPane.showMessageDialog(null, "vous etes bien inscrit(e) tant que "+ " "+ statut_saisie );
					}else {
						JOptionPane.showMessageDialog(null, "Ce mail existe deja !","Error",JOptionPane.ERROR_MESSAGE);		
					}	
				}
				us.afficherTable(table);
				ControllerUserAdmin vider = new ControllerUserAdmin();
				vider.viderChamps(nom, prenom, email, password, status, nom);
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBounds(30, 310, 98, 40);
		user.add(btnAjouter);
		
		//*********************Modifier un utilisateur par id*******************************************************
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String id, firstname, lastname, mail;
				Object stat;
				firstname =nom.getText();
				lastname = prenom.getText();
				mail  = email.getText();
				stat = status.getSelectedItem();
				id = text_id_user.getText();	
				//Appel de la méthode
				us.modifier(firstname, lastname, mail, (String) stat, id);
				//afficher la table modifiée
				us.afficherTable(table);
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBounds(144, 310, 105, 40);
		user.add(btnModifier);
		
		//*********************Supprimer un utilisateur**********************************************************
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = text_id_user.getText();
				us.supprimer(id);
				us.afficherTable(table);	
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBounds(268, 310, 98, 40);
		user.add(btnSupprimer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Chercher", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(30, 390, 351, 85);
		user.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID utilisateur");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 29, 116, 20);
		panel_1.add(lblNewLabel_2);
		
		//*********************Chercher un utilisateur par id*******************************************************
		
		text_id_user = new JTextField();
		text_id_user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String id = text_id_user.getText();				
				//ControllerUserAdmin findId = new ControllerUserAdmin();
				us.findById(id,nom,prenom,email,status);
			}
		});
		text_id_user.setColumns(10);
		text_id_user.setBounds(136, 30, 171, 20);
		panel_1.add(text_id_user);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 47, 574, 319);
		user.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		article = new JPanel();
		article.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(article, "name_727942207939200");
		
		JLabel lblGestionDarticles = new JLabel("Gestion d'articles");
		lblGestionDarticles.setFont(new Font("Tahoma", Font.BOLD, 14));
		article.add(lblGestionDarticles);
		
		commande = new JPanel();
		commande.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(commande, "name_727945092020900");
		
		JLabel lblGestionDeCommandes = new JLabel("Gestion de commandes");
		lblGestionDeCommandes.setFont(new Font("Tahoma", Font.BOLD, 14));
		commande.add(lblGestionDeCommandes);
		
		categorie = new JPanel();
		categorie.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(categorie, "name_727948124011100");
		
		JLabel lblGestionDeCatgories = new JLabel("Gestion de cat\u00E9gories");
		lblGestionDeCatgories.setFont(new Font("Tahoma", Font.BOLD, 14));
		categorie.add(lblGestionDeCatgories);
		
		JButton btnNewButton = new JButton("Utilistaeurs");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControllerPanelMenuAdmin us = new ControllerPanelMenuAdmin();
				us.switchPanels(user,layeredPane);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(23, 11, 147, 42);
		contentPane.add(btnNewButton);
		
		JButton btnArticles = new JButton("Articles");
		btnArticles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControllerPanelMenuAdmin us = new ControllerPanelMenuAdmin();
				us.switchPanels(article,layeredPane);
			}
		});
		btnArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnArticles.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnArticles.setBounds(212, 11, 147, 42);
		contentPane.add(btnArticles);
		
		JButton btnCommandes_1 = new JButton("Commandes");
		btnCommandes_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControllerPanelMenuAdmin us = new ControllerPanelMenuAdmin();
				us.switchPanels(commande,layeredPane);
			}
		});
		btnCommandes_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCommandes_1.setBounds(408, 11, 147, 42);
		contentPane.add(btnCommandes_1);
		
		JButton btnCommandes = new JButton("Cat\u00E9gories");
		btnCommandes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControllerPanelMenuAdmin us = new ControllerPanelMenuAdmin();
				us.switchPanels(categorie,layeredPane);
			}
		});
		btnCommandes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCommandes.setBounds(611, 11, 157, 42);
		contentPane.add(btnCommandes);
		
		us.afficherTable(table);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				us.viderChamps(nom, prenom, email, password, status, nom);
			}
		});
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEffacer.setBounds(480, 406, 178, 55);
		user.add(btnEffacer);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuitter.setBounds(710, 409, 178, 52);
		user.add(btnQuitter);
	}
}

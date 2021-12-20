package vue;

import controller.ControllerArticleAdmin;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PanelAdminArticle extends JPanel {

	//attributs
	private JTextField productText;
	private JTextField nutripointText;
	private JTextField priceText;
	private JTextField categoryText;
	private JTextField idArticleText;
	private JTable table_1;
	private JPanel panelArticle;

	//constructor
	public PanelAdminArticle() {

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 64, 964, 486);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
	
		//Instanciation d'un objet user 
		ControllerArticleAdmin art = new ControllerArticleAdmin();
		
		panelArticle = new JPanel();
		panelArticle.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(panelArticle, "name_727942207939200");
		panelArticle.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nom de produit");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(31, 57, 117, 34);
		panelArticle.add(lblNewLabel_3);
		
		JLabel lblGestionDarticles = new JLabel("Gestion d'articles");
		lblGestionDarticles.setBounds(421, 5, 171, 34);
		lblGestionDarticles.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelArticle.add(lblGestionDarticles);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nutripoint");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(31, 114, 117, 34);
		panelArticle.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Prix");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(31, 172, 117, 34);
		panelArticle.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Cat\u00E9gorie");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(31, 228, 117, 34);
		panelArticle.add(lblNewLabel_3_3);
		
		productText = new JTextField();
		productText.setBounds(170, 57, 206, 28);
		panelArticle.add(productText);
		productText.setColumns(10);
		
		nutripointText = new JTextField();
		nutripointText.setColumns(10);
		nutripointText.setBounds(170, 114, 206, 28);
		panelArticle.add(nutripointText);
		
		priceText = new JTextField();
		priceText.setColumns(10);
		priceText.setBounds(170, 172, 206, 28);
		panelArticle.add(priceText);
		
		categoryText = new JTextField();
		categoryText.setColumns(10);
		categoryText.setBounds(170, 228, 206, 28);
		panelArticle.add(categoryText);
		
		JButton btnAjout = new JButton("Ajouter");
		btnAjout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjout.setBounds(29, 318, 100, 34);
		panelArticle.add(btnAjout);
		
		JButton btnModif = new JButton("Modifier");
		btnModif.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModif.setBounds(153, 318, 100, 34);
		panelArticle.add(btnModif);
		
		JButton btnSupp = new JButton("Supprimer");
		btnSupp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupp.setBounds(276, 318, 100, 34);
		panelArticle.add(btnSupp);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chercher", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(25, 375, 357, 100);
		panelArticle.add(panel);
		panel.setLayout(null);
		//***********************Chercher un article par id*****************************
		idArticleText = new JTextField();
		idArticleText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String id = idArticleText.getText();		
				art.findById(id, productText, nutripointText, priceText, categoryText);
			}
		});
		idArticleText.setBounds(123, 39, 203, 25);
		panel.add(idArticleText);
		idArticleText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID Article");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 44, 92, 20);
		panel.add(lblNewLabel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(396, 57, 558, 315);
		panelArticle.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		//*****************Afficher la table des utilisateurs**********************
		art.afficherTableArticle(table_1);
		// Bouton Effacer 
		JButton btnClear = new JButton("Effacer");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idArticleText.setText("");
				art.viderChamps(productText, nutripointText, priceText, categoryText,productText);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(464, 400, 178, 55);
		panelArticle.add(btnClear);
		
		JButton btnExit = new JButton("Quitter");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(725, 400, 178, 55);
		panelArticle.add(btnExit);
	}

}

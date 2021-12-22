package vue;

import model.ColorPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.ControllerAdminPanier;

	public class PanelAdminPanier extends JPanel {
		private JTextField textIdCommande;
		private JTextField textIdArticle;
		private JTextField textQuantite;
		private JTextField idCherche;
		private JTable table;
	/**
	 * Create the panel.
	 */
	public PanelAdminPanier() {
		ControllerAdminPanier panier = new ControllerAdminPanier();
		setBackground(Color.GRAY);
		setLayout(null);
		setBounds(43, 90, 900, 450);
		
		JLabel lblNewLabel = new JLabel("Gestion de paniers");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 17));
		lblNewLabel.setBounds(366, 11, 218, 48);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Commande");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(23, 72, 119, 25);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID Article");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(23, 122, 119, 25);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantit\u00E9");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(23, 170, 119, 25);
		add(lblNewLabel_1_2);
		
		textIdCommande = new JTextField();
		textIdCommande.setBounds(168, 74, 154, 23);
		add(textIdCommande);
		textIdCommande.setColumns(10);
		
		textIdArticle = new JTextField();
		textIdArticle.setColumns(10);
		textIdArticle.setBounds(168, 124, 154, 23);
		add(textIdArticle);
		
		textQuantite = new JTextField();
		textQuantite.setColumns(10);
		textQuantite.setBounds(168, 172, 154, 23);
		add(textQuantite);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter.setBounds(23, 232, 85, 32);
		add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifier.setBounds(129, 232, 91, 32);
		add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.setBounds(237, 232, 85, 32);
		add(btnSupprimer);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chercher", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(23, 289, 299, 84);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID Commande");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(10, 32, 106, 26);
		panel.add(lblNewLabel_2);
		
		idCherche = new JTextField();
		idCherche.setBounds(140, 32, 120, 26);
		panel.add(idCherche);
		idCherche.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 70, 558, 358);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEffacer.setBounds(23, 396, 129, 32);
		add(btnEffacer);
		
		JButton btnAjouter_1_1 = new JButton("Quitter");
		btnAjouter_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter_1_1.setBounds(193, 396, 129, 32);
		add(btnAjouter_1_1);
		
		panier.afficherTableCommandePanier(table);
	}
}

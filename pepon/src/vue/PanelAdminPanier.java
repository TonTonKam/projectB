package vue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import controller.ControllerAdminPanier;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	public class PanelAdminPanier extends JPanel {
		private JTextField textIdCommande;
		private JTextField textIdArticle;
		private JTextField textQuantite;
		private JTable table;
		private JTextField idCherche;
	/**
	 * Create the panel.
	 */
	public PanelAdminPanier() {
		ControllerAdminPanier panier = new ControllerAdminPanier();
		setBackground(Color.GRAY);
		setLayout(null);
		setBounds(43, 90, 900, 450);
		
		JLabel lblPanier = new JLabel("Gestion de paniers");
		lblPanier.setForeground(Color.BLACK);
		lblPanier.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanier.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 17));
		lblPanier.setBounds(366, 11, 218, 48);
		add(lblPanier);
		
		JLabel lblCommande = new JLabel("ID Commande");
		lblCommande.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCommande.setBounds(23, 72, 119, 25);
		add(lblCommande);
		
		JLabel lblArticle = new JLabel("ID Article");
		lblArticle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblArticle.setBounds(23, 122, 119, 25);
		add(lblArticle);
		
		JLabel lblQuantite = new JLabel("Quantit\u00E9");
		lblQuantite.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantite.setBounds(23, 170, 119, 25);
		add(lblQuantite);
		
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
		textQuantite.setBounds(168, 172, 77, 23);
		add(textQuantite);
		
		idCherche = new JTextField();
		idCherche.setBounds(23, 402, 14, 20);
		add(idCherche);
		idCherche.setColumns(10);
		idCherche.setVisible(false);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id_article = Integer.parseInt(textIdArticle.getText());
				int quantity = Integer.parseInt(textQuantite.getText());
				String testArticle = idCherche.getText();
				String id_commd = textIdCommande.getText();	
				
				if(!(id_commd.isEmpty())  || !(id_article == 0) || !(quantity ==0)) {
					panier.modifier(id_article, quantity, id_commd, testArticle );
					panier.afficherTableCommandePanier(table);

					panier.viderChamps(textIdCommande, idCherche, textIdArticle, textQuantite);

				}
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifier.setBounds(35, 232, 119, 32);
		add(btnModifier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 70, 558, 358);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				panier.selectRow(textIdCommande, textIdArticle, textQuantite, table);

				panier.selectChamps(idCherche, table);

			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panier.viderChamps(textIdCommande, idCherche, textIdArticle, textQuantite);

			}
		});
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEffacer.setBounds(179, 232, 129, 32);
		add(btnEffacer);
		
		JButton btnAjouter_1_1 = new JButton("Quitter");
		btnAjouter_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjouter_1_1.setBounds(93, 320, 129, 48);
		add(btnAjouter_1_1);
		
		panier.afficherTableCommandePanier(table);
		
	}
}

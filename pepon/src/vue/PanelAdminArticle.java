package vue;
import model.Article;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import controller.ControllerAdminArticle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PanelAdminArticle extends JPanel {
	private JTextField textArticle;
	private JTextField textNutripoint;
	private JTextField textPrix;
	private JTextField textCategorie;
	private JTextField textIdArticle;
	private JTable table;
	
	ControllerAdminArticle art = new ControllerAdminArticle();

	public PanelAdminArticle() {
		
		setBackground(Color.GRAY);
		setLayout(null);
		setBounds(43, 90, 900, 450);
		
		JLabel lblNewLabel = new JLabel("Gestion des articles");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 17));
		lblNewLabel.setBounds(366, 11, 218, 48);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom article");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(21, 79, 130, 31);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nutriponit");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(21, 132, 130, 31);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prix");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(21, 184, 130, 31);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ID Cat\u00E9gorie");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(21, 236, 130, 31);
		add(lblNewLabel_1_3);
		
		textArticle = new JTextField();
		textArticle.setBounds(125, 79, 202, 26);
		add(textArticle);
		textArticle.setColumns(10);
		
		textNutripoint = new JTextField();
		textNutripoint.setColumns(10);
		textNutripoint.setBounds(125, 132, 202, 26);
		add(textNutripoint);
		
		textPrix = new JTextField();
		textPrix.setColumns(10);
		textPrix.setBounds(125, 184, 72, 26);
		add(textPrix);
		
		textCategorie = new JTextField();
		textCategorie.setColumns(10);
		textCategorie.setBounds(125, 236, 202, 26);
		add(textCategorie);
		
		//**********************************************Ajouter un article***************************************************
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String article_saisie = textArticle.getText();
				int nutripoint_saisie = Integer.parseInt(textNutripoint.getText());
				double prix_saisie = Double.parseDouble(textPrix.getText());
				int idCat_saisie = Integer.parseInt(textCategorie.getText());
				
				Article article = new Article(article_saisie,nutripoint_saisie,prix_saisie,idCat_saisie);
				
				if(article_saisie.isEmpty() || nutripoint_saisie == 0 || prix_saisie ==0 || idCat_saisie == 0 ) {
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs svp!","Error",JOptionPane.ERROR_MESSAGE);
				}else {					
					
					if(art.articleExist(article_saisie)) {
						art.ajouter(article);
						
						JOptionPane.showMessageDialog(null, "l'article "+" "+article_saisie+ " "+ " a été bien rajouté avec success");
						
					}else {
						JOptionPane.showMessageDialog(null, "Cet article existe deja !","Error",JOptionPane.ERROR_MESSAGE);		
					}
				}
				art.afficherTableArticle(table);
				art.viderChamps(textArticle, textNutripoint, textPrix, textCategorie, textArticle);
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBounds(21, 301, 96, 31);
		add(btnAjouter);
		
		//****************************************Modifier un article**********************************************
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String article_saisie = textArticle.getText();
				int nutripoint_saisie = Integer.parseInt(textNutripoint.getText());
				double prix_saisie = Double.parseDouble(textPrix.getText());
				int idCat_saisie = Integer.parseInt(textCategorie.getText());
				String idTextArticle = textIdArticle.getText();	
				
				//Appel de la méthode modifier
				if(!article_saisie.isEmpty() || !(nutripoint_saisie == 0) || !(prix_saisie ==0) || !(idCat_saisie == 0) ) {
					art.modifier(article_saisie, nutripoint_saisie, prix_saisie, idCat_saisie, idTextArticle);
					//afficher la table modifiée
					art.afficherTableArticle(table);
				//JOptionPane.showMessageDialog(null, "vous n'avez pas choisi d'article à modifier !","Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBounds(125, 301, 96, 31);
		add(btnModifier);
		
		//****************************************Supprimer un article**********************************************
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String article_saisie = textArticle.getText();
				int nutripoint_saisie = Integer.parseInt(textNutripoint.getText());
				double prix_saisie = Double.parseDouble(textPrix.getText());
				int idCat_saisie = Integer.parseInt(textCategorie.getText());
				
				String idTextArticle = textIdArticle.getText();	
				
				//Appel de la méthode modifier
				if(!article_saisie.isEmpty() || !(nutripoint_saisie == 0) || !(prix_saisie ==0) || !(idCat_saisie == 0) ) {
					art.supprimer(idTextArticle);
					//afficher la table modifiée
					art.afficherTableArticle(table);
				}
				}
				
		});
		
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBounds(231, 301, 96, 31);
		add(btnSupprimer);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBorder(new TitledBorder(null, "Chercher", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 343, 308, 96);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID Article");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 36, 82, 28);
		panel.add(lblNewLabel_2);
		
		textIdArticle = new JTextField();
		textIdArticle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
		//*********************Chercher un article par id*****************************************

			String id = textIdArticle.getText();				
			art.findById(id,textArticle, textNutripoint, textPrix, textCategorie);
			}
		});
		textIdArticle.setBounds(115, 36, 165, 25);
		panel.add(textIdArticle);
		textIdArticle.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(352, 79, 538, 258);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				art.viderChamps(textArticle, textNutripoint, textPrix, textCategorie,textArticle);
				textIdArticle.setText("");
			}
		});
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEffacer.setBounds(392, 358, 177, 62);
		add(btnEffacer);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuitter.setBounds(682, 358, 177, 62);
		add(btnQuitter);
		
		//Afficher la table des articles
		art.afficherTableArticle(table);
		
		JLabel lblNewLabel_3 = new JLabel("\u20AC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(207, 184, 90, 26);
		add(lblNewLabel_3);
	}
}

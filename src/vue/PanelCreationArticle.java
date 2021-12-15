package vue;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Article;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCreationArticle<AcceuilAdministration, ArticleDao> extends JPanel {
	private JTextField nom_article;
	private JTextField nutripoint;
	private JTextField prix;
	private JTextField categorie;

	/**
	 * Create the panel.
	 */
	public PanelCreationArticle() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 288);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Création article");
		lblNewLabel.setBounds(16, 6, 154, 16);
		panel.add(lblNewLabel);
		
		nom_article = new JTextField();
		nom_article.setBounds(204, 39, 130, 26);
		panel.add(nom_article);
		nom_article.setColumns(10);
		
		nutripoint = new JTextField();
		nutripoint.setColumns(10);
		nutripoint.setBounds(204, 76, 130, 26);
		panel.add(nutripoint);
		
		prix = new JTextField();
		prix.setColumns(10);
		prix.setBounds(204, 114, 130, 26);
		panel.add(prix);
		
		categorie = new JTextField();
		categorie.setColumns(10);
		categorie.setBounds(204, 152, 130, 26);
		panel.add(categorie);
		
		JButton btnNewButton = new JButton("Créer l'article");
		btnNewButton.setBounds(131, 203, 117, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Désignation");
		lblNewLabel_1.setBounds(50, 44, 92, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nutripoint");
		lblNewLabel_1_1.setBounds(50, 81, 92, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prix");
		lblNewLabel_1_2.setBounds(50, 119, 61, 16);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Categorie");
		lblNewLabel_1_3.setBounds(50, 157, 61, 16);
		panel.add(lblNewLabel_1_3);

		
	}

}

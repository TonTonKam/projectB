package vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.ArticleDao;
import model.Article;
import model.ColorPanel;

public class PanelArticleSelectClient extends JPanel {

	//attributs
	private int longueurMenu, longueur, haut;
	private JLabel labelImg, labelNom, labelNomCategorie, labelNutripoint, labelPrix, labelNomQuantite;
	private JTextField textFieldQuantite;
	private JButton btnAjouterCommande, btnPrecedent;
	private ArticleDao artDao;

	//constructor
	public PanelArticleSelectClient(int longueurM, int hauteurM) {
		artDao = new ArticleDao();
		ColorPanel color = new ColorPanel();
		setBackground(color.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);

		labelImg = new JLabel("IMG");
		add(labelImg);
		
		labelNom = new JLabel();
		//labelNom.setText(article.getNomArticle());
		add(labelNom);
		
		labelNomCategorie = new JLabel();
		//labelNom.setText(artDao.idCategorieToString(article.getIdArticle()));
		add(labelNomCategorie);
		
		labelNutripoint = new JLabel();
		add(labelNutripoint);
		
		labelPrix = new JLabel();
		add(labelPrix);
		
		labelNomQuantite = new JLabel("Quantite :");
		add(labelNomQuantite);
		
		//quantite a envoyer a la commande
		textFieldQuantite = new JTextField();
		add(textFieldQuantite);
		
		//envoie l'article a la table detail_commande
		//renvoie vers AccueilClient
		btnAjouterCommande = new JButton("Ajouter au panier");
		btnAjouterCommande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		add(btnAjouterCommande);
		
		//renvoie sur la page AccueilClient
		btnPrecedent = new JButton("Précédent");
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				//accueilClient.setVisible(true);
			}
		});
		add(btnPrecedent);
	}

	//getter & setter
	public JTextField getTextFieldQuantite() {
		return textFieldQuantite;
	}

	public void setTextFieldQuantite(JTextField textFieldQuantite) {
		this.textFieldQuantite = textFieldQuantite;
	}

}

package vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.ArticleDao;
import controler.ControlerArticleClient;
import model.Article;
import model.ColorPanel;
import model.PanelModelArticle;

public class PanelArticleSelectClient extends JPanel {

	//attributs
	private int longueurMenu, longueur, haut;
	private JLabel labelImg, labelNom, labelNomCategorie, labelNutripoint, labelPrix, labelNomQuantite;
	private JTextField textFieldQuantite;
	private JButton btnAjouterCommande, btnPrecedent;
	private ArticleDao artDao;
	private ControlerArticleClient controlArt;

	//constructor
	public PanelArticleSelectClient(int longueurM, int hauteurM) {
		artDao = new ArticleDao();
		ColorPanel color = new ColorPanel();
		setBackground(color.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
		
		controlArt = new ControlerArticleClient();

		labelImg = new JLabel("IMG");
		add(labelImg);
		
		//erreur objet null
		labelNom = new JLabel();
		//labelNom.setText(controlArt.readIdArticle(PanelModelArticle.modelIdArticle).getNomArticle());
		add(labelNom);
		
		labelNomCategorie = new JLabel();
		//labelNom.setText(artDao.idCategorieToString(controlArt.readIdArticle(PanelModelArticle.modelIdArticle).getIdArticle()));
		add(labelNomCategorie);
		
		labelNutripoint = new JLabel();
		//labelNutripoint.setText(String.valueOf(controlArt.readIdArticle(PanelModelArticle.modelIdArticle).getNutripoint()));
		add(labelNutripoint);
		
		labelPrix = new JLabel();
		//labelPrix.setText(Double.toString(controlArt.readIdArticle(PanelModelArticle.modelIdArticle).getPrix()));
		add(labelPrix);
		
		labelNomQuantite = new JLabel("Quantite :");
		add(labelNomQuantite);
		
		//quantite a envoyer a la commande
		textFieldQuantite = new JTextField(4);
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
				
			}
		});
		add(btnPrecedent);
		

	}

	//getter & setter
	public JTextField getTextFieldQuantite() {
		return textFieldQuantite;
	}

	public JLabel getLabelNom() {
		return labelNom;
	}

	public void setLabelNom(String labelNom) {
		this.labelNom.setText(labelNom);
	}

	public JLabel getLabelNomCategorie() {
		return labelNomCategorie;
	}

	public void setLabelNomCategorie(String labelNomCategorie) {
		this.labelNomCategorie.setText(labelNomCategorie);
	}

	public JLabel getLabelNutripoint() {
		return labelNutripoint;
	}

	public void setLabelNutripoint(int labelNutripoint) {
		this.labelNutripoint.setText(Integer.toString(labelNutripoint));
	}

	public JLabel getLabelPrix() {
		return labelPrix;
	}

	public void setLabelPrix(Double labelPrix) {
		this.labelPrix.setText(Double.toString(labelPrix));
	}

	
}

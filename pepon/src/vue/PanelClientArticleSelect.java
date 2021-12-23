package vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ArticleDao;
import controller.ControllerClientArticle;
import controller.ControllerClientMenuPanier;
import controller.UserDao;
import model.Article;
import model.ColorPanel;
import model.PanelModelArticle;
import model.VarStatic;

public class PanelClientArticleSelect extends JPanel {

	//attributs
	private int longueurMenu, longueur, haut;
	private JLabel labelImg, labelNom, labelNomCategorie, labelNutripoint, labelPrix, labelNomQuantite;
	private JTextField textFieldQuantite;
	private JButton btnAjouterCommande, btnPrecedent;
	private ControllerClientArticle controlArt;
	private ControllerClientMenuPanier controlPanier;

	//constructor
	public PanelClientArticleSelect(PanelClientPanierMenu panelMenu, int longueurM, int hauteurM) {
		
		setVisible(false);
		setBackground(ColorPanel.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
		
		controlArt = new ControllerClientArticle();
		PanelClientArticleSelect panelThis = this;

		labelImg = new JLabel("IMG");
		add(labelImg);
		
		//erreur objet null
		labelNom = new JLabel();
		add(labelNom);
		
		labelNomCategorie = new JLabel();
		add(labelNomCategorie);
		
		labelNutripoint = new JLabel();
		add(labelNutripoint);
		
		labelPrix = new JLabel();
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
				
				/*
				 * creer dans la table commande LA commande
				 * "INSERT INTO commande (id_commande, date, id_user) VALUES (null, now(), currentUser)";
				 * 
				 * ajouterPanier(INSERT INTO) dans la table panier + la quantite =>
				 * INSERT INTO panier (id_commande, id_article, quantite) VALUES (commande.last_id_bdd(), this.article.idArticle, 2)
				 */
				
				/*
				 * dans commande le calcule de l'article + quantite est mis dans prixTotal
				 */
				controlArt.creerCommandeAndAddPanier(Integer.parseInt(textFieldQuantite.getText()));
				
				panelThis.setVisible(false);
				
				/* probleme en attente
				//refresh PanelMenuPanier
				//controlPanier = new ControllerClientMenuPanier();
				//controlPanier.affichePanierClient(panelMenu);
				
				//retourner a la fonction menuClient
				setVisible(false);
				//panelAccueilClient.setVisible(true);
				 */
				
			}
		});
		add(btnAjouterCommande);
		
		/*
		//renvoie sur la page AccueilClient
		btnPrecedent = new JButton("Precedent");
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				
			}
		});
		add(btnPrecedent);
		 */
	}

	//getter & setter
	//remaniment des setter pour modifier le contenu et pas le JLabel 
	
	public JTextField getTextFieldQuantite() {
		return textFieldQuantite;
	}

	public void setLabelNom(String labelNom) {
		this.labelNom.setText(labelNom);
	}

	public void setLabelNomCategorie(String labelNomCategorie) {
		this.labelNomCategorie.setText(labelNomCategorie);
	}

	public void setLabelNutripoint(String labelNutripoint) {
		this.labelNutripoint.setText(labelNutripoint);
	}

	public void setLabelPrix(String labelPrix) {
		this.labelPrix.setText(labelPrix);
	}

	
}

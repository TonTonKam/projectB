package vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ArticleDao;
import controller.ControlerArticleClient;
import controller.UserDao;
import model.Article;
import model.ColorPanel;
import model.PanelModelArticle;
import model.VarStatic;

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
		setBackground(ColorPanel.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
		
		controlArt = new ControlerArticleClient();

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
				 */
				controlArt.creerCommande();
				/*
				 * ajouterPanier(INSERT INTO) dans la table panier + la quantite =>
				 * INSERT INTO panier (id_commande, id_article, quantite) VALUES (commande.last_id_bdd(), this.article.idArticle, 2)
				 */
				
				/*
				 * dans commande le calcule de l'article + quantite est mis dans prixTotal
				 */
				controlArt.ajouterDetail(VarStatic.idCommandeStatic, VarStatic.IdArticleModelStatic , Integer.parseInt(textFieldQuantite.getText()));
				
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

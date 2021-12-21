package model;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerCommandeClient;
import vue.PanelArticleSelectClient;

public class PanelModelArtCommande extends JPanel {

	//attibuts
	private JLabel labelImage, labelNom, labelQuantite, labelPrix, labelNutripoint, labelTTC, labelPrixTotal;
	private ControllerCommandeClient controlCommand;
	
	//constructor
	public PanelModelArtCommande(Article article) {

		controlCommand = new ControllerCommandeClient();
		
		labelImage = new JLabel("IMG");
		add(labelImage);
		
		labelNom = new JLabel();
		labelNom.setText(article.getNomArticle());
		add(labelNom);
		
		labelQuantite = new JLabel("quantiteArticle");
		//la quantite vient de la table panier
		controlCommand.getQuantPanier(article);
		add(labelQuantite);
		
		labelPrix = new JLabel();
		labelNom.setText(String.valueOf(article.getPrix()));
		add(labelPrix);
		
		labelNutripoint = new JLabel();
		labelNom.setText(String.valueOf(article.getNutripoint()));
		add(labelNutripoint);
		
		labelTTC = new JLabel("TTC");
		add(labelTTC);
		
		labelPrixTotal = new JLabel("prixTotal");
		//prixTotal vient de la table commande
		add(labelPrixTotal);
		
	}

}

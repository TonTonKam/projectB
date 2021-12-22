package model;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerClientCommande;
import vue.PanelClientArticleSelect;

public class PanelModelArtCommande extends JPanel {

	//attibuts
	private JLabel labelImage, labelNom, labelQuantite, labelPrix, labelNutripoint, labelTTC, labelPrixTotal;
	private ControllerClientCommande controlCommand;
	
	//constructor
	public PanelModelArtCommande(Article article, int longueurM) {
		setBounds(0, 0, longueurM, 50);

		controlCommand = new ControllerClientCommande();
		
		labelImage = new JLabel("IMG");
		add(labelImage);
		
		labelNom = new JLabel();
		labelNom.setText(article.getNomArticle());
		add(labelNom);
		
		labelQuantite = new JLabel("quantiteArticle");
		//la quantite vient de la table panier
		labelQuantite.setText(String.valueOf(controlCommand.getQuantPanier(article)));
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
		labelPrixTotal.setText(String.valueOf(controlCommand.getPrixTotal(article,
				controlCommand.getQuantPanier(article))));
		add(labelPrixTotal);
		
	}

	public int getPrixTotalLabel() {
		return Integer.parseInt(labelPrixTotal.getText());
	}
	
	

}

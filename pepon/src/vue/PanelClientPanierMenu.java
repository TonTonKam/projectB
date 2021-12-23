package vue;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.ControllerClientCommande;
import controller.ControllerClientMenuPanier;

public class PanelClientPanierMenu extends JPanel {

	//attributs
	private JLabel labelPanier, labelPrixTotal;
	private JTextArea areaPanier;
	private JButton btnCommande;
	private ControllerClientMenuPanier controlPanier;
	private ControllerClientCommande controleCommande;
	
	//constructor
	public PanelClientPanierMenu(PanelClientCommande panelExpedition, JPanel panelReception1, JPanel panelReception2, int longueurM, int hauteurM) {
		setBackground(new Color(128, 128, 255));
		int longueur = longueurM / 4;
		int haut = hauteurM - 200;

		setBounds(0, 200, longueur, haut);
		//setLayout(new SpringLayout());
		
		labelPanier = new JLabel("Panier");
		add(labelPanier);
		
		//permet de visualiser le prix total du panier
		labelPrixTotal = new JLabel("PrixTotal €");
		add(labelPrixTotal);
		
		/*
		 * -receptionne la commande
		 * -permet de visualiser tous les articles commander de facon
		 * simplifier avec juste NomArticle + Quantite
		 * prixTotal affiche le calcule
		 * le panier affiche la contenance de la panier de l'utilisateur connecte
		 */
		areaPanier = new JTextArea();
		areaPanier.setColumns(25);
		add(areaPanier);
		
		btnCommande = new JButton("Voir commande");
		btnCommande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//envoie vers la page CommandeClient
				PanelClientListArticleCommande panelListAticle = new PanelClientListArticleCommande(longueurM, hauteurM);
				controleCommande = new ControllerClientCommande();
				panelExpedition.add(panelListAticle);
				panelExpedition.setVisible(true);
				panelListAticle.setVisible(true);
				panelListAticle.repaint();
				panelListAticle.revalidate();
				controleCommande.modifPanel(panelExpedition);
				panelReception1.setVisible(false);
				panelReception2.setVisible(false);
			}
		});
		add(btnCommande);
		
		//refresh
		//controlPanier = new ControllerClientMenuPanier();
		//controlPanier.affichePanierClient(this);

	} //fin constructor

	//getter & setter
	public JLabel getLabelPrixTotal() {
		return labelPrixTotal;
	}

	//receptionne la value du prix 
	public void setLabelPrixTotal(Double labelPrixTotal) {
		this.labelPrixTotal.setText(Double.toString(labelPrixTotal));
	}

	public JTextArea getAreaPanier() {
		return areaPanier;
	}

	//manipulation du contenu du areaText
	public void setAreaPanier(String areaPanier) {
		this.areaPanier.setText(areaPanier);
	}

}

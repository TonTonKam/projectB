package vue;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import controller.ControllerClientCommande;
import model.ColorPanel;

public class PanelClientCommande extends JPanel {

	//attributs
	private int longueurMenu, longueur, haut;
	private PanelClientListArticleCommande panelListAticle;
	private JLabel labelPanierNutripoint, labelAfficheMoyenNutripoint,
		labelNomNbArticleTotal, labelAfficheNbArticleTotal, labelAffichePrixTotal, labelPrixTotal;

	private JButton btnValidation, btnPrecedent;
	private ControllerClientCommande controleClient;

	//constructor
	public PanelClientCommande(int longueurM, int hauteurM) {

		setBackground(ColorPanel.vertClair());
		setVisible(false);
		longueurMenu = longueurM / 4 ;
		longueur = longueurM * 3 / 4 - 10;
		haut = hauteurM - 200;
		
		setLayout(null);
		setBounds(longueurMenu, 200, longueur, haut);		
		
		//panel
		controleClient = new ControllerClientCommande();
		
		labelPanierNutripoint = new JLabel("Moyenne nutripoint");
		labelPanierNutripoint.setBounds(longueur / 2 + 30, 410, 200, 20);
		
		labelAfficheMoyenNutripoint = new JLabel();
		labelAfficheMoyenNutripoint.setBounds(longueur / 2 + 180, 410, 45, 20);
		
		labelNomNbArticleTotal = new JLabel("Nombre article total");
		labelNomNbArticleTotal.setBounds(longueur / 2 + 30, 440, 200, 20);
		
		labelAfficheNbArticleTotal = new JLabel();
		labelAfficheNbArticleTotal.setBounds(longueur / 2 + 180, 440, 45, 20);
		
		labelPrixTotal = new JLabel("Total achat");
		labelPrixTotal.setBounds(longueur / 2 + 80, 470, 200, 20);
		
		labelAffichePrixTotal = new JLabel( " €");
		labelAffichePrixTotal.setBounds(longueur / 2 + 150, 470, 200, 20);
		
		btnValidation = new JButton("Validation d'achat");
		btnValidation.setBounds(longueur / 2 + 30, 500, 200, 20);
		
		btnValidation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//validation de la commande page HAPPYHOUR
				
			}
		});
		
		/*
		btnPrecedent = new JButton("Precedent");
		btnPrecedent.setBounds(longueur / 2 + 30, 520, 200, 20);
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				//retour acceuil (liste article)
				//PanelAccueilClient.setVisible(true);
			}
		});
		*/
		
		add(labelPanierNutripoint);
		add(labelAfficheMoyenNutripoint);
		add(labelNomNbArticleTotal);
		add(labelAfficheNbArticleTotal);
		add(btnValidation);
		add(labelAffichePrixTotal);
		add(labelPrixTotal);
		
		//add(btnPrecedent);
	}

	//setter
	public void setLabelAfficheMoyenNutripoint(String labelAfficheMoyenNutripoint) {
		this.labelAfficheMoyenNutripoint.setText(labelAfficheMoyenNutripoint);;
	}

	public void setLabelAfficheNbArticleTotal(String labelAfficheNbArticleTotal) {
		this.labelAfficheNbArticleTotal.setText(labelAfficheNbArticleTotal);;
	}

	public void setLabelAffichePrixTotal(String labelAffichePrixTotal) {
		this.labelAffichePrixTotal.setText(labelAffichePrixTotal);;
	}
	
}

package vue;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import model.ColorPanel;

public class PanelCommandeClient extends JPanel {

	//attributs
	private int longueurMenu, longueur, haut;
	private JScrollPane scrollPan;
	private JPanel panScroll;
	private JLabel labelPanierNutripoint, labelAfficheMoyenNutripoint,
		labelNomNbArticleTotal, labelAfficheNbArticleTotal, labelAffichePrixTotal, labelPrixTotal;
	//label test
	private JLabel labelPanierNutripoint1, labelAfficheMoyenNutripoint1, labelNomNbArticleTotal1, labelAfficheNbArticleTotal1;
	private JButton btnValidation, btnPrecedent;

	//constructor
	public PanelCommandeClient(int longueurM, int hauteurM) {

		setBackground(ColorPanel.vertClair());
		setVisible(false);
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setLayout(null);
		setBounds(longueurMenu, 200, longueur, haut);
		System.out.println(longueurMenu +" "+ 200 +" "+ longueur +" "+ haut);
		panScroll = new JPanel();
		scrollPan = new JScrollPane(panScroll);
		
		scrollPan.setBounds(10, 10, longueur / 2, haut);
		
		panScroll.setBackground(ColorPanel.vertFoncer());
		add(scrollPan);
		
		//scroll panel
		labelPanierNutripoint1 = new JLabel("n points 1");
		labelAfficheMoyenNutripoint1 = new JLabel("moyenne points 1");
		labelNomNbArticleTotal1 = new JLabel("nb article 1");
		labelAfficheNbArticleTotal1 = new JLabel("t total 1");
		
		
		//panel
		labelPanierNutripoint = new JLabel("Moyenne nutripoint");
		labelPanierNutripoint.setBounds(longueur / 2 + 30, 10, 200, 20);
		
		labelAfficheMoyenNutripoint = new JLabel("90");
		labelAfficheMoyenNutripoint.setBounds(longueur / 2 + 30, 30, 45, 20);
		
		labelNomNbArticleTotal = new JLabel("Nombre article total");
		labelNomNbArticleTotal.setBounds(longueur / 2 + 30, 250, 200, 20);
		
		labelAfficheNbArticleTotal = new JLabel("5");
		labelAfficheNbArticleTotal.setBounds(longueur / 2 + 30, 270, 45, 20);
		
		labelAffichePrixTotal = new JLabel("Total achat");
		labelAffichePrixTotal.setBounds(longueur / 2 + 80, 450, 200, 20);
		
		labelPrixTotal = new JLabel("prix �");
		labelPrixTotal.setBounds(longueur / 2 + 150, 450, 200, 20);
		
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
		
		//scrollPanel
		panScroll.add(labelPanierNutripoint1);
		panScroll.add(labelAfficheMoyenNutripoint1);
		panScroll.add(labelNomNbArticleTotal1);
		panScroll.add(labelAfficheNbArticleTotal1);
		
	}

	
}

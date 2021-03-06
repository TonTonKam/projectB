package vue;

import java.awt.Color;

import javax.swing.*;

import model.ColorPanel;

public class PanelCommandeClient extends JPanel {

	//attributs
	private int longueurMenu, longueur, haut;
	private JScrollPane scrollPan;
	private JPanel panScroll;
	private JLabel labelPanierNutripoint, labelAfficheMoyenNutripoint, labelNomNbArticleTotal, labelAfficheNbArticleTotal;
	private JLabel labelPanierNutripoint1, labelAfficheMoyenNutripoint1, labelNomNbArticleTotal1, labelAfficheNbArticleTotal1;

	//constructor
	public PanelCommandeClient(int longueurM, int hauteurM) {

		setBackground(ColorPanel.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setLayout(null);
		setBounds(longueurMenu, 200, longueur, haut);
		
		panScroll = new JPanel();
		scrollPan = new JScrollPane(panScroll);
		
		scrollPan.setBounds(longueurMenu + 10, 210, longueur / 2, haut);
		
		panScroll.setBackground(ColorPanel.vertFoncer());
		add(scrollPan);
		
		labelPanierNutripoint = new JLabel("n points");
		labelAfficheMoyenNutripoint = new JLabel("moyenne points");
		labelNomNbArticleTotal = new JLabel("nb article");
		labelAfficheNbArticleTotal = new JLabel("t total");
		
		labelPanierNutripoint1 = new JLabel("n points 1");
		labelAfficheMoyenNutripoint1 = new JLabel("moyenne points 1");
		labelNomNbArticleTotal1 = new JLabel("nb article 1");
		labelAfficheNbArticleTotal1 = new JLabel("t total 1");
		
		add(labelPanierNutripoint);
		add(labelAfficheMoyenNutripoint);
		add(labelNomNbArticleTotal);
		add(labelAfficheNbArticleTotal);
		
		panScroll.add(labelPanierNutripoint1);
		panScroll.add(labelAfficheMoyenNutripoint1);
		panScroll.add(labelNomNbArticleTotal1);
		panScroll.add(labelAfficheNbArticleTotal1);
		
	}

}

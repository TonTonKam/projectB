package vue;

import javax.swing.*;

import controller.ControllerClientMenu;
import model.ColorPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMenuClient extends JPanel {

	//label temporaire a definir
	private JButton btnAll, btnBoisson, btnLegume, btnFruit, btnConverve, btnCharcuterie;
	private ControllerClientMenu controlMC;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuClient(JPanel panelGeneral, PanelArticleSelectClient panelExpedition, int longueurM) {
		controlMC = new ControllerClientMenu();
		setBackground(ColorPanel.vertFoncer());
		setBounds(0, 120, longueurM, 80);
		
		btnAll = new JButton("tous afficher");
		btnAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general tous les articles
				controlMC.afficherAllArticles(panelGeneral, panelExpedition, longueurM);
				panelExpedition.setVisible(false);
				panelGeneral.setVisible(true);
			}
		});
		add(btnAll);
		
		btnBoisson = new JButton("Boissons");
		btnBoisson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "boisson"
				controlMC.afficherAllBoissons(panelGeneral, panelExpedition, longueurM);
				panelExpedition.setVisible(false);
				panelGeneral.setVisible(true);
			}
		});
		add(btnBoisson);
		
		btnLegume = new JButton("Legumes");
		btnLegume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "legume"
				controlMC.afficherAllLegumes(panelGeneral, panelExpedition, longueurM);
				panelExpedition.setVisible(false);
				panelGeneral.setVisible(true);
			}
		});
		add(btnLegume);
		
		btnFruit = new JButton("Fruits");
		btnFruit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "fruits"
				controlMC.afficherAllFruits(panelGeneral, panelExpedition, longueurM);
				panelExpedition.setVisible(false);
				panelGeneral.setVisible(true);
			}
		});
		add(btnFruit);
		
		btnConverve = new JButton("Concerves");
		btnConverve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "converve"
				controlMC.afficherAllConcerves(panelGeneral, panelExpedition, longueurM);
				panelExpedition.setVisible(false);
				panelGeneral.setVisible(true);
			}
		});
		add(btnConverve);
		
		btnCharcuterie = new JButton("Charcuteries");
		btnCharcuterie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "charcuterie"
				controlMC.afficherAllCharcuteries(panelGeneral, panelExpedition, longueurM);
				panelExpedition.setVisible(false);
				panelGeneral.setVisible(true);
			}
		});
		add(btnCharcuterie);
	}

}

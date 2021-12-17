package vue;

import javax.swing.*;

import controler.ControllerMenuClient;
import model.ColorPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMenuClient extends JPanel {

	//label temporaire a definir
	private JButton btnAll, btnBoisson, btnLegume, btnFruit, btnConverve, btnCharcuterie;
	private ControllerMenuClient controlMC;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuClient(JPanel panelGeneral, int longueurM) {
		controlMC = new ControllerMenuClient();
		ColorPanel color = new ColorPanel();
		setBackground(color.vertFoncer());
		setBounds(0, 120, longueurM, 80);
		
		btnAll = new JButton("tous afficher");
		btnAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general tous les articles
				controlMC.afficherAllArticles(panelGeneral, longueurM);
			}
		});
		add(btnAll);
		
		btnBoisson = new JButton("Boissons");
		btnBoisson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "boisson"
				controlMC.afficherAllBoissons(panelGeneral, longueurM);
			}
		});
		add(btnBoisson);
		
		btnLegume = new JButton("Legumes");
		btnLegume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "legume"
				controlMC.afficherAllLegumes(panelGeneral, longueurM);
			}
		});
		add(btnLegume);
		
		btnFruit = new JButton("Fruits");
		btnFruit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "fruits"
				controlMC.afficherAllFruits(panelGeneral, longueurM);
			}
		});
		add(btnFruit);
		
		btnConverve = new JButton("Concerves");
		btnConverve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "converve"
				controlMC.afficherAllConcerves(panelGeneral, longueurM);
			}
		});
		add(btnConverve);
		
		btnCharcuterie = new JButton("Charcuteries");
		btnCharcuterie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "charcuterie"
				controlMC.afficherAllCharcuteries(panelGeneral, longueurM);
			}
		});
		add(btnCharcuterie);
	}

}

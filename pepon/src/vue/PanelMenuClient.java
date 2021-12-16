package vue;

import javax.swing.*;

import model.ColorPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMenuClient extends JPanel {

	//label temporaire a definir
	private JButton btnAll, btnBoisson, btnLegume, btnFruit, btnConverve, btnCharcuterie;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuClient(int longueurM) {
		ColorPanel color = new ColorPanel();
		setBackground(color.vertFoncer());
		setBounds(0, 120, longueurM, 80);
		
		btnAll = new JButton("tous afficher");
		btnAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general tous les articles
			}
		});
		add(btnAll);
		
		btnBoisson = new JButton("Boissons");
		btnBoisson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "boisson"
			}
		});
		add(btnBoisson);
		
		btnLegume = new JButton("Legumes");
		btnLegume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "legume"
			}
		});
		add(btnLegume);
		
		btnFruit = new JButton("Fruits");
		btnFruit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "fruits"
			}
		});
		add(btnFruit);
		
		btnConverve = new JButton("Concerve");
		btnConverve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "converve"
			}
		});
		add(btnConverve);
		
		btnCharcuterie = new JButton("Charcuterie");
		btnCharcuterie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//met dans le panel general les articles de categrorie : "charcuterie"
			}
		});
		add(btnCharcuterie);
	}

}

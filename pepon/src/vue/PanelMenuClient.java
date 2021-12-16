package vue;

import javax.swing.*;

import model.ColorPanel;

import java.awt.Color;

public class PanelMenuClient extends JPanel {

	//label temporaire a definir
	JButton btnBoisson, btnLegume, btnFruit, btnConverve, btnCharcuterie;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuClient(int longueurM) {
		ColorPanel color = new ColorPanel();
		setBackground(color.vertFoncer());
		setBounds(0, 120, longueurM, 80);
		
		btnBoisson = new JButton("Boissons");
		add(btnBoisson);
		btnLegume = new JButton("Legumes");
		add(btnLegume);
		btnFruit = new JButton("Fruits");
		add(btnFruit);
		btnConverve = new JButton("Concerve");
		add(btnConverve);
		btnCharcuterie = new JButton("Charcuterie");
		add(btnCharcuterie);
	}

}

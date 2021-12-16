package model;

import javax.swing.*;
import java.awt.Color;

public class PanelModelGeneral extends JPanel {

	private int longueurMenu, longueur, haut;
	/**
	 * Create the panel.
	 */
	public PanelModelGeneral(int longueurM, int hauteurM) {
		ColorPanel color = new ColorPanel();
		setBackground(color.vertClair());
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
	}

}

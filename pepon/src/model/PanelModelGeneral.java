package model;

import javax.swing.*;
import java.awt.Color;

public class PanelModelGeneral extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelModelGeneral(int longueurM, int hauteurM) {
		ColorPanel color = new ColorPanel();
		setBackground(color.vertClair());
		int longueurMenu = longueurM / 4;
		int longueur = longueurM * 3 / 4 ;
		int haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
	}

}

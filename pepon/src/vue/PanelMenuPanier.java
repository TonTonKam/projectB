package vue;

import javax.swing.*;
import java.awt.Color;
import javax.swing.SpringLayout;

public class PanelMenuPanier extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMenuPanier(int longueurM, int hauteurM) {
		setBackground(new Color(128, 128, 255));
		int longueur = longueurM / 4;
		int haut = hauteurM - 200;
		
		setBounds(0, 200, longueur, haut);
		setLayout(new SpringLayout());
	}

}

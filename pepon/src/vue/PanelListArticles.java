package vue;

import javax.swing.*;
import java.awt.Color;

public class PanelListArticles extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelListArticles(int longueurM, int hauteurM) {
		setBackground(new Color(0, 234, 117));
		int longueurMenu = longueurM / 4;
		int longueur = longueurM * 3 / 4 ;
		int haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
	}

}
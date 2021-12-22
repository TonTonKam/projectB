package vue;

import javax.swing.JPanel;

import model.ColorPanel;

public class test extends JPanel {
	private int longueurMenu;
	private int longueur;
	private int haut;

	/**
	 * Create the panel.
	 */
	public test(int longueurM, int hauteurM) {

		setBackground(ColorPanel.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setLayout(null);
		setBounds(longueurMenu, 200, longueur, haut);
	}

}

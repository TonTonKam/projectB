package vue;

import javax.swing.JPanel;

import model.ColorPanel;

public class PanelAccueilClient extends JPanel{
	
	private int longueurMenu, longueur, haut;
	
	public PanelAccueilClient(int longueurM, int hauteurM) {
		
		ColorPanel color = new ColorPanel();
		setBackground(color.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
		
		//voir la liste des articles
	}
	
}

package vue;

import javax.swing.JPanel;

import controler.ControlerAccueilClient;
import model.ColorPanel;

public class PanelAccueilClient extends JPanel{
	
	private int longueurMenu, longueur, haut;
	private ControlerAccueilClient controlAccueil;
	
	public PanelAccueilClient(PanelArticleSelectClient panelExpedition, int longueurM, int hauteurM) {
		controlAccueil = new ControlerAccueilClient();
		ColorPanel color = new ColorPanel();
		setBackground(color.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
		
		//voir la liste des articles
		controlAccueil.afficheListArticleDefault(this, panelExpedition, longueurM);
	}
	
}

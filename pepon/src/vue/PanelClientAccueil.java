package vue;

import javax.swing.JPanel;

import controller.ControllerClientAccueil;
import controller.ControllerClientMenu;
import model.ColorPanel;
import model.User;
import model.VarStatic;

public class PanelClientAccueil extends JPanel{
	
	private int longueurMenu, longueur, haut;
	private ControllerClientAccueil controlAccueil;
	private ControllerClientMenu controlMenu;
	private int index;
	
	public PanelClientAccueil(PanelClientArticleSelect panelExpedition, int longueurM, int hauteurM) {
		controlAccueil = new ControllerClientAccueil();
		controlMenu = new ControllerClientMenu();
		setBackground(ColorPanel.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
		
		//voir la liste des articles
		for(index = controlMenu.listCategorie().size() + 1; index > 0; index --) {
			controlAccueil.afficherAllArticles(this, panelExpedition, longueurM, index);
		}
	}
	
}

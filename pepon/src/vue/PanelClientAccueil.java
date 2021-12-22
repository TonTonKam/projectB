package vue;

import javax.swing.JPanel;

import controller.ControllerClientAccueil;
import model.ColorPanel;
import model.User;
import model.VarStatic;

public class PanelClientAccueil extends JPanel{
	
	private int longueurMenu, longueur, haut;
	private ControllerClientAccueil controlAccueil;
	public static User currentUserStatic ;
	
	public PanelClientAccueil(PanelArticleSelectClient panelExpedition, int longueurM, int hauteurM) {
		controlAccueil = new ControllerClientAccueil();
		setBackground(ColorPanel.vertClair());
		
		longueurMenu = longueurM / 4;
		longueur = longueurM * 3 / 4 ;
		haut = hauteurM - 200;
		
		setBounds(longueurMenu, 200, longueur, haut);
		
		//voir la liste des articles
		controlAccueil.afficheListArticleDefault(this, panelExpedition, longueurM);
		System.out.println(currentUserStatic);
	}
	
}

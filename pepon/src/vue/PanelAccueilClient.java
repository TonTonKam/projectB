package vue;

import javax.swing.JPanel;

import controller.ControlerAccueilClient;
import model.ColorPanel;
import model.User;
import model.VarStatic;

public class PanelAccueilClient extends JPanel{
	
	private int longueurMenu, longueur, haut;
	private ControlerAccueilClient controlAccueil;
	public static User currentUserStatic ;
	
	public PanelAccueilClient(PanelArticleSelectClient panelExpedition, int longueurM, int hauteurM) {
		controlAccueil = new ControlerAccueilClient();
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

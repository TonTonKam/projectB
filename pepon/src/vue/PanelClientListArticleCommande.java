package vue;

import javax.swing.JPanel;

import controller.ControllerClientCommande;
import model.ColorPanel;

public class PanelClientListArticleCommande extends JPanel{
	
	//attributs
	private ControllerClientCommande controlCommand;
	
	//constructor
	public PanelClientListArticleCommande(int longueurM, int hauteurM) {
		
		int longueur = longueurM * 3 / 4 ;
		int haut = hauteurM - 200;
		
		setBounds(10, 30, longueur - 30, haut / 2 + 50);
		setBackground(ColorPanel.vertFoncer());
		
		controlCommand = new ControllerClientCommande();
		controlCommand.afficheModelArtCommande(this, longueurM);
	}
}

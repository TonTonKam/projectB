package controler;

import javax.swing.JPanel;

import model.Article;

public class ControlerAccueilClient {

	private ControllerMenuClient controlMC = new ControllerMenuClient();
	
	public void afficheListArticleDefault(JPanel panelReception, JPanel panelExpedition, int longueurMax) {
		controlMC.afficherAllArticles(panelReception, panelExpedition, longueurMax);
	}

}

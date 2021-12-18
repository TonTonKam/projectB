package controler;

import javax.swing.JPanel;

import model.Article;
import vue.PanelArticleSelectClient;

public class ControlerAccueilClient {

	private ControllerMenuClient controlMC = new ControllerMenuClient();
	
	public void afficheListArticleDefault(JPanel panelReception, PanelArticleSelectClient panelExpedition, int longueurMax) {
		controlMC.afficherAllArticles(panelReception, panelExpedition, longueurMax);
	}

}

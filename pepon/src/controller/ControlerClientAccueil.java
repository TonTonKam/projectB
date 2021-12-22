package controller;

import javax.swing.JPanel;

import model.Article;
import vue.PanelArticleSelectClient;

public class ControlerClientAccueil {

	private ControllerClientMenu controlMC = new ControllerClientMenu();
	
	public void afficheListArticleDefault(JPanel panelReception, PanelArticleSelectClient panelExpedition, int longueurMax) {
		controlMC.afficherAllArticles(panelReception, panelExpedition, longueurMax);
	}

}

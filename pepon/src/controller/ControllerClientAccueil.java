package controller;

import javax.swing.JPanel;

import model.Article;
import vue.PanelClientArticleSelect;

public class ControllerClientAccueil {

	private ControllerClientMenu controlMC = new ControllerClientMenu();
	
	public void afficheListArticleDefault(JPanel panelReception, PanelClientArticleSelect panelExpedition, int longueurMax) {
		controlMC.afficherAllArticles(panelReception, panelExpedition, longueurMax);
	}

}

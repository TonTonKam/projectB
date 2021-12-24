package controller;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Article;
import model.PanelModelArticle;
import vue.PanelClientAccueil;
import vue.PanelClientArticleSelect;

public class ControllerClientAccueil {

	private ControllerClientMenu controlMC = new ControllerClientMenu();

	public void afficherAllArticles(PanelClientAccueil panelReception, PanelClientArticleSelect panelExpedition,  int longueurMax, int index) {
		
		//j'efface toutes les informations du panel
		panelReception.removeAll();
		
		//j'associe la requette de ArticleDao a la liste
		ArrayList<Article> listArt = new ArrayList();
		listArt = (ArrayList<Article>) controlMC.afficheArticlesDesCategories(index);
		
		/*
		 * - je met chacuns des elements de la liste dans un modelArticle
		 * - le modelArticle s'attache au panel
		 */
		for(int i = 0; i < listArt.size(); i++) {
			panelReception.add(new PanelModelArticle(listArt.get(i), panelReception, panelExpedition, longueurMax));
			
		}
		
		//je repaint le panel qui a ete valide plus haut avec les nouveaux elements
		panelReception.repaint();
		panelReception.revalidate();
	}
}

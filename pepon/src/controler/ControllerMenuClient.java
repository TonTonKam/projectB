package controler;


import java.util.ArrayList;

import javax.swing.JPanel;

import model.Article;
import model.PanelModelArticle;

public class ControllerMenuClient {
	
	//attributs
	private ArticleDao artDao = new ArticleDao();

	//methodes
	public void afficherAllArticles(JPanel panelReception, int longueurMax) {
		
		//j'efface toutes les informations du panel
		panelReception.removeAll();
		
		//j'associe la requette de ArticleDao a la liste
		ArrayList<Article> listArt = new ArrayList();
		listArt = (ArrayList<Article>) artDao.readArt();
		
		/*
		 * - je met chacuns des elements de la liste dans un modelArticle
		 * - le modelArticle s'attache au panel
		 */
		for(int i = 0; i < listArt.size(); i++) {
			 panelReception.add(new PanelModelArticle(listArt.get(i), longueurMax));
			 
		}
		
		//je repaint le panel qui a ete valide plus haut avec les nouveaux elements
		panelReception.repaint();
		panelReception.revalidate();
	}
	
	public void afficherAllBoissons(JPanel panelReception, int longueurMax) {
		
		panelReception.removeAll();
		
		ArrayList<Article> listArt = new ArrayList();
		listArt = (ArrayList<Article>) artDao.readCategorieBoisson();
		
		for(int i = 0; i < listArt.size(); i++) {
			 panelReception.add(new PanelModelArticle(listArt.get(i), longueurMax));
			 
		}
		panelReception.repaint();
		panelReception.revalidate();
	}
	
	public void afficherAllFruits(JPanel panelReception, int longueurMax) {
		
		panelReception.removeAll();
		
		ArrayList<Article> listArt = new ArrayList();
		listArt = (ArrayList<Article>) artDao.readCategorieFruits();
		
		for(int i = 0; i < listArt.size(); i++) {
			 panelReception.add(new PanelModelArticle(listArt.get(i), longueurMax));
			 
		}
		panelReception.repaint();
		panelReception.revalidate();
	}
	
	public void afficherAllLegumes(JPanel panelReception, int longueurMax) {
		
		panelReception.removeAll();
		
		ArrayList<Article> listArt = new ArrayList();
		listArt = (ArrayList<Article>) artDao.readCategorieLegumes();
		
		for(int i = 0; i < listArt.size(); i++) {
			 panelReception.add(new PanelModelArticle(listArt.get(i), longueurMax));
			 
		}
		panelReception.repaint();
		panelReception.revalidate();
	}
	
	public void afficherAllConcerves(JPanel panelReception, int longueurMax) {
		
		panelReception.removeAll();
		
		ArrayList<Article> listArt = new ArrayList();
		listArt = (ArrayList<Article>) artDao.readCategorieConcerves();
		
		for(int i = 0; i < listArt.size(); i++) {
			panelReception.add(new PanelModelArticle(listArt.get(i), longueurMax));
			
		}
		panelReception.repaint();
		panelReception.revalidate();
	}
	
	public void afficherAllCharcuteries(JPanel panelReception, int longueurMax) {
		
		panelReception.removeAll();
		
		ArrayList<Article> listArt = new ArrayList();
		listArt = (ArrayList<Article>) artDao.readCategorieCharcuteries();
		
		for(int i = 0; i < listArt.size(); i++) {
			panelReception.add(new PanelModelArticle(listArt.get(i), longueurMax));
			
		}
		panelReception.repaint();
		panelReception.revalidate();
	}
	
	
	
}

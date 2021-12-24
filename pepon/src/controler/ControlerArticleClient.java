package controler;

import model.PanelModelArticle;
import vue.PanelArticleSelectClient;

public class ControlerArticleClient {

	public void modifPanArticle(PanelArticleSelectClient panelArticle) {
		ArticleDao artDao = new ArticleDao();
		
		if(PanelModelArticle.modelIdArticle != 0) {
			artDao.readIdArticle(PanelModelArticle.modelIdArticle);
			
			panelArticle.setLabelNom(artDao.readIdArticle(PanelModelArticle.modelIdArticle).getNomArticle());
			panelArticle.setLabelNomCategorie(artDao.idCategorieToString(artDao.readIdArticle(PanelModelArticle.modelIdArticle).getIdCategorie()));
			panelArticle.setLabelNutripoint(artDao.readIdArticle(PanelModelArticle.modelIdArticle).getNutripoint());
			panelArticle.setLabelPrix(artDao.readIdArticle(PanelModelArticle.modelIdArticle).getPrix());
			
		}
		
	}
}

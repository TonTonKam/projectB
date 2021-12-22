package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ArticleDao;
import controller.ControllerClientArticle;
import vue.PanelArticleSelectClient;

public class PanelModelArticle extends JPanel {

	private JLabel labelImg, labelNomArticle, labelNutripoint, labelPrix,
		labelCategorie;
	private JButton btnConsulter;
	private ArticleDao artDao = new ArticleDao();
	
	/**
	 * Create the panel.
	 */
	public PanelModelArticle(Article article, JPanel panelRecep, PanelArticleSelectClient panelExpedition, int longueurM) {
		setBounds(longueurM / 4 + 10, 210, longueurM * 3 / 4 - 40, 100);
		
		labelImg = new JLabel("IMG");
		this.add(labelImg);
		
		labelNomArticle = new JLabel();
		labelNomArticle.setText(article.getNomArticle());
		add(labelNomArticle);
		
		labelNutripoint = new JLabel();
		labelNutripoint.setText(String.valueOf(article.getNutripoint() + " /100"));
		add(labelNutripoint);
		
		labelPrix = new JLabel();
		labelPrix.setText(String.valueOf(article.getPrix() + " €"));
		add(labelPrix);
		
		labelCategorie = new JLabel();
		labelCategorie.setText(artDao.idCategorieToString(article.getIdCategorie()));
		add(labelCategorie);
		
		//renvoie sur la page ArticleClient avec ses propres informations
		//le jpanel sur la quel est situer le modelArticle devient invisible
		//on repaint et valide le futur panel
		btnConsulter = new JButton("Detail");
		btnConsulter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelRecep.setVisible(false);
				panelExpedition.setVisible(true);
				VarStatic.IdArticleStatic = article.getIdArticle();
				
				ControllerClientArticle controlArt = new ControllerClientArticle();
				controlArt.modifPanArticle(panelExpedition);
			}
		});
		add(btnConsulter);
	}

}

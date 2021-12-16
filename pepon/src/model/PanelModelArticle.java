package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelModelArticle extends JPanel {

	private JLabel labelImg, labelNomArticle, labelNutripoint, labelPrix,
		labelCategorie;
	private JButton btnConsulter;
	
	/**
	 * Create the panel.
	 */
	public PanelModelArticle(Article article, int longueurM) {
		setBounds(longueurM / 4 + 10, 210, longueurM * 3 / 4 - 40, 100);
		
		labelImg = new JLabel("IMG");
		add(labelImg);
		
		labelNomArticle = new JLabel();
		labelNomArticle.setText(article.getNomArticle());
		add(labelNomArticle);
		
		labelNutripoint = new JLabel();
		labelNutripoint.setText(String.valueOf(article.getNutripoint()));
		add(labelNutripoint);
		
		labelPrix = new JLabel();
		labelPrix.setText(String.valueOf(article.getPrix()));
		add(labelPrix);
		
		labelCategorie = new JLabel();
		labelCategorie.setText(String.valueOf(article.getIdCategorie()));
		add(labelCategorie);
		
		btnConsulter = new JButton("Detail");
		btnConsulter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		add(btnConsulter);
	}

}

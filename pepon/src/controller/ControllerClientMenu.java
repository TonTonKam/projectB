package controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Article;
import model.Categorie;
import model.PanelModelArticle;
import vue.PanelClientAccueil;
import vue.PanelClientArticleSelect;

public class ControllerClientMenu {
	
	//attributs
	Connection connect = GetConnection.getConnectionWindows();
	//Connection connect = GetConnection.getConnectionMac();
	
	private ControllerClientAccueil controleAccueil;
	
	//lister des categories pour generer X boutons qui auront la quantite de categorie creer
	public List<Categorie>  listCategorie(){
		List<Categorie> listeCategorie = new ArrayList<>();
		
		try {
			PreparedStatement reqCategorie = connect.prepareStatement("SELECT * FROM categorie");
			
			ResultSet rsCategorie = reqCategorie.executeQuery();
			while(rsCategorie.next()) {
				//String nom_article, int nutripoint, double prix, int categorie
				Categorie categorie = new Categorie(rsCategorie.getInt("id_categorie"), rsCategorie.getString("libelle"));
				
				listeCategorie.add(categorie);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeCategorie;
	}
	
	//afficher une categorie uniquement
	public List<Article>  afficheArticlesDesCategories(int index){
		List<Article> listeArticle = new ArrayList<>();
		
		try {
			//if index == 0 afficher tout les produits sinon afficher la categorie associer
			if(index == 0) {
				PreparedStatement req = connect.prepareStatement("SELECT * FROM article ORDER BY id_categorie");
				
				ResultSet rs = req.executeQuery();
				while(rs.next()) {
					//String nom_article, int nutripoint, double prix, int categorie
					Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
	
					listeArticle.add(article);
				}
				
			}else {
				PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id_categorie = ?");
				
				req.setInt(1, index);
				ResultSet rs = req.executeQuery();
				while(rs.next()) {
					//String nom_article, int nutripoint, double prix, int categorie
					Article article = new Article(rs.getString("nom_article"),rs.getInt("nutripoint"),rs.getDouble("prix"),rs.getInt("id_categorie"),rs.getInt("id_article"));
					
					listeArticle.add(article);
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeArticle;
	}
	
	
	//generer des bouton en fonction de la categorie
	public JButton genererBoutonCategorie(PanelClientAccueil panelGeneral, PanelClientArticleSelect panelExpedition, int longueurM,JButton bouton, int ind) {
		//le boutton se creer X fois en fonction du nombre de categorie
		controleAccueil = new ControllerClientAccueil();
		/*
		 * - on entre dans une boucle qui va verifier chaque valeur de index
		 * - on ajoute +1 a la listCategorie.size() car 0 n'existe pas comme id_categorie et on a besoin qu'il prenne
		 * toutes les valeurs de id_categorie
		 */
		if(ind != 0) {
			bouton.setText(listCategorie().get(ind-1).getLibelle());
			bouton.setBounds(10, 10, 200 + (ind + 40), 45);
			bouton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//met dans le panel general tous les articles
					controleAccueil.afficherAllArticles(panelGeneral, panelExpedition, longueurM, ind);
					panelExpedition.setVisible(false);
					panelGeneral.setVisible(true);
				}
			});
			
			
			return bouton;
		}else {
			
			//si index == 0 alors je genere le ALL sinon 1 = id_categorie
			bouton.setText("toute les categories");
			bouton.setBounds(10, 10, 200 + (ind + 40), 45);
			bouton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//met dans le panel general tous les articles
					controleAccueil.afficherAllArticles(panelGeneral, panelExpedition, longueurM, ind);
					panelExpedition.setVisible(false);
					panelGeneral.setVisible(true);
				}
			});
			return bouton;
		}
	}
	
} //fin classe

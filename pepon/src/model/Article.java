package model;

public class Article {
	
	//attributs
	private String nom_article;
	private int nutripoint, categorie, id_article;
	private double prix;
	
	public Article(String nom_article, int nutripoint, double prix, int categorie) {
		this.nom_article = nom_article;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Article(String nom_article, int nutripoint, double prix, int categorie, int id_article) {
		super();
		this.nom_article = nom_article;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.categorie = categorie;
		this.id_article = id_article;
	}

	//getter
	public int getId_article() {
		return id_article;
	}

	public String getNom_article() {
		return nom_article;
	}

	public int getNutripoint() {
		return nutripoint;
	}

	public double getPrix() {
		return prix;
	}

	public int getCategorie() {
		return categorie;
	}

	public int getId_article() {
		return id_article;
	}

}

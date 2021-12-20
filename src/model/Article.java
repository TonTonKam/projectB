package model;

public class Article {

	
	private String nomArticle;
	private int nutripoint; 
	private double prix;
	private int categorie;
	private int idArticle;
	public Article(String nomArticle, int nutripoint, double prix, int categorie) {
		super();
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	
	public Article() {
		super();
	}


	public Article(String nomArticle, int nutripoint, double prix, int categorie, int idArticle) {
		super();
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.categorie = categorie;
		this.idArticle = idArticle;
	}


	
	
	public String getNomArticle() {
		return nomArticle;
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


	public int getIdArticle() {
		return idArticle;
	}

	
	
	
}

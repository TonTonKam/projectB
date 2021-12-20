package model;

public class Article {

	private String nomArticle;
	private int nutripoint; 
	private double prix;
	private int idCategorie;
	private int idArticle;
	
	public Article(String nomArticle, int nutripoint, double prix, int idCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.idCategorie = idCategorie;
	}
	
	
	public Article() {
		super();
	}


	public Article(String nomArticle, int nutripoint, double prix, int idCategorie, int idArticle) {
		super();
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.idCategorie = idCategorie;
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


	public int getIdCategorie() {
		return idCategorie;
	}


	public int getIdArticle() {
		return idArticle;
	}

	
	
	
}

package model;

public class Article {
	
	//attributs
	private String nomArticle;
	private int nutripoint, idCategorie, idArticle;
	private double prix;
	
	public Article(String nomArticle, int nutripoint, double prix, int idCategorie) {
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.idCategorie = idCategorie;
	}

	public Article(String nomArticle, int nutripoint, double prix, int idCategorie, int idArticle) {
		super();
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.idCategorie = idCategorie;
		this.idArticle = idArticle;
	}

	//getter
	public int getIdArticle() {
		return idArticle;
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

}

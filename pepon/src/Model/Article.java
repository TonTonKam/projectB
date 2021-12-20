package Model;

public class Article {

	
	private String nom_article;
	private int nutripoint; 
	private double prix;
	private int id_categorie;
	private int id_article;
	public Article(String nom_article, int nutripoint, double prix, int id_categorie) {
		super();
		this.nom_article = nom_article;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.id_categorie = id_categorie;
	}
	
	
	public Article() {
		super();
	}


	public Article(String nom_article, int nutripoint, double prix, int id_categorie, int id_article) {
		super();
		this.nom_article = nom_article;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.id_categorie = id_categorie;
		this.id_article = id_article;
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
		return id_categorie;
	}


	public int getId_article() {
		return id_article;
	}

	
	
	
}

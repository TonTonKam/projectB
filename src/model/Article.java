package model;

public class Article {

	
	private String nom_article;
	private int nutripoint; 
	private double prix;
	private int categorie;
	private int id_article;
	public Article(String nom_article, int nutripoint, double prix, int categorie) {
		super();
		this.nom_article = nom_article;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	
	public Article() {
		super();
	}


	public Article(String nom_article, int nutripoint, double prix, int categorie, int id_article) {
		super();
		this.nom_article = nom_article;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.categorie = categorie;
		this.id_article = id_article;
	}

	
	public Article(String nom_saisie, String nutripoint_saisie, String prix_saisie, String categorie_saisie) {
		// TODO Auto-generated constructor stub
	}


	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public int getNutripoint() {
		return nutripoint;
	}
	public void setNutripoint(int nutripoint) {
		this.nutripoint = nutripoint;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
	
	@Override
	public String toString() {
		return "Article [nom_article=" + nom_article + ", nutripoint=" + nutripoint + ", prix=" + prix
				+ ", categorie=" + categorie + "]";
	}
	
	
	
}

package model;

public class Article {
<<<<<<< HEAD
	
	//attributs
	private String nom_article;
	private int nutripoint, categorie, id_article;
	private double prix;
	
	//constructor
	public Article(String nom_article, int nutripoint, double prix, int categorie) {
=======

	
	private String nom_article;
	private int nutripoint; 
	private double prix;
	private int categorie;
	private int id_article;
	public Article(String nom_article, int nutripoint, double prix, int categorie) {
		super();
>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
		this.nom_article = nom_article;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.categorie = categorie;
	}
<<<<<<< HEAD

	public Article(String nom_article, int nutripoint, double prix, int categorie, int id_article) {
=======
	
	
	public Article() {
		super();
	}


	public Article(String nom_article, int nutripoint, double prix, int categorie, int id_article) {
		super();
>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
		this.nom_article = nom_article;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.categorie = categorie;
		this.id_article = id_article;
	}

<<<<<<< HEAD
	//getter
	public int getId_article() {
		return id_article;
	}

=======

	
	
>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public String getNom_article() {
		return nom_article;
	}

<<<<<<< HEAD
=======

>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public int getNutripoint() {
		return nutripoint;
	}

<<<<<<< HEAD
=======

>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public double getPrix() {
		return prix;
	}

<<<<<<< HEAD
=======

>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public int getCategorie() {
		return categorie;
	}

<<<<<<< HEAD
=======

	public int getId_article() {
		return id_article;
	}

	
	
	
>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
}

package Model;

public class Article {
	
	//attributs
	private String nomArticle, nomCategorie;
	private int nutripoint, idCategorie, idArticle;
	private double prix;
<<<<<<< HEAD:pepon/src/Model/Article.java
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
=======
	
	//constructor
	public Article(String nomArticle, int nutripoint, double prix, int idCategorie) {
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.idCategorie = idCategorie;
	}

	public Article(String nomArticle, int nutripoint, double prix, int idCategorie, int idArticle) {
>>>>>>> origin/yannK:pepon/src/model/Article.java
		super();
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
<<<<<<< HEAD:pepon/src/Model/Article.java
		this.id_categorie = id_categorie;
		this.id_article = id_article;
=======
		this.idCategorie = idCategorie;
		this.idArticle = idArticle;
>>>>>>> origin/yannK:pepon/src/model/Article.java
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

<<<<<<< HEAD:pepon/src/Model/Article.java

	public int getCategorie() {
		return id_categorie;
=======
	public int getIdCategorie() {
		return idCategorie;
>>>>>>> origin/yannK:pepon/src/model/Article.java
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

}

package model;

public class Article {
<<<<<<< HEAD

	private String nomArticle;
	private int nutripoint; 
	private double prix;
	private int idCategorie;
	private int idArticle;
	
	public Article(String nomArticle, int nutripoint, double prix, int idCategorie) {
		super();
=======
	
	//attributs
	private String nomArticle, nomCategorie;
	private int nutripoint, idCategorie, idArticle;
	private double prix;
	
	//constructor
	public Article(String nomArticle, int nutripoint, double prix, int idCategorie) {
>>>>>>> origin/yannK
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.idCategorie = idCategorie;
<<<<<<< HEAD
	}
	
	
	public Article() {
		super();
	}


=======
	}

>>>>>>> origin/yannK
	public Article(String nomArticle, int nutripoint, double prix, int idCategorie, int idArticle) {
		super();
		this.nomArticle = nomArticle;
		this.nutripoint = nutripoint;
		this.prix = prix;
		this.idCategorie = idCategorie;
		this.idArticle = idArticle;
	}

<<<<<<< HEAD

	
	
	public String getNomArticle() {
		return nomArticle;
=======
	//getter
	public int getIdArticle() {
		return idArticle;
>>>>>>> origin/yannK
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

<<<<<<< HEAD

=======
>>>>>>> origin/yannK
	public int getIdCategorie() {
		return idCategorie;
	}

<<<<<<< HEAD

	public int getIdArticle() {
		return idArticle;
=======
	public String getNomCategorie() {
		return nomCategorie;
>>>>>>> origin/yannK
	}

}

package model;

public class Article {
private String designation;
private int stock;
private double prix;
private int idArticle;
public Article(String designation, int stock, double prix, int idArticle) {
	super();
	this.designation = designation;
	this.stock = stock;
	this.prix = prix;
	this.idArticle = idArticle;
}
public String getDesignation() {
	return designation;
}
public int getStock() {
	return stock;
}
public double getPrix() {
	return prix;
}
public int getIdArticle() {
	return idArticle;
}



}

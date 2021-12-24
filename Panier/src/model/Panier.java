package model;

import java.util.List;

public class Panier {

	private int idPanier;
	private int idUser;
	private double total;
	private int idArticle;
	public Panier(int idPanier, int idUser, double total,int idArticle) {
		//List<Article> basket ? comment intégrer des listes en base de données
		super();
		this.idPanier = idPanier;
		this.idUser = idUser;
		this.total = total;
		this.idArticle = idArticle;
	}
	
	
	
	public Panier(int idPanier, double total) {
		super();
		this.idPanier = idPanier;
		this.total = total;
	}



	public int getIdPanier() {
		return idPanier;
	}
	public int getIdUser() {
		return idUser;
	}
	public double getTotal() {
		return total;
	}
	public int getIdArticle() {
		return idArticle;
	}
	
	
}

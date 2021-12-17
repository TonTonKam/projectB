package model;

public class User {

	private String nom;
	private String prenom;
	private String email;
	private String motPasse;
	private String statut;
	private int idUser;
	
	public User(String nom, String prenom, String email, String motPasse, String statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = motPasse;
		this.statut = statut;
	}

	
	public User(String nom, String prenom, String email, String motPasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = motPasse;
	}


	public User(String nom, String prenom, String email, String mot_passe, String statut, int id_user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = mot_passe;
		this.statut = statut;
		this.idUser = id_user;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getEmail() {
		return email;
	}


	public String getMotPasse() {
		return motPasse;
	}


	public String getStatut() {
		return statut;
	}


	public int getIdUser() {
		return idUser;
	}




	
	
}

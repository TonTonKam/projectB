package model;

public class User {

	private String nom;
	private String prenom;
	private String email;
	private String motPasse;
	private int idStatut;
	private int idUser;
	
	public User(String nom, String prenom, String email, String motPasse, int idStatut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = motPasse;
		this.idStatut = idStatut;
	}

	
	public User(String nom, String prenom, String email, String motPasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = motPasse;
	}


	public User(String nom, String prenom, String email, String mot_passe, int id_statut, int id_user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = mot_passe;
		this.idStatut = id_statut;
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


	public int getId_statut() {
		return idStatut;
	}


	public int getId_user() {
		return idUser;
	}
	
	
	
}

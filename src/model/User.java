package model;

public class User {

	private String nom;
	private String prenom;
	private String email;
	private String mot_passe;
	private int id_statut;
	private  int id_user;
	
	public User(String nom, String prenom, String email, String mot_passe, int id_statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
		this.id_statut = id_statut;
	}

	
	public User(String nom, String prenom, String email, String mot_passe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
	}


	public User(String nom, String prenom, String email, String mot_passe, int id_statut, int id_user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
		this.id_statut = id_statut;
		this.id_user = id_user;
	}



	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_passe() {
		return mot_passe;
	}

	public void setMot_passe(String mot_passe) {
		this.mot_passe = mot_passe;
	}

	public int getId_statut() {
		return id_statut;
	}

	public void setId_statut(int id_statut) {
		this.id_statut = id_statut;
	}

	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mot_passe=" + mot_passe
				+ ", id_statut=" + id_statut + "]";
	} 
	
	
	
}

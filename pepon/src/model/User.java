package model;

public class User {

<<<<<<< HEAD
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
=======
	//attibuts
	private String nom,	prenom, email, mot_passe;
	private int id_statut, id_user;
	
	//constructor
	public User(String nom, String prenom, String email, String mot_passe) {
>>>>>>> origin/yannK
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = motPasse;
	}

	public User(String nom, String prenom, String email, String mot_passe, int id_statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
		this.id_statut = id_statut;
	}

	public User(String nom, String prenom, String email, String motPasse, int idStatut, int idUser) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = motPasse;
		this.idStatut = idStatut;
		this.idUser = idUser;
	}

<<<<<<< HEAD
=======
	//getter
	public int getId_user() {
		return id_user;
	}
>>>>>>> origin/yannK

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

<<<<<<< HEAD

	public String getMotPasse() {
		return motPasse;
	}


	public int getIdStatut() {
		return idStatut;
	}


	public int getIdUser() {
		return idUser;
	}




	
=======
	public String getMot_passe() {
		return mot_passe;
	}

	public int getId_statut() {
		return id_statut;
	}
>>>>>>> origin/yannK
	
}

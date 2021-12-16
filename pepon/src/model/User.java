package model;

public class User {

<<<<<<< HEAD
	//attibuts
	private String nom,	prenom, email, mot_passe;
	private int id_statut, id_user;
	
	//constructor
	public User(String nom, String prenom, String email, String mot_passe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
	}

=======
	private String nom;
	private String prenom;
	private String email;
	private String mot_passe;
	private int id_statut;
	private  int id_user;
	
>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public User(String nom, String prenom, String email, String mot_passe, int id_statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
		this.id_statut = id_statut;
	}
<<<<<<< HEAD
	
=======

	
	public User(String nom, String prenom, String email, String mot_passe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
	}


>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public User(String nom, String prenom, String email, String mot_passe, int id_statut, int id_user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
		this.id_statut = id_statut;
		this.id_user = id_user;
	}

<<<<<<< HEAD
	//getter
	public int getId_user() {
		return id_user;
	}
=======



>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01

	public String getNom() {
		return nom;
	}

<<<<<<< HEAD
=======

>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public String getPrenom() {
		return prenom;
	}

<<<<<<< HEAD
=======

>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public String getEmail() {
		return email;
	}

<<<<<<< HEAD
=======

>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public String getMot_passe() {
		return mot_passe;
	}

<<<<<<< HEAD
=======

>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
	public int getId_statut() {
		return id_statut;
	}

<<<<<<< HEAD
=======

	public int getId_user() {
		return id_user;
	}
	
	
	
>>>>>>> 6d7319baf082b906d212f196d4edad7b79fbdf01
}

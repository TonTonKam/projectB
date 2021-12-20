package Model;

public class User {
<<<<<<< HEAD:pepon/src/Model/User.java
	
	private  int id_user;
	private String nom;
	private String prenom;
	private String email;
	private String mot_passe;
	private Object statut;
	
	
	public User(String nom, String prenom, String email, String mot_passe, Object statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
		this.statut = statut;
	}

=======

	//attibuts
	private String nom,	prenom, email, mot_passe;
	private int id_statut, id_user;
>>>>>>> origin/yannK:pepon/src/model/User.java
	
	//constructor
	public User(String nom, String prenom, String email, String mot_passe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
	}

	public User(String nom, String prenom, String email, String mot_passe, int id_statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
		this.id_statut = id_statut;
	}

	public User(String nom, String prenom, String email, String mot_passe, Object statut, int id_user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
		this.statut = statut;
		this.id_user = id_user;
	}

<<<<<<< HEAD:pepon/src/Model/User.java
=======
	//getter
	public int getId_user() {
		return id_user;
	}
>>>>>>> origin/yannK:pepon/src/model/User.java

	public String getNom() {
		return nom;
	}

<<<<<<< HEAD:pepon/src/Model/User.java

	public void setNom(String nom) {
		this.nom = nom;
	}


=======
>>>>>>> origin/yannK:pepon/src/model/User.java
	public String getPrenom() {
		return prenom;
	}

<<<<<<< HEAD:pepon/src/Model/User.java

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


=======
>>>>>>> origin/yannK:pepon/src/model/User.java
	public String getEmail() {
		return email;
	}

<<<<<<< HEAD:pepon/src/Model/User.java

	public void setEmail(String email) {
		this.email = email;
	}


=======
>>>>>>> origin/yannK:pepon/src/model/User.java
	public String getMot_passe() {
		return mot_passe;
	}

<<<<<<< HEAD:pepon/src/Model/User.java

	public void setMot_passe(String mot_passe) {
		this.mot_passe = mot_passe;
	}


	public Object getStatut() {
		return statut;
	}


	public void setStatut(Object statut) {
		this.statut = statut;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


=======
	public int getId_statut() {
		return id_statut;
	}
	
>>>>>>> origin/yannK:pepon/src/model/User.java
}

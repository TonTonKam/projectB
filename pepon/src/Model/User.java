package Model;

public class User {
	
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

	
	public User(String nom, String prenom, String email, String mot_passe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_passe = mot_passe;
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


}

package application;

public class Personne {
	private String prenom;
	private String nom;
	private String numeroTelephone;
	
	public Personne(String prenom, String nom, String numeroTelephone) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numeroTelephone = numeroTelephone;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
}

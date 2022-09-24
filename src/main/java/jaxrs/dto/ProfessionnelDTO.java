package jaxrs.dto;

public class ProfessionnelDTO {
	
	String Nom;
	String mail;
	String tel;
	String Matiere;
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMatiere() {
		return Matiere;
	}
	public void setMatiere(String matiere) {
		Matiere = matiere;
	}
	
	
	
}

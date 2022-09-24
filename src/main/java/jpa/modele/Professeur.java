package jpa.modele;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("professeur")
public class Professeur extends Professionnel{
	
	String Nom;
	String mail;
	String tel;
	List<RDV> ListeRDV;
	String Matiere;
	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Professeur(String nom, String mail, String tel,String matiere) {
		super(nom, mail, tel);
		this.Matiere = matiere;
		// TODO Auto-generated constructor stub
	}
	
	
	public String getMatiere() {
		return Matiere;
	}
	public void setMatiere(String matiere) {
		Matiere = matiere;
	}
	
	

}

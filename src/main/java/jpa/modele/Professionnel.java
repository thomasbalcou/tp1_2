package jpa.modele;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Professionnel implements Serializable{

		
		String Nom;
		String mail;
		String tel;
		List<RDV> ListeRDV;
		
		
		public Professionnel() {
		}

		public Professionnel(String nom, String mail, String tel) {
			this.Nom = nom;
			this.mail = mail;
			this.tel = tel;
		}
		
		public String getNom() {
			return Nom;
		}
		public void setNom(String nom) {
			Nom = nom;
		}
		
		@Id
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
		
		@JsonIgnore
		@OneToMany(mappedBy = "pro",cascade = CascadeType.PERSIST)
		public List<RDV> getListeRDV() {
			return ListeRDV;
		}
		public void setListeRDV(List<RDV> listeRDV) {
			ListeRDV = listeRDV;
		}
		

}

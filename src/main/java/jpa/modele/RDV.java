package jpa.modele;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class RDV implements Serializable{
	
	long id;
	String intitule;
	int duree;
	Date date = new Date();
	Professionnel pro;
	Utilisateur user;
	
	
	
	
	public RDV() {
	}

	public RDV(String intitule, int duree, Date date, Professionnel pro, Utilisateur user) {
		this.intitule = intitule;
		this.duree = duree;
		this.date = date;
		this.pro = pro;
		this.user = user;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne
	public Professionnel getPro() {
		return pro;
	}
	public void setPro(Professionnel pro) {
		this.pro = pro;
	}
	
	@ManyToOne
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
}

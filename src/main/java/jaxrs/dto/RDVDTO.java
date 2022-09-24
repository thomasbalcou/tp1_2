package jaxrs.dto;

import java.util.Date;

import jpa.modele.Professionnel;
import jpa.modele.Utilisateur;

public class RDVDTO {
	
	long id;
	String intitule;
	int duree;
	Date date = new Date();
	Professionnel pro;
	Utilisateur user;
	
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
	public Professionnel getPro() {
		return pro;
	}
	public void setPro(Professionnel pro) {
		this.pro = pro;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	

}

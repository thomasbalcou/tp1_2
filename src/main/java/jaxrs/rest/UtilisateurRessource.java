package jaxrs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import dao.*;
import io.swagger.v3.oas.models.tags.Tag;
import jaxrs.dto.*;
import jpa.modele.Professionnel;
import jpa.modele.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

@Path("utilisateur")
public class UtilisateurRessource {
	UtilisateurDao utilisateurdao;
	 
	 public UtilisateurRessource() {
		 
		 this.utilisateurdao = new UtilisateurDao();
	 }

	  @GET
	  @Path("/all")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<UtilisateurDTO> getAllUSer()  {
		  List<Utilisateur> utilisateurs = this.utilisateurdao.findAll();
		  List<UtilisateurDTO> dto = new ArrayList<UtilisateurDTO>();
		  for (Utilisateur u: utilisateurs) {
			  UtilisateurDTO userdto=new UtilisateurDTO();
			  userdto.setMail(u.getMail());
			  userdto.setNom(u.getNom());
			  userdto.setTel(u.getTel());
			  dto.add(userdto);
		}
	      return dto;
	  }
	  
	  @GET
	  @Path("/{mail}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public UtilisateurDTO getOneUser(@PathParam("mail") String mail)  {
		  Utilisateur u=this.utilisateurdao.getUserInfoMail(mail);
		  UtilisateurDTO userdto=new UtilisateurDTO();
	     userdto.setMail(u.getMail());
		 userdto.setNom(u.getNom());
		 userdto.setTel(u.getTel());
		 return userdto;
	  }
	  
	  @POST
	  @Path("/nouveau")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public UtilisateurDTO createUser(Utilisateur user) {
		 this.utilisateurdao.save(user);
		 Utilisateur u=this.utilisateurdao.getUserInfoMail(user.getMail());
		 UtilisateurDTO userdto=new UtilisateurDTO();
	     userdto.setMail(u.getMail());
		 userdto.setNom(u.getNom());
		 userdto.setTel(u.getTel());
		 return userdto;
	  }
	  
	  @POST
	  @Path("/delete")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public void deleteUser(Utilisateur user) {
		  this.utilisateurdao.delete(user);
	  }

}
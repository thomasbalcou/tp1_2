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

import dao.ProfessionnelDao;
import io.swagger.v3.oas.models.tags.Tag;
import jaxrs.dto.*;
import jpa.modele.Professionnel;
import io.swagger.v3.oas.annotations.Parameter;

@Path("professionnel")
public class ProfessionnelRessource {
	ProfessionnelDao professionneldao;
	 
	 public ProfessionnelRessource() {
		 
		 this.professionneldao = new ProfessionnelDao();
	 }

	  @GET
	  @Path("/all")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<ProfessionnelDTO> getAllPro()  {
		  List<Professionnel> professionnels = this.professionneldao.findAll();
		  List<ProfessionnelDTO> dto = new ArrayList<ProfessionnelDTO>();
		  for (Professionnel p: professionnels) {
			  ProfessionnelDTO prodto=new ProfessionnelDTO();
			  prodto.setMail(p.getMail());
			  prodto.setNom(p.getNom());
			  prodto.setTel(p.getTel());
			  dto.add(prodto);
		}
	      return dto;
	  }
	  
	  @GET
	  @Path("/{mail}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public ProfessionnelDTO getOnePro(@PathParam("mail") String mail)  {
	     Professionnel p=this.professionneldao.getProInfoMail(mail);
	     ProfessionnelDTO prodto=new ProfessionnelDTO();
	     prodto.setMail(p.getMail());
		 prodto.setNom(p.getNom());
		 prodto.setTel(p.getTel());
		 return prodto;
	  }
	  
	  @POST
	  @Path("/nouveau")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public ProfessionnelDTO createPro(Professionnel pro) {
		 this.professionneldao.save(pro);
		 Professionnel p=this.professionneldao.getProInfoMail(pro.getMail());
	     ProfessionnelDTO prodto=new ProfessionnelDTO();
	     prodto.setMail(p.getMail());
		 prodto.setNom(p.getNom());
		 prodto.setTel(p.getTel());
		 return prodto;
	  }
	  
	  @POST
	  @Path("/delete")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public void deletePro(Professionnel pro) {
		  this.professionneldao.delete(pro);
	  }


}

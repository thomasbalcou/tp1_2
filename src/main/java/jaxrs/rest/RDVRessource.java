package jaxrs.rest;

import java.util.ArrayList;
import java.util.Date;
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
import jpa.modele.*;
import io.swagger.v3.oas.annotations.Parameter;

@Path("RDV")
public class RDVRessource {
	RDVDao RDVdao;
	 
	 public RDVRessource() {
		 
		 this.RDVdao = new RDVDao();
	 }

	  @GET
	  @Path("/all")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<RDVDTO> getAllPro()  {
		  List<RDV> rdvs = this.RDVdao.findAll();
		  List<RDVDTO> dto = new ArrayList<RDVDTO>();
		  for (RDV r: rdvs) {
			  RDVDTO rdvdto=new RDVDTO();
			  rdvdto.setId(r.getId());
			  rdvdto.setIntitule(r.getIntitule());
			  rdvdto.setDuree(r.getDuree());
			  rdvdto.setDate(r.getDate());
			  rdvdto.setPro(r.getPro());
			  rdvdto.setUser(r.getUser());
			  dto.add(rdvdto);
		}
	      return dto;
	  }
	  
	  @GET
	  @Path("/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public RDVDTO getOneRdv(@PathParam("id") Long id)  {
	     RDV r=this.RDVdao.findOne(id);
	     RDVDTO rdvdto=new RDVDTO();
	     rdvdto.setId(r.getId());
		  rdvdto.setIntitule(r.getIntitule());
		  rdvdto.setDuree(r.getDuree());
		  rdvdto.setDate(r.getDate());
		  rdvdto.setPro(r.getPro());
		  rdvdto.setUser(r.getUser());
		 return rdvdto;
	  }
	  
	  @POST
	  @Path("/nouveau")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public RDVDTO createRdv(RDV rdv) {
		 this.RDVdao.save(rdv);
		 RDVDTO rdvdto=new RDVDTO();
		 RDV r=this.RDVdao.findOne(rdv.getId());
		 rdvdto.setId(r.getId());
		  rdvdto.setIntitule(r.getIntitule());
		  rdvdto.setDuree(r.getDuree());
		  rdvdto.setDate(r.getDate());
		  rdvdto.setPro(r.getPro());
		  rdvdto.setUser(r.getUser());
		 return rdvdto;
	  }
	  
	  @POST
	  @Path("/delete")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public void deleteRDV(RDV rdv) {
		  this.RDVdao.delete(rdv);
	  }

}
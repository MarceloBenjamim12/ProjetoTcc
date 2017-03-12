package br.com.socialFitness.rest;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.socialFitness.dao.SessionManager;
import br.com.socialFitness.entidades.Nutricionista;
import br.com.socialFitness.entidades.Personal;
import br.com.socialFitness.entidades.Usuario;
import br.com.socialFitness.rest.util.RESTService;
import br.com.socialFitness.service.NutricionistaBusiness;

@Path("/Nutricionista")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class NutricionistraREST {
	
	@Autowired
	NutricionistaBusiness business;
	
	private SessionManager session;
	
	public NutricionistraREST(){
		this.session = SessionManager.getInstance();
	    this.session.getEntityManager().clear();
	    business = new NutricionistaBusiness(this.session);
	}
	
	@GET
	public GenericEntity<List<Nutricionista>> listar(){
		return new GenericEntity<List<Nutricionista>>(this.business.listar()){};
	}
	
	@GET
	@Path("/{nome}")
	public GenericEntity<List<Nutricionista>> listByName(@PathParam("nome") String nome){
		return new GenericEntity<List<Nutricionista>>(this.business.listByName(nome)){};
	}

}

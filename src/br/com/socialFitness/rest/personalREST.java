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
import br.com.socialFitness.service.PersonalBusiness;


/**
 * Publicando metodos de negocio via REST
 * @generated
 **/
@Path("/personal")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class personalREST implements RESTService<Personal> {

	@Autowired
	PersonalBusiness business;
	
	private SessionManager session;
	
	public personalREST(){
		this.session = SessionManager.getInstance();
	    this.session.getEntityManager().clear();
	    business = new PersonalBusiness(this.session);
	}
	
	@GET
	public GenericEntity<List<Personal>> listar(){
		return new GenericEntity<List<Personal>>(this.business.listar()){};
	}
	
	@GET
	@Path("/{nome}")
	public GenericEntity<List<Personal>> listByName(@PathParam("nome") String nome){
		return new GenericEntity<List<Personal>>(this.business.listByName(nome)){};
	}
	
}

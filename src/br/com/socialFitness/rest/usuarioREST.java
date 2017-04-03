package br.com.socialFitness.rest;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.socialFitness.dao.SessionManager;
import br.com.socialFitness.entidades.Usuario;
import br.com.socialFitness.rest.util.RESTService;
import br.com.socialFitness.service.UsuarioBusiness;


/**
 * Publicando metodos de negocio via REST
 * @generated
 **/
@Path("/usuario")
@Produces("text/plain")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class usuarioREST implements RESTService<Usuario>{
	
	@Autowired
	UsuarioBusiness business;
	
	private SessionManager session;
	
	public usuarioREST(){
		this.session = SessionManager.getInstance();
	    this.session.getEntityManager().clear();
	    business = new UsuarioBusiness(this.session);
	}
	
	@GET
	@Path("/{user}/{senha}")
	public Usuario Autentica(@PathParam("user") String user,@PathParam("senha") String senha){
		return business.Autentica(user, senha);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON/* , MediaType.APPLICATION_XML */ })
	@Path("/salvar")
	public void Salvar(Usuario usuario){
		
		
		this.session.begin();
		
		//Usuario usu = business.buscaPorId(usuario.getId());
		
		//usu = usuario;
		
		business.Salvar(usuario);
		
		this.session.commit();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON/* , MediaType.APPLICATION_XML */ })
	@Path("/alteraObj/{id}/{obj}")
	public void alteraObj(@PathParam("id") int id, @PathParam("obj") String obj){
		
		
		this.session.begin();
		
		Usuario usu = business.BuscarPorId(id);
		
		usu.setObjetivo(obj);
		
		business.Salvar(usu);
		
		this.session.commit();
	}
	
}

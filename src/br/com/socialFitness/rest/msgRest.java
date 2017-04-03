package br.com.socialFitness.rest;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.socialFitness.dao.MsgDAO;
import br.com.socialFitness.dao.SessionManager;
import br.com.socialFitness.entidades.Msg;
import br.com.socialFitness.entidades.Usuario;
import br.com.socialFitness.service.MsgBusiness;
import br.com.socialFitness.service.UsuarioBusiness;

@Path("/Msg")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class msgRest {
	
	@Autowired
	MsgBusiness business;
	
	private SessionManager session;
	
	public msgRest(){
		this.session = SessionManager.getInstance();
	    this.session.getEntityManager().clear();
	    business = new MsgBusiness(this.session);
	}
	
	@GET
	@Path("/listaByReceiverSend/{idUser}/{idOther}")
	public List<Msg> listaByReceiverSend(@PathParam("idUser") int idUser, @PathParam("idOther") int idOther){
		return business.listaByReceiverSend(idUser, idOther);
	}
	
	@POST
	public void salvar(Msg msg){
		
		session.begin();
		business.Salvar(msg);
		session.commit();
	}

}

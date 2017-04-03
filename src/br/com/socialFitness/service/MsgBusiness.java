package br.com.socialFitness.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.socialFitness.dao.MsgDAO;
import br.com.socialFitness.dao.SessionManager;
import br.com.socialFitness.dao.UsuarioDAO;
import br.com.socialFitness.entidades.ClienteNutri;
import br.com.socialFitness.entidades.Msg;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgBusiness {
	
	@Autowired
	MsgDAO dao;
EntityManager em;
	
	SessionManager session;
	
	public MsgBusiness(SessionManager session){
		this.session = session;
		dao = new MsgDAO(session.getInstance().getEntityManager());
	}
	
	public Msg Salvar(Msg msg){
		return dao.salvar(msg);
	}
	
	public void excluir(Msg msg){
		try{
			dao.delete(msg);
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<Msg> listar(){
		return dao.lista();
	}
	
	public List<Msg> listaByReceiver(int id){
		return dao.listaByReceiver(id);
	}
	
	public List<Msg> listaBySend(int id){
		return dao.listaBySend(id);
	}
	
	public List<Msg> listaByReceiverSend(int idUser, int idOther){
		return dao.listaByReceiverSend(idUser, idOther);
	}

}

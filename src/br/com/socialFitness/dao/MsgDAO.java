package br.com.socialFitness.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import br.com.socialFitness.entidades.Msg;
import br.com.socialFitness.entidades.Usuario;

import javax.persistence.*;

@Repository
public class MsgDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public MsgDAO(EntityManager em){
		this.em = em;
	}
	
	public MsgDAO(){
		
	}
	
	@Transactional
	public Msg salvar(Msg msg){
		em.persist(msg);
		return msg;
	}
	
	@Transactional
	public void delete(Msg msg){
		em.remove(msg);
	}
	
	@Transactional
	public List<Msg> lista(){
		Query q = em.createQuery("select m from Msg m");
		List<Msg> listaMsg = q.getResultList();
		return listaMsg;
	}
	
	@Transactional
	public List<Msg> listaBySend(int id){
		Query q = em.createQuery("select m from Msg m where msgEnv :id");
		q.setParameter("id", id);
		
		List<Msg> listaMsg = q.getResultList();
		return listaMsg;
	}
	
	@Transactional
	public List<Msg> listaByReceiver(int id){
		Query q = em.createQuery("select m from Msg m where msgReceb :id");
		q.setParameter("id", id);
		
		List<Msg> listaMsg = q.getResultList();
		return listaMsg;		
	}
	
	@Transactional
	public List<Msg> listaByReceiverSend(int idUser, int idOther){
		
		UsuarioDAO usuDao = new UsuarioDAO(em);
		Usuario usu = usuDao.BuscarPorId(idUser);
		
		Query q = em.createQuery("select m from Msg m where (m.msgEnv.id = :idUser or m.msgReceb.id = :idUser) AND (m.msgEnv.id = :idOther or m.msgReceb.id = :idOther)");
		q.setParameter("idUser", idUser);
		q.setParameter("idOther", idOther);
		
		List<Msg> msgLista = q.getResultList();
		
		return msgLista;
	}
}

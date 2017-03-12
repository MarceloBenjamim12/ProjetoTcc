package br.com.socialFitness.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import br.com.socialFitness.entidades.Msg;
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
		Msg m = em.merge(msg);
		return m;
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

}

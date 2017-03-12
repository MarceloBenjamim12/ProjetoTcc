package br.com.socialFitness.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import br.com.socialFitness.entidades.Plano;
import javax.persistence.*;
@Repository
public class PlanoDAO {

	@PersistenceContext
	EntityManager em;
	
	public PlanoDAO(EntityManager em){
		this.em = em;
	}
	
	public PlanoDAO(){
		
	}
	
	@Transactional
	public Plano salvar(Plano plano){
		Plano p = em.merge(plano);
		return p;
	}
	
	@Transactional
	public void delete(Plano plano){
		em.remove(plano);
	}
	
	public List<Plano> lista(){
		Query q = em.createQuery("Select p from Plano p");
		return q.getResultList();
	}
	
	public Plano buscarPorID(int id){
		return em.find(Plano.class, id);
	}
	
	
}

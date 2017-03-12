package br.com.socialFitness.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import br.com.socialFitness.entidades.Personal;
import javax.persistence.*;


@Repository
public class PersonalDAO implements Serializable {

	@PersistenceContext
	EntityManager em;
	
	public PersonalDAO(EntityManager em){
		this.em = em;
	}
	
	public PersonalDAO(){
		
	}
	
	@Transactional
	public Personal salvar(Personal personal){
		Personal p = em.merge(personal);
		return p;
	}
	
	@Transactional
	public void delete(Personal personal){
		em.remove(personal);
	}
	
	@Transactional
	public List<Personal> list(){
		Query q = em.createQuery("select p from Personal p");
		List<Personal> lista = q.getResultList();
		return lista;
	}
	
	@Transactional
	public List<Personal> listByID(int id){
		Query q = em.createQuery("select p from Personal p where id = :id");
		q.setParameter("id", id);
		List<Personal> lista = q.getResultList();
		return lista;
	}
	
	@Transactional
	public List<Personal> listByName(String nome){
		Query q = em.createQuery("select p from Personal p where p.UserID.nome = :nome");
		q.setParameter("nome", nome);
		List<Personal> lista = q.getResultList();
		return lista;
	}
	
	@Transactional
	public List<Personal> listByUser(String nome){
		Query q = em.createQuery("select p from Personal p where p.UserID.nome = :nome");
		q.setParameter("id", nome);
		List<Personal> lista = q.getResultList();
		return lista;
	}
	
}

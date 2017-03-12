package br.com.socialFitness.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.socialFitness.entidades.Nutricionista;
import br.com.socialFitness.entidades.Personal;

import javax.persistence.*;

@Repository
public class NutricionistaDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public NutricionistaDAO(EntityManager em){
		this.em = em;
	}
	
	public NutricionistaDAO(){
		
	}
	
	public Nutricionista salvar(Nutricionista nutricionista){
		Nutricionista nutri = em.merge(nutricionista);
		return nutri;
	}
	
	public void delete(Nutricionista nutricionista){
		em.remove("Nutricionista");
	}
	
	public List<Nutricionista> lista(){
		Query q = em.createQuery("Select N from Nutricionista N");
		List<Nutricionista> lista = q.getResultList();
		
		return lista;
	}
	
	public Nutricionista buscarPorId(int id){
		Query q = em.createQuery("Select u from Nutricionista N where id = :id");
		q.setParameter("id", id);
		
		Nutricionista nutricionista = (Nutricionista) q.getSingleResult();
		
		return nutricionista;
		
	}
	
	public List<Nutricionista> listaPorEspec(String espec){
		Query q = em.createQuery("Select N from Nutricionista N where espec= :espec");
		q.setParameter("espec", espec);
		
		List<Nutricionista> lista = q.getResultList();
		
		return lista;
	}
	
	@Transactional
	public List<Nutricionista> listByName(String nome){
		Query q = em.createQuery("select p from Nutricionista p where p.UserID.nome = :nome");
		q.setParameter("nome", nome);
		List<Nutricionista> lista = q.getResultList();
		return lista;
	}

}

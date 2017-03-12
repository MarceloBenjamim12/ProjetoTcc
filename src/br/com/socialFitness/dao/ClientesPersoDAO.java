package br.com.socialFitness.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import br.com.socialFitness.entidades.ClientesPerso;
import javax.persistence.*;

@Repository
public class ClientesPersoDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public ClientesPersoDAO(EntityManager em){
		this.em = em;
	}
	
	public ClientesPersoDAO(){
	}
	
	public ClientesPerso salvar(ClientesPerso clientePerso){
		ClientesPerso c = em.merge(clientePerso);
		return c;
	}
	
	public void delete(ClientesPerso clientePerso){
		em.remove(clientePerso);
	}
	
	public List<ClientesPerso> lista(){
		Query q = em.createQuery("select c from ClientesPerso");
		List<ClientesPerso> listaClientePerso = q.getResultList();
		return listaClientePerso;
	}
	
	public List<ClientesPerso> listaByPersonal(int id){
		Query q = em.createQuery("select c from ClientesPerso where prof = :id");
		q.setParameter("id", id);
		
		List<ClientesPerso> listaClientePerso = q.getResultList();
		return listaClientePerso;
	}
	
	public List<ClientesPerso> listaByCliente(int id){
		Query q = em.createQuery("select c from ClientesPerso where cliente = :id");
		q.setParameter("id", id);
		
		List<ClientesPerso> listaClientePerso = q.getResultList();
		return listaClientePerso;
	}

}

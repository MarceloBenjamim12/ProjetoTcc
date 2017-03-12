package br.com.socialFitness.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

import br.com.socialFitness.entidades.ClienteNutri;
import br.com.socialFitness.entidades.Plano;
import br.com.socialFitness.entidades.Usuario;
import javax.persistence.*;

@Repository
public class ClienteNutriDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public ClienteNutriDAO(EntityManager em){
		this.em = em;
	}
	
	public ClienteNutriDAO(){
		
	}
	
	@Transactional
	public ClienteNutri salvar(ClienteNutri clienteNutri){
		ClienteNutri c = em.merge(clienteNutri);
		return c;
	}
	
	@Transactional
	public void delete(ClienteNutri clienteNutri){
		em.remove(clienteNutri);
	}
	
	public List<ClienteNutri> lista(){
		Query q = em.createQuery("select c from ClienteNutri c");
		List<ClienteNutri> listaClienteNutri = q.getResultList();
		return listaClienteNutri;
	}
	
	public List<ClienteNutri> listaPorCliente(int id){
		Query q = em.createQuery("select c from ClienteNutri c where cliente :id");
		q.setParameter("id", id);
		
		List<ClienteNutri> listaClienteNutri= q.getResultList();
		return listaClienteNutri;
	}
	
	public List<ClienteNutri> listaPorNutri(int id){
		Query q = em.createQuery("select c from ClienteNutri c where prof :id");
		q.setParameter("id", id);
		
		List<ClienteNutri> listaClienteNutri= q.getResultList();
		return listaClienteNutri;
	}
	
}

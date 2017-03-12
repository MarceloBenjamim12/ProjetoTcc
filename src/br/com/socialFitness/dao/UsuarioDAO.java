package br.com.socialFitness.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import br.com.socialFitness.entidades.Usuario;
import javax.persistence.*;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public UsuarioDAO(EntityManager em){
		this.em = em;		
	}
	
	public UsuarioDAO(){
			
	}
	
	@Transactional
	public Usuario salvar(Usuario usuario){
		Usuario u = em.merge(usuario);
		return u;
	}
	
	@Transactional
	public void delete(Usuario usuario){
		em.remove(usuario);
	}
	
	@Transactional
	public List<Usuario> lista(){
		Query q = em.createQuery("select U from Usuario U");
		return q.getResultList();
	}	
	
	public Usuario BuscarPorId(int id){
		return em.find(Usuario.class, id);
	}
	
	public Usuario Autentica(String user, String senha){
		Query q = em.createQuery("select u from Usuario u where u.login = :nome and u.senha = :senha");
		q.setParameter("nome", user);
		q.setParameter("senha", senha);
		
		try{
			Usuario usu = (Usuario) q.getSingleResult();
			return usu;
		}catch(Exception e){
			return null;
		}
	}
	
	public List<Usuario> BuscarPorNome(String nome){
		Query q = em.createQuery("select U from Usuario U where U.nome=:nome");
		q.setParameter("nome", nome);
		return q.getResultList();
	}

}

package br.com.socialFitness.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.socialFitness.dao.SessionManager;
import br.com.socialFitness.dao.UsuarioDAO;
import br.com.socialFitness.entidades.ClienteNutri;
import br.com.socialFitness.entidades.Usuario;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBusiness {
	
	@Autowired
	UsuarioDAO dao;
	
	EntityManager em;
	
	SessionManager session;
	
	public UsuarioBusiness(){
		
	}
	
	public UsuarioBusiness(SessionManager session){
		this.session = session;
		dao = new UsuarioDAO(session.getInstance().getEntityManager());
	}
	
	public Usuario Salvar(Usuario usuario){
		return dao.salvar(usuario);
	}
	
	public void excluir(Usuario usuario){
		try{
			dao.delete(usuario);
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<Usuario> listar(){
		return dao.lista();
	}
	
	public Usuario BuscarPorId(int id){
		return dao.BuscarPorId(id);
	}
	
	public List<Usuario> BuscarPorNome(String nome){
		return dao.BuscarPorNome(nome);
	}
	
	public Usuario Autentica(String user, String senha){
		return dao.Autentica(user, senha);
	}

}

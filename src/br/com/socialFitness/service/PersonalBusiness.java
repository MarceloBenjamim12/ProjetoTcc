package br.com.socialFitness.service;

import java.util.List;
import br.com.socialFitness.dao.PersonalDAO;
import br.com.socialFitness.dao.SessionManager;
import br.com.socialFitness.dao.UsuarioDAO;
import br.com.socialFitness.entidades.ClienteNutri;
import br.com.socialFitness.entidades.Personal;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalBusiness {

	@Autowired
	PersonalDAO dao;
	
	SessionManager session;
	
	public PersonalBusiness(){
		
	}
	
	public PersonalBusiness(SessionManager session){
		this.session = session;
		dao = new PersonalDAO(session.getInstance().getEntityManager());
	}
	
	public Personal Salvar(Personal personal){
		return dao.salvar(personal);
	}
	
	public void excluir(Personal personal){
		try{
			dao.delete(personal);
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<Personal> listar(){
		return dao.list();
	}
	
	public List<Personal> listByID(int id){
		return dao.listByID(id);
	}
	
	public List<Personal> listByName(String nome){
		return dao.listByName(nome);
	}
	
}

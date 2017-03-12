package br.com.socialFitness.service;

import java.util.List;
import br.com.socialFitness.dao.NutricionistaDAO;
import br.com.socialFitness.dao.PersonalDAO;
import br.com.socialFitness.dao.SessionManager;
import br.com.socialFitness.entidades.ClienteNutri;
import br.com.socialFitness.entidades.Nutricionista;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutricionistaBusiness {

	@Autowired
	NutricionistaDAO dao;
	
	SessionManager session;
	
	public NutricionistaBusiness(SessionManager session){
		this.session = session;
		dao = new NutricionistaDAO(session.getInstance().getEntityManager());
	}
	
	public NutricionistaBusiness(){
	}
	
	public Nutricionista Salvar(Nutricionista nutricionista){
		return dao.salvar(nutricionista);
	}
	
	public void excluir(Nutricionista nutricionista){
		try{
			dao.delete(nutricionista);
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<Nutricionista> listar(){
		return dao.lista();
	}
	
	public List<Nutricionista> listar(String espec){
		return dao.listaPorEspec(espec);
	}
	
	public Nutricionista listar(int id){
		return dao.buscarPorId(id);
	}
	
	public List<Nutricionista> listByName(String nome){
		return dao.listByName(nome);
	}
}

package br.com.socialFitness.service;

import java.util.List;

import br.com.socialFitness.dao.PlanoDAO;
import br.com.socialFitness.entidades.Plano;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoBusiness {

	@Autowired
	PlanoDAO dao;
	
	public Plano Salvar(Plano plano){
		return dao.salvar(plano);
	}
	
	public void excluir(Plano plano){
		try{
			dao.delete(plano);
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<Plano> listar(){
		return dao.lista();
	}
	
	public Plano buscarPorID(int id){
		return dao.buscarPorID(id);
	}
	
}

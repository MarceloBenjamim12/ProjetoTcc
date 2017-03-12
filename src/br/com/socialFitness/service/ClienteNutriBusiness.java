package br.com.socialFitness.service;


import java.util.List;
import br.com.socialFitness.dao.ClienteNutriDAO;
import br.com.socialFitness.entidades.ClienteNutri;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteNutriBusiness  {
	
	@Autowired
	ClienteNutriDAO dao;
	
	public ClienteNutriBusiness(){
		
	}
	
	public ClienteNutri Salvar(ClienteNutri clienteNutri){
		return dao.salvar(clienteNutri);
	}
	
	public void excluir(ClienteNutri clienteNutri){
		try{
			dao.delete(clienteNutri);
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<ClienteNutri> listar(){
		return dao.lista();
	}
	
	public List<ClienteNutri> listarPorCliente(int id){
		return dao.listaPorCliente(id);
	}
	
	public List<ClienteNutri> listarPorNutri(int id){
		return dao.listaPorNutri(id);
	}
}

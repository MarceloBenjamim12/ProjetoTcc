package br.com.socialFitness.service;

import java.util.List;

import br.com.socialFitness.dao.ClienteNutriDAO;
import br.com.socialFitness.dao.ClientesPersoDAO;
import br.com.socialFitness.entidades.ClienteNutri;
import br.com.socialFitness.entidades.ClientesPerso;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesPersoBusiness {
	
	@Autowired
	ClientesPersoDAO dao;
	
	public ClientesPerso Salvar(ClientesPerso clientePerso){
		return dao.salvar(clientePerso);
	}
	
	public void excluir(ClientesPerso clientePerso){
		try{
			dao.delete(clientePerso);
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<ClientesPerso> listar(){
		return dao.lista();
	}
	
	public List<ClientesPerso> listaByPersonal(int id){
		return dao.listaByPersonal(id);
	}
	
	public List<ClientesPerso> listaByCliente(int id){
		return dao.listaByCliente(id);
	}

}

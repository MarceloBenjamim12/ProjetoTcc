package br.com.socialFitness.teste;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

import br.com.socialFitness.dao.NutricionistaDAO;
import br.com.socialFitness.dao.PersonalDAO;
import br.com.socialFitness.dao.PlanoDAO;
import br.com.socialFitness.dao.UsuarioDAO;
import br.com.socialFitness.entidades.Nutricionista;
import br.com.socialFitness.entidades.Personal;
import br.com.socialFitness.entidades.Plano;
import br.com.socialFitness.entidades.Usuario;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.socialFitness.service.UsuarioBusiness;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/META-INF/springbeans.xml")
@TransactionConfiguration(transactionManager="transactionManager")
public class TesteHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		EntityManager em = emf.createEntityManager();
		
		Usuario usu = new Usuario();	
		
		UsuarioDAO usuBusiness = new UsuarioDAO(em);
		NutricionistaDAO personaDAO = new NutricionistaDAO(em);
		
		usu = usuBusiness.BuscarPorId(55);
		
		Nutricionista persona = new Nutricionista();
		
		System.out.println(usu.getLogin());
		
		if(usu.getLogin().equals("maria")){
		
			persona.setClassif(7.0);
			persona.setEspec("Se alimentar bem, para crescer");
			persona.setUserID(usu);
			persona.setObs("Contrate-me");
			
			em.getTransaction().begin();;
			
			personaDAO.salvar(persona);
			
			em.getTransaction().commit();
		}
	}

}

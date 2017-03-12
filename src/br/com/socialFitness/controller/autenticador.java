package br.com.socialFitness.controller;

import java.io.IOException;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.socialFitness.dao.SessionManager;
import br.com.socialFitness.dao.UsuarioDAO;
import br.com.socialFitness.entidades.Usuario;
import br.com.socialFitness.service.UsuarioBusiness;


@WebServlet("/autcontroller.do")
public class autenticador extends HttpServlet {
	
	
	@Autowired
	private UsuarioBusiness business;
	
	private SessionManager session;
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// init
	}

	@Override
	public void destroy() {
		// destroy
	}
	
	public autenticador() {
		
		business = new UsuarioBusiness(session);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		String login = req.getParameter("username");
		String senha = req.getParameter("password");
		
		System.out.println(login + " " + senha);
		
		Usuario usuario = business.Autentica(login, senha);
		Gson gson = new Gson();
		
		if(usuario!= null){
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuario", usuario);
			
			
			JsonElement json = gson.toJsonTree(usuario);
			
			/**json.getAsJsonObject().addProperty("empregador", empregadorGuid);
			json.getAsJsonObject().addProperty("nomeSistema", nomeSistema);
			json.getAsJsonObject().addProperty("empregadorNome", empregadorNome);
			json.getAsJsonObject().addProperty("empregadorNrInsc", empregadorNrInsc);
			json.getAsJsonObject().addProperty("empregadorIniValid", empregadorIniValid);						
			json.getAsJsonObject().addProperty("empregadorTipo", empregadorTipo);
			json.getAsJsonObject().addProperty("empregadorNatJur", empregadorNatJur);
			json.getAsJsonObject().addProperty("username", username);
			*/
			
			//resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			resp.setHeader("Content-Type", "application/json;charset=utf-8");
			String jsonString = json.toString();

			byte[] utf8JsonString = jsonString.getBytes("UTF8");

			resp.getOutputStream().write(utf8JsonString);
			
			System.out.println("passou");
			
			sessao.setMaxInactiveInterval(60*5);
			
			//encaminhar
			//req.getRequestDispatcher("views/homePage.html").forward(req, resp);;
			
		}else{
			//encaminhando para a tela de login princiapl
			//resp.sendRedirect("views/login.html");
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			
			resp.getWriter().write("Usuario ou senha invalido");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		HttpSession sessao = req.getSession(false);
		if(sessao != null){
			sessao.invalidate();
		}
		
		resp.sendRedirect("views/login.view.html");
	}

}

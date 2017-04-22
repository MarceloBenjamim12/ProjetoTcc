package br.com.socialFitness.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(urlPatterns = {"/*"}, filterName = "authorization-filter")
@WebFilter("/*") 
public class DoFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws IOException, ServletException {
		System.out.println("Passou pelo filtro");
		
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) resp;
		
		String uri = httpRequest.getRequestURI();
		HttpSession sessao = httpRequest.getSession();
		if(sessao.getAttribute("usuario") != null || uri.lastIndexOf("login.html")!= -1 || uri.lastIndexOf("Login.html") > -1){
			chain.doFilter(req, resp);
		}else{
			httpResponse.sendRedirect("view/login.html");
		}
		
	}
	*/
	
	 public void doFilter(ServletRequest request, ServletResponse response,
		        FilterChain chain) throws IOException, ServletException {
		 
		 

		        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
		        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
		        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "GET, PUT, OPTIONS, X-XSRF-TOKEN");
		        boolean login = false;
		        HttpServletRequest httpRequest = (HttpServletRequest) request;
		        HttpServletResponse httpResponse = (HttpServletResponse) response;
		        String username = httpRequest.getSession().getAttribute("usuario") == null ? "anonymous" : httpRequest.getSession().getAttribute("usuario").toString();
		        String uri = httpRequest.getRequestURI();
		        System.out.println(uri);
		        if(uri.contains("login.html")){
		        	login = true;
		        }else if(uri.contains("cadastro.html")){
		        	login = true;
		        }
		        if(uri.contains(".html")){
		        	
		            if ((username != null && username != "anonymous")) {
		            	chain.doFilter(request, response);
		            }else if(login){
		            	chain.doFilter(request, response);
		            	//httpResponse.sendRedirect("/Projeto/views/login.html");
		            	//HttpServletResponse.sendRedirect("/your/new/location.jsp")
		            }else{
		            	System.out.println("sem Login");
		            	//chain.doFilter(request, response);
		            }
		        }else{
		        	chain.doFilter(request, response);
		        }
	            
		    }

	

}

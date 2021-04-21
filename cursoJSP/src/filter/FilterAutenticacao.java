package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.BeanCursoJsp;


@WebFilter(urlPatterns = {"/*"})
public class FilterAutenticacao implements Filter {

	
	 // FAZ ALGUMA COISA QUANDO A APLICACAO É DERRUBADA
	@Override
	public void destroy() {
		
		Filter.super.destroy();
	}
	
	//INTERCEPTA TODAS AS REQUISICOES
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		
		String urlParaAutenticar = req.getServletPath(); 
		
		//Retorna null caso nao esteja logado
		BeanCursoJsp user = (BeanCursoJsp) session.getAttribute("usuario");
		
		
		if(user == null && !urlParaAutenticar.equalsIgnoreCase("/LoginServlet") ) { // usuário nao logado
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?url="+urlParaAutenticar);
			dispatcher.forward(request, response);
			
			
			return; // para o processo  para redirecionar
		}
		//EXECUTA AS AÇÕES DO REQUEST E RESPONSE
		chain.doFilter(request, response);
		System.out.println("interceptando");
		
	}
	
	// EXECUTA ALGUMA COISA QUANDO A APLICACAO È INICIADA 
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

}

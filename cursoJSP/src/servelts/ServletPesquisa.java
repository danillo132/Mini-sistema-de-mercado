package servelts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoUsuario;


@WebServlet("/servletPesquisa")

public class ServletPesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DaoUsuario usuario = new DaoUsuario();
		
		
		String descricaoPesquisa = request.getParameter("descricaoconsulta");
		try {
		if(descricaoPesquisa != null  && !usuario.validarPesquisa(descricaoPesquisa)) {
			
				List<BeanCursoJsp> listaPesquisa = usuario.listar(descricaoPesquisa);
				
				
					RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
					request.setAttribute("usuarios", listaPesquisa);
					view.forward(request, response);
				
					
				
				
			
		}else if(descricaoPesquisa != null  && usuario.validarPesquisa(descricaoPesquisa)) {
			
			
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("pesquisa", "usuário não existe no sistema!");
				request.setAttribute("usuarios", usuario.listar());
				view.forward(request, response);
			 
			
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

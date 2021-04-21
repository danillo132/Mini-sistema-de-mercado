package servelts;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanProdutos;
import dao.daoProdutos;


@WebServlet("/ServletPesquisaProduto")
public class ServletPesquisaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		daoProdutos produtos = new daoProdutos();
		
		String descricaoPesquisa = request.getParameter("descricaoconsulta");
		
		try {
			if(descricaoPesquisa != null && !produtos.validarPesquisaProduto(descricaoPesquisa)) {
				
				
				List<BeanProdutos> listaProdutos = produtos.listarPesquisa(descricaoPesquisa);
				
				RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
				request.setAttribute("produtos", listaProdutos);
				view.forward(request, response);
				
				
			}else if(descricaoPesquisa != null  && produtos.validarProduto(descricaoPesquisa)) {
				
				RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
				request.setAttribute("pesquisa", "Produto não existe no sistema!!");
				request.setAttribute("produtos", produtos.listar());
				view.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

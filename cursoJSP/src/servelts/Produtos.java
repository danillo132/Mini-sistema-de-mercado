package servelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanProdutos;
import dao.daoProdutos;

/**
 * Servlet implementation class Produtos
 */
@WebServlet("/salvarProdutos")
public class Produtos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	daoProdutos produtos = new daoProdutos();
    
    public Produtos() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String acao = request.getParameter("acao");
			String prod = request.getParameter("prod");
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
			
			if(acao != null && acao.equalsIgnoreCase("delete") && prod != null) {
				produtos.deletarProd(prod);
				
				request.setAttribute("produtos", produtos.list());
			}else if(acao != null && acao.equalsIgnoreCase("editar")) {
				
				BeanProdutos beanProdutos = produtos.consultar(prod);
				
				request.setAttribute("prod", beanProdutos);
				
			}else if(acao != null && acao.equalsIgnoreCase("listarprodutos")) {
				
				request.setAttribute("produtos", produtos.list());
			}else {
				
				request.setAttribute("produtos", produtos.list());
				
			}
			
			request.setAttribute("categoria", produtos.listaCategorias());
			
			view.forward(request, response);
			
		} catch (Exception e) {
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String acao = request.getParameter("acao");
		
		if(acao != null && acao.equalsIgnoreCase("reset")) {
			
			try {
			RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
			request.setAttribute("produtos", produtos.list());
			view.forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else {
			
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String qtd = request.getParameter("qtd");
			String preco = request.getParameter("valor");
			String categoria = request.getParameter("categoria_id");
			
			
			BeanProdutos beanProdutos = new  BeanProdutos();
			
			beanProdutos.setNome(nome);
			beanProdutos.setQtd(Integer.valueOf(qtd));
			beanProdutos.setCategoria_id(Long.parseLong(categoria));
			
			
			String valorParse = preco.replaceAll("\\.", "");
			
			valorParse = valorParse.replaceAll("\\,", ".");
			beanProdutos.setPreco(Double.valueOf(valorParse));
			beanProdutos.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			
			
			try {
				boolean podeinserir = true;
				
				 if(id == null || id.isEmpty() && produtos.validarProduto(nome) && podeinserir) {
					 produtos.salvarProdutos(beanProdutos);
					request.setAttribute("msg", "cadastrado com sucesso!");
					
					
				}else if(id == null || id.isEmpty() && !produtos.validarProduto(nome)) {
					  podeinserir = false;
					request.setAttribute("msg", "Produto ja cadastrado no sistema!!");
				  }
				 
				 
				
				 
				 if( id != null && !id.isEmpty() &&   produtos.validarProdutoUpdate(nome, id) && podeinserir  ) {
					
					request.setAttribute("msg", "Atualizado");
					 produtos.atualizarProd(beanProdutos);
					 
				}else if(id != null && !id.isEmpty() && !produtos.validarProdutoUpdate(nome, id)  ) { 
					
					podeinserir = false;
					request.setAttribute("msg", "Produto ja cadastrado no sistema!!");
				}
				 
				 
				 
				
				
				if(podeinserir == false) {
					request.setAttribute("prod", beanProdutos);
				}
				
				  
				 	
				
				
				RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
				request.setAttribute("produtos", produtos.list());
				request.setAttribute("categoria", produtos.listaCategorias());
				view.forward(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
	}

}

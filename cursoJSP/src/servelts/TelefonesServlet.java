package servelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import beans.Telefones;
import dao.DaoUsuario;
import dao.daoTelefones;

@WebServlet("/salvarTelefones")
public class TelefonesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	private daoTelefones daoTelefones = new daoTelefones();

	public TelefonesServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String acao = request.getParameter("acao");
		
		if(acao != null && acao.equalsIgnoreCase("addFone") && user != null) {
			
		

		try {
			BeanCursoJsp usuario = daoUsuario.consultar(user);

			request.getSession().setAttribute("userEscolhido", usuario);
			request.setAttribute("userEscolhido", usuario);
			request.setAttribute("telefones", daoTelefones.list(usuario.getId()));
			RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");

			view.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}else if (acao != null && acao.equalsIgnoreCase("deleteFone")) {
			try {
			String foneId = request.getParameter("foneId");
			daoTelefones.deletarTelefones(foneId);
			BeanCursoJsp beanCursoJsp = (BeanCursoJsp) request.getSession().getAttribute("userEscolhido");
			RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");
			request.setAttribute("telefones", daoTelefones.list(beanCursoJsp.getId()));
			request.setAttribute("msg", "Removido com sucesso!");
			view.forward(request,  response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}else {
		
		RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
		try {
			request.setAttribute("usuarios", daoUsuario.listar());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.forward(request,  response);
		
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			BeanCursoJsp beanCursoJsp = (BeanCursoJsp) request.getSession().getAttribute("userEscolhido");
			String numero = request.getParameter("numero");
			String tipo = request.getParameter("tipo");

			Telefones telefones = new Telefones();

			telefones.setNumero(numero);
			telefones.setTipo(tipo);
			telefones.setUsuario(beanCursoJsp.getId());

			daoTelefones.salvarTelefones(telefones);

			request.getSession().setAttribute("userEscolhido", beanCursoJsp);
			request.setAttribute("userEscolhido", beanCursoJsp);

			RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");

			request.setAttribute("msg", "cadastrado com sucesso");
			request.setAttribute("telefones", daoTelefones.list(beanCursoJsp.getId()));
			view.forward(request, response);

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

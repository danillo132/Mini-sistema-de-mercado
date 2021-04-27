package servelts;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

/**
 * Servlet implementation class CarregarDadosDataTable
 */
@WebServlet("/CarregarDadosDataTable")
public class CarregarDadosDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario usuario = new DaoUsuario();

	public CarregarDadosDataTable() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<BeanCursoJsp> usuarios = usuario.listar();

			if (!usuarios.isEmpty()) {

				
				String data = "";
				int totalUsers = usuarios.size();
				int index = 1;
				for (BeanCursoJsp usuario : usuarios) {
					
					data += " [" + "\""+ usuario.getId() +"\"," + "\""+ usuario.getLogin()+"\"," + "\""+ usuario.getNome()+"\"," + "\""+ usuario.getPerfil()+"\"," + "\""+usuario.getTelefone()+"\","
							+ "\""+usuario.getSexo()+"\"" + "]";
					
					if(index < totalUsers) {
						data += ",";		
						
					}
					index++;
				}
				
				
				String json = "{" + "\"draw\": 1," + "\"recordsTotal\": " + usuarios.size() + " ,"
						+ "\"recordsFiltered\": " + usuarios.size() + "," + "\"data\": [ " +

						// INICIO - PROCESSA A LISTA DE DADOS
						data+

						// FIM- PROCESSA A LISTA DE DADOS

						"]" + // FECHAMENTO DO DATA

						"}"; // FECHAMENTO DO JSON

				response.setStatus(200); // RESPOSTA OK
				response.getWriter().write(json); // resposta do JSON(Escreve a resposta HTTP)
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(500);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

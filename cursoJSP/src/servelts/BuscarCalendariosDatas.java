package servelts;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanEventos;
import dao.DaoEventos;


@WebServlet("/BuscarCalendariosDatas")
public class BuscarCalendariosDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoEventos eventos = new DaoEventos();
    
    public BuscarCalendariosDatas() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			List<BeanEventos> evento = eventos.listar();
			
			
			if(!evento.isEmpty()) {
				
				int totalEventos = evento.size();
				int index = 1;
				
				String datas = "[";
						
				
				
				
				for (BeanEventos beanEventos : evento) {
					 datas += "{ \"title\" : \""+beanEventos.getDescricao()+"\", \"start\" :\""+beanEventos.getDataevento()+"\"}";
				
				
				
					 if(index < totalEventos) {
							datas +=",";
						}
						index++;
				}
				
				
				
				datas += "]";
				
				
				response.setStatus(200);
				response.getWriter().write(datas);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

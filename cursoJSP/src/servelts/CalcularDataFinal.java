package servelts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCalculaData;


@WebServlet("/CalcularDataFinal")
public class CalcularDataFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoCalculaData calculaData1 = new DaoCalculaData();
	
	
    
    public CalcularDataFinal() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int horaDia = 8;
			Date dataCalculada = null;
			Double totalDeDias = 0.0;
			
			String data = request.getParameter("data");
			int tempo = Integer.parseInt(request.getParameter("tempo"));
			
			if(tempo <= horaDia) {
				dataCalculada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
				Calendar calendar = Calendar.getInstance();
				
				calendar.setTime(dataCalculada);
				calendar.add(Calendar.DATE, 1);
				
				dataCalculada = calendar.getTime();
				totalDeDias = 1.0;
				
				
			}else {
				
				totalDeDias = (double) (tempo / horaDia);
				
				if(totalDeDias <= 1 ) {
					dataCalculada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
				}else {
					Date dataInformada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
					Calendar calendar = Calendar.getInstance();
					
					calendar.setTime(dataInformada);
					calendar.add(Calendar.DATE, totalDeDias.intValue());
					
					dataCalculada = calendar.getTime();
					
				}
			}
			
			calculaData1.GravaDataFinal(new SimpleDateFormat("dd/MM/yyyy").format(dataCalculada));
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("datas.jsp");
			request.setAttribute("dataFinal",new SimpleDateFormat("dd/MM/yyyy").format(dataCalculada));
			request.setAttribute("dias", totalDeDias);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}

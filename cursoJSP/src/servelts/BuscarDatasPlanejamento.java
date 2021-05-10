package servelts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.BeanProjeto;
import beans.BeanSeries;
import dao.DaoGanttChart;


@WebServlet("/BuscarDatasPlanejamento")
public class BuscarDatasPlanejamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DaoGanttChart chart = new DaoGanttChart();
	
	
    public BuscarDatasPlanejamento() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		List<BeanProjeto> beanProjetos = chart.getProjetos();
		
		
		if(!beanProjetos.isEmpty()) {
		String ganttJson = new Gson().toJson(beanProjetos);
		
		
		response.setStatus(200);
		response.getWriter().write(ganttJson);
		
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String dataInicial = request.getParameter("start");
		String dataFinal = request.getParameter("end");
		String newSerie = request.getParameter("serie");
		String newProjeto = request.getParameter("projeto");

		try {
		
		BeanSeries seriesUpdate = new BeanSeries();
		
		seriesUpdate.setComeco(dataInicial);
		seriesUpdate.setDataFinal(dataFinal);
		seriesUpdate.setId(Long.valueOf(newSerie));
		seriesUpdate.setProjeto(Long.valueOf(newProjeto));
		
	
			chart.atualizarDatas(seriesUpdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

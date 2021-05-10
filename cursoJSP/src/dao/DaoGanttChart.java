package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.BeanProjeto;
import beans.BeanSeries;
import connection.SingleConnection;

public class DaoGanttChart {

	private Connection connection;
	
	public DaoGanttChart() {
		connection = SingleConnection.getConnection();
		
	}
	
	
	
	public void atualizarDatas(BeanSeries series)  throws Exception{
		
		String sql = "update serie set comeco = '" +series.getComeco()+ "', final = '" +series.getDataFinal()+"'"
				+ " where id = " +series.getId()+ "and projeto = " + series.getProjeto(); 
		connection.prepareStatement(sql).executeUpdate();
		connection.commit();
		
		
	}
	
	public List<BeanProjeto> getProjetos() throws Exception{
		List<BeanProjeto> projetos =  new ArrayList<BeanProjeto>();
		
		String sqlprojetos = "select * from projeto";
		PreparedStatement statement = connection.prepareStatement(sqlprojetos);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			BeanProjeto beanProjeto = new BeanProjeto();
			beanProjeto.setId(resultSet.getLong("id"));
			beanProjeto.setNome(resultSet.getString("nome"));
			
			String sqlseries = "select * from serie where projeto = '"+resultSet.getLong("id")+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlseries);
			ResultSet  setseries = preparedStatement.executeQuery();
			List<BeanSeries> beanSeries = new ArrayList<BeanSeries>();
			
			
			
			while(setseries.next()) {
				BeanSeries series = new BeanSeries();
				
				series.setId(setseries.getLong("id"));
				series.setProjeto(setseries.getLong("projeto"));
				series.setNome(setseries.getString("nomeseries"));
				
				series.setComeco(setseries.getString("comeco"));
				series.setDataFinal(setseries.getString("final"));
				
				
				beanSeries.add(series);
			}
			
			beanProjeto.setSeries(beanSeries);
			
			
			projetos.add(beanProjeto);
			
		}
		
		return projetos;
	}
}

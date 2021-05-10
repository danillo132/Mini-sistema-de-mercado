package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import beans.BeanEventos;
import connection.SingleConnection;

public class DaoEventos {

	private static Connection connection;

	public DaoEventos() {
		connection = SingleConnection.getConnection();

	}

	
	
	
	
	public List<BeanEventos> listar() throws Exception {
		

		String sql = "select * from eventos";

		return consultarEventos(sql);

		
	}

private List<BeanEventos> consultarEventos(String sql) throws SQLException {
	List<BeanEventos> listar = new ArrayList<BeanEventos>();
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet resultSet = statement.executeQuery();

	while (resultSet.next()) {

		BeanEventos eventos = new BeanEventos();
		eventos.setId(resultSet.getString("id"));
		eventos.setDataevento(resultSet.getString("dataevento"));
		eventos.setDescricao(resultSet.getString("descricao"));
		
		
		
		
		listar.add(eventos);

	}
	return listar;
}

}

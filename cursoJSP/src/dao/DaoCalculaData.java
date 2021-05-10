package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.SingleConnection;

public class DaoCalculaData {

	
	private Connection connection;
	
	
	public DaoCalculaData(){
		connection = SingleConnection.getConnection();
		
	}
	
	
	public void GravaDataFinal(String date)  throws Exception{
		
		
		String sql = "insert into finalprojetos(datafinal) values (?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, date);
		statement.execute();
		connection.commit();
		
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {

	 private static Connection connection;
	
	public DaoLogin() {
		connection = SingleConnection.getConnection();
		
	}
	
	public boolean ValidarLogin(String login, String senha)  throws Exception{
		
		
		String sql = "select * from usuario where login =  '"+login+"' and senha = '"+senha+"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();
		
		if(set.next()) {
			return true; // possui usuário
		}else {
			return false; // não validou usuário
		}
		
	}
}

package connection;

import java.sql.Connection;
import java.sql.DriverManager;

//CONEXAO COM O BANCO DE DADOS

public class SingleConnection {

	
	private static String url = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection  = null;
	
	
	static {
		Conectar();
		
	}
	
	public SingleConnection() {
		Conectar();
	
	}
	
	private static void Conectar() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("ERRO ao conectar com o banco de dados");
			
		}
	}
	
	public static Connection getConnection() {
		return connection;
		
	}
}

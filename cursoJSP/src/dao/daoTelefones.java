package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanProdutos;
import beans.Telefones;
import connection.SingleConnection;

public class daoTelefones {

	private static Connection connection;

	public daoTelefones() {

		connection = SingleConnection.getConnection();

	}

	public void salvarTelefones(Telefones telefones) {

		try {

			String sql = "insert into telefones(numero, tipo, usuario) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, telefones.getNumero());
			statement.setString(2, telefones.getTipo());
			statement.setLong(3, telefones.getUsuario());
			statement.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<Telefones> list(Long user) throws Exception {
		List<Telefones> listar = new ArrayList<Telefones>();

		String sql = "select * from telefones where usuario =  " + user;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();

		while (set.next()) {
			Telefones telefones = new Telefones();

			telefones.setId(set.getLong("id"));
			telefones.setNumero(set.getString("numero"));
			telefones.setTipo(set.getString("tipo"));
			telefones.setUsuario(set.getLong("usuario"));

			listar.add(telefones);
		}

		return listar;

	}

	public void deletarTelefones(String id) {
		try {
			String sql = "delete from telefones where id = '" + id + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

}

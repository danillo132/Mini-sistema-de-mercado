package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.graalvm.compiler.core.common.type.Stamp;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private static Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();

	}

	public void salvarUsuario(BeanCursoJsp usuario) {

		try {

			String sql = "insert into usuario(login, senha, nome, telefone, cep, rua, bairro, cidade, estado, ibge, fotobase64, contenttype, curriculobase64, contenttypecurriculo, fotobase64miniatura, ativo, sexo, perfil) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getNome());
			statement.setString(4, usuario.getTelefone());
			statement.setString(5, usuario.getCep());
			statement.setString(6, usuario.getRua());
			statement.setString(7, usuario.getBairro());
			statement.setString(8, usuario.getCidade());
			statement.setString(9, usuario.getEstado());
			statement.setString(10, usuario.getIbge());
			statement.setString(11, usuario.getFotoBase64());
			statement.setString(12, usuario.getContentType());
			statement.setString(13, usuario.getCurriculoBase64());
			statement.setString(14, usuario.getContentTypeCurriculo());
			statement.setString(15, usuario.getFotoBase64Miniatura());
			statement.setBoolean(16, usuario.isAtivo());
			statement.setString(17, usuario.getSexo());
			statement.setString(18, usuario.getPerfil());

			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	
	public List<BeanCursoJsp> listar(String descricaoconsulta) throws SQLException {
		String sql = "select * from usuario where login <> 'admin' and nome like '%"+descricaoconsulta+"%'";
		
		return consultarUsuarios(sql);
	}

	public List<BeanCursoJsp> listar() throws Exception {
		

		String sql = "select * from usuario where login <> 'admin'";

		return consultarUsuarios(sql);

		
	}

private List<BeanCursoJsp> consultarUsuarios(String sql) throws SQLException {
	List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>();
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet resultSet = statement.executeQuery();

	while (resultSet.next()) {

		BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
		beanCursoJsp.setId(resultSet.getLong("id"));
		beanCursoJsp.setLogin(resultSet.getString("login"));
		beanCursoJsp.setSenha(resultSet.getString("senha"));
		beanCursoJsp.setNome(resultSet.getString("nome"));
		beanCursoJsp.setTelefone(resultSet.getString("telefone"));
		beanCursoJsp.setCep(resultSet.getString("cep"));
		beanCursoJsp.setRua(resultSet.getString("rua"));
		beanCursoJsp.setBairro(resultSet.getString("bairro"));
		beanCursoJsp.setCidade(resultSet.getString("cidade"));
		beanCursoJsp.setEstado(resultSet.getString("estado"));
		beanCursoJsp.setIbge(resultSet.getString("ibge"));
		// beanCursoJsp.setFotoBase64(resultSet.getString("fotobase64"));]
		beanCursoJsp.setFotoBase64Miniatura(resultSet.getString("fotobase64miniatura"));
		beanCursoJsp.setContentType(resultSet.getString("contenttype"));
		beanCursoJsp.setCurriculoBase64(resultSet.getString("curriculobase64"));
		beanCursoJsp.setContentTypeCurriculo(resultSet.getString("contenttypecurriculo"));
		
		beanCursoJsp.setAtivo(resultSet.getBoolean("ativo"));
		beanCursoJsp.setSexo(resultSet.getString("sexo"));
		beanCursoJsp.setPerfil(resultSet.getString("perfil"));
		
		
		
		listar.add(beanCursoJsp);

	}
	return listar;
}

	public void deletar(String id) {
		try {
			String sql = "delete from usuario where id = '" + id + "' and login <> 'admin'";
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

	public BeanCursoJsp consultar(String id) throws Exception {

		String sql = "select * from usuario where id = '" + id + "' and login <> 'admin'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();

		if (set.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(set.getLong("id"));
			beanCursoJsp.setLogin(set.getString("login"));
			beanCursoJsp.setSenha(set.getString("senha"));
			beanCursoJsp.setNome(set.getString("nome"));
			beanCursoJsp.setTelefone(set.getString("telefone"));
			beanCursoJsp.setCep(set.getString("cep"));
			beanCursoJsp.setRua(set.getString("rua"));
			beanCursoJsp.setBairro(set.getString("bairro"));
			beanCursoJsp.setCidade(set.getString("cidade"));
			beanCursoJsp.setEstado(set.getString("estado"));
			beanCursoJsp.setIbge(set.getString("ibge"));
			beanCursoJsp.setFotoBase64(set.getString("fotobase64"));
			beanCursoJsp.setFotoBase64Miniatura(set.getString("fotobase64miniatura"));
			beanCursoJsp.setContentType(set.getString("contenttype"));
			beanCursoJsp.setCurriculoBase64(set.getString("curriculobase64"));
			beanCursoJsp.setContentTypeCurriculo(set.getString("contenttypecurriculo"));
			beanCursoJsp.setAtivo(set.getBoolean("ativo"));
			beanCursoJsp.setSexo(set.getString("sexo"));
			beanCursoJsp.setPerfil(set.getString("perfil"));

			return beanCursoJsp;

		}
		return null;
	}

	public boolean validarLogin(String login) throws Exception {

		String sql = "select count(1)  as qtd from usuario where login = '" + login + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();

		if (set.next()) {

			return set.getInt("qtd") <= 0;

		}

		return false;
	}

	public boolean validarSenha(String senha) throws Exception {

		String sql = "select count(1)  as qtd from usuario where senha = '" + senha + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();

		if (set.next()) {

			return set.getInt("qtd") <= 0;

		}

		return false;
	}

	public boolean validarLoginUpdate(String login, String id) throws Exception {

		String sql = "select count(1)  as qtd from usuario where login = '" + login + "' and id <> " + id;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();

		if (set.next()) {

			return set.getInt("qtd") <= 0;

		}

		return false;
	}

	public boolean validarSenhaUpdate(String senha, String id) throws Exception {

		String sql = "select count(1)  as qtd from usuario where login = '" + senha + "' and id <> " + id;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();

		if (set.next()) {

			return set.getInt("qtd") <= 0;

		}

		return false;
	}
	
	public boolean validarPesquisa(String descricaoconsulta) throws Exception {
		String sql =  "select count(1) as user from usuario where nome = '" + descricaoconsulta + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();
		
		if(set.next()) {
			
			return set.getInt("user") <=0;
		}
		
		return false;
	}

	public void atualizar(BeanCursoJsp usuario) {
		try {

			StringBuilder sql = new StringBuilder();

			sql.append(" update usuario set login = ?, senha = ?, nome = ?, telefone = ?,");
			sql.append(" cep = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, ibge = ?, ativo = ?, sexo = ?, perfil = ? ");

			if (usuario.isAtualizarImage()) {
				sql.append(", fotobase64 = ?, contenttype = ?");
			}
			if (usuario.isAtualizarPdf()) {
				sql.append(", curriculobase64 = ? , contenttypecurriculo = ? ");
			}
			if (usuario.isAtualizarImage()) {
				sql.append(", fotobase64miniatura = ? ");
			}
			sql.append(" where id = " + usuario.getId());

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getNome());
			statement.setString(4, usuario.getTelefone());
			statement.setString(5, usuario.getCep());
			statement.setString(6, usuario.getRua());
			statement.setString(7, usuario.getBairro());
			statement.setString(8, usuario.getCidade());
			statement.setString(9, usuario.getEstado());
			statement.setString(10, usuario.getIbge());
			statement.setBoolean(11, usuario.isAtivo());
			statement.setString(12, usuario.getSexo());
			statement.setString(13, usuario.getPerfil());
				
			if (usuario.isAtualizarImage()) {
				statement.setString(14, usuario.getFotoBase64());
				statement.setString(15, usuario.getContentType());
			}
			
			if(usuario.isAtualizarPdf()) {
				
				if(usuario.isAtualizarPdf() && !usuario.isAtualizarImage()) {
					statement.setString(14, usuario.getCurriculoBase64());
					statement.setString(15, usuario.getContentTypeCurriculo());
				}else {
					statement.setString(16, usuario.getCurriculoBase64());
					statement.setString(17, usuario.getContentTypeCurriculo());
				}
			
			}
			else if (usuario.isAtualizarImage()) {
				statement.setString(16, usuario.getFotoBase64Miniatura());
			}
			
			if(usuario.isAtualizarImage() && usuario.isAtualizarPdf()) {
				statement.setString(18, usuario.getFotoBase64Miniatura());
			}

			statement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}

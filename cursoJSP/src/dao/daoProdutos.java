package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCategoria;
import beans.BeanProdutos;
import connection.SingleConnection;

public class daoProdutos {

	private static Connection connection;
	
	public daoProdutos() {
		
		connection = SingleConnection.getConnection();
		
	}
	
	public void salvarProdutos(BeanProdutos produtos) {
		
		try {
			
			String sql = "insert into produtos(nome, quantidade, valor, categoria_id) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, produtos.getNome());
			statement.setInt(2,  produtos.getQtd());
			statement.setDouble(3, produtos.getPreco());
			statement.setLong(4, produtos.getCategoria_id());
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
	
	public List<BeanProdutos> list() throws Exception{
		List<BeanProdutos> listar = new ArrayList<BeanProdutos>();
		
		String sql = "select * from produtos ";
		PreparedStatement statement = connection.prepareStatement(sql);
	   ResultSet set = statement.executeQuery();
		
		while(set.next()) {
			BeanProdutos beanProdutos = new BeanProdutos();
			
			beanProdutos.setId(set.getLong("id"));
			beanProdutos.setNome(set.getString("nome"));
			beanProdutos.setQtd(set.getInt("quantidade"));
			beanProdutos.setPreco(set.getDouble("valor"));
			beanProdutos.setCategoria_id(set.getLong("categoria_id"));
			
			listar.add(beanProdutos);
		}
		
		return listar;
		
	}
	
	public List<BeanCategoria> listaCategorias() throws Exception{
		List<BeanCategoria> retorno = new ArrayList<BeanCategoria>();
		
		String sql = "select * from categoria";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();
		
		while(set.next()) {
			BeanCategoria categoria = new BeanCategoria();
			categoria.setId(set.getLong("id"));
			categoria.setNome(set.getString("nome"));
			retorno.add(categoria);
		}
		
		return retorno;
	}
	
	
	public void deletarProd(String id) {
		try {
		String sql = "delete from produtos where id = '" +id+"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.commit();
	}catch(Exception e) {
		e.printStackTrace();
		try {
			connection.rollback();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	
	}
	
	public BeanProdutos consultar(String id)  throws Exception{
		
		String sql = "select * from produtos where id = '"+id+"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		
		if(resultSet.next()) {
			
			BeanProdutos beanProdutos = new BeanProdutos();
			
			beanProdutos.setId(resultSet.getLong("id"));
			beanProdutos.setNome(resultSet.getString("nome"));
			beanProdutos.setQtd(resultSet.getInt("quantidade"));
			beanProdutos.setPreco(resultSet.getDouble("valor"));
			beanProdutos.setCategoria_id(resultSet.getLong("categoria_id"));
			
			return beanProdutos;
		
			
		}
		return null;
	}
	
	
	public boolean validarProduto(String nome) throws Exception {
		
		String sql = "select count(1) as quant from produtos where nome = '"+nome+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet set = preparedStatement.executeQuery();
		
		if(set.next()) {
			
			return set.getInt("quant") <=0;
		}
		return false;
	}
	
	public boolean validarProdutoUpdate(String nome, String id) throws Exception {
		
		String sql = "select count(1) as quant from produtos where nome = '"+nome+"' and id <> " + id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet set = preparedStatement.executeQuery();
		
		if(set.next()) {
			
			return set.getInt("quant") <=0; 
		}
		return false;
	}
	
	public void atualizarProd(BeanProdutos produtos) {
		try {
		String sql = "update produtos  set nome = ?, quantidade = ?, valor = ?, categoria_id = ? where id = " + produtos.getId();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, produtos.getNome());
		statement.setInt(2, produtos.getQtd());
		statement.setDouble(3, produtos.getPreco());
		statement.setLong(4, produtos.getCategoria_id());
		statement.execute();
		connection.commit();
		
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
}

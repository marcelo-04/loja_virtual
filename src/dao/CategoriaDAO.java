package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;

public class CategoriaDAO {
	
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		
		this.connection = connection;		
	}
	
	public List<Categoria> listar() throws SQLException {
		
		List<Categoria> categorias = new ArrayList<>();
		
		System.out.println("Executnado a query de listar categoria!");
		
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.execute();
			
			try(ResultSet resultSet = preparedStatement.getResultSet()) {
				while(resultSet.next()) {
					Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
					
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}
}

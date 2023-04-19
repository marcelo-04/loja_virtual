package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {

		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());

			preparedStatement.execute();

			try (ResultSet resulSet = preparedStatement.getGeneratedKeys()) {
				while (resulSet.next()) {
					produto.setId(resulSet.getInt(1));
				}
			}
		}
	}
	
	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.execute();
			
			try(ResultSet resultSet = preparedStatement.getResultSet()) {
				while(resultSet.next()) {
					Produto produto = new Produto
							(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
}

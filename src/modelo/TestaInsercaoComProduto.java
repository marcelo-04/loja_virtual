package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComProduto {	

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection = new ConnectionFactory1().recuperarConexao()) {
			
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				preparedStatement.setString(1, comoda.getNome());
				preparedStatement.setString(2, comoda.getDescricao());
				
				preparedStatement.execute();
				
				try(ResultSet resulSet = preparedStatement.getGeneratedKeys()) {
					while(resulSet.next()) {
						comoda.setId(resulSet.getInt(1));
					}
				}
			}	
		}
		System.out.println(comoda);
	}
}

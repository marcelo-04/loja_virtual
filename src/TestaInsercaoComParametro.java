import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	
	public static void main(String[] args) throws SQLException {
		
		String nome = "Mouse'";
		String descricao = "Mouse sem fio); delete from Produto;";
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)"
				, Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, nome);
		statement.setString(2, descricao);
		
		statement.execute();
		ResultSet result = statement.getGeneratedKeys();

		while (result.next()) {
			Integer id = result.getInt(1);
			System.out.println("O id criado foi " + id);
		}
	}

}

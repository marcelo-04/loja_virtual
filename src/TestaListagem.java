import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement statement = connection.createStatement();
		statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");		
				
		ResultSet result = statement.getResultSet();
		
		while (result.next()) {
			Integer id = result.getInt("ID");
			String nome = result.getString("NOME");
			String descricao = result.getString("DESCRICAO");
			
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
		
		connection.close();	
	}
}

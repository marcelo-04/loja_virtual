import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimeZone=UTC", 
						"root", "P@ssw0rd25");
		
		Statement statement = connection.createStatement();
		statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");		
				
		ResultSet result = statement.getResultSet();
		
		while (result.next()) {
			Integer id = result.getInt("ID");
			System.out.println(id);
			String nome = result.getString("NOME");
			System.out.println(nome);
			String descricao = result.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		connection.close();	
	}
}

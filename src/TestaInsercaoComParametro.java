import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()){//Usando o try-with-resources

			connection.setAutoCommit(false);
			
			//Usando o try-with-resources
			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);) {
				adicionarVariavel("SmartTV", "45 polegadas", statement);
				adicionarVariavel("Radio", "Radio de bateria", statement);

				connection.commit();

				statement.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECULTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement)
			throws SQLException {

		statement.setString(1, nome);
		statement.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("Não foi possível adicionar o produto!");
		}

		statement.execute();

		try (ResultSet result = statement.getGeneratedKeys()) {
			while (result.next()) {
				Integer id = result.getInt(1);
				System.out.println("O id criado foi " + id);
			}
		}
	}
}

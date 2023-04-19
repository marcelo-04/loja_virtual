package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.ProdutoDAO;

public class TestaInsercaoEListagemComProduto {	

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection = new ConnectionFactory1().recuperarConexao()) {
			
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);	
			
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));			
		}
	}
}

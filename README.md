# loja_virtual
### Executando comandos SQL no Java.
Efetuando o primeiro método de operação com banco de dados com aplicação Java.
* Como recuperar uma conexão no banco de dados e listar os produtos que foram inseridos na tabela!
### Criando a ConnectionFactory
* Uma vantagem na aplicação e fornece uma maneira mais simples para criamos um objeto. 
* Além disso, podemos nos referir ao objeto recém-criado usando uma interface (usando uma abstração). 
* Para simplificar e encapsular a criação da conexão, devemos usar uma classe “ConnectionFactory”. 
* A classe ConnectionFactory segue o padrão de criação Factory Method.
* O Factory Method encapsula a criação de um objeto.
### Removendo dados
* Foram aplicados três comandos básicos do SQL (DELETE, INSERT E O SELECT).
### Evitando SQL Injection
* O PreparedStatement mantém a consulta compilada no banco de dados, para o usuário que necessitar realizar a mesma consulta, 
* diversas vezes, com parâmetros diferentes. 
* Ao executar SQL como Statement, temos um risco de segurança, chamado de SQL Injection;
* SQL Injection nada mais é do que passar um novo comando SQL como parâmetro.
* Para evitar SQL Injection, devemos usar a interface PreparedStatement;
* Diferentemente do Statement, o PreparedStatement trata (sanitiza) cada parâmetro do comando SQL.
### Listagem de remoção
* Precisamos alterar a interface de Statement para PreparedStatement.
* A interface Statement não conhece o método setString, pois o mesmo é da interface PreparedStatement.
* Mais um Refactory feito no código.
### JDBC e transações
* O padrão do JDBC (ou seja do driver) para lidar com transações e o banco de dados?
* Esse é o padrão, que pode ser alterado pelo método setAutoCommit, da interface Connection.
### Auto-Commit
* O banco de dados oferece um recurso chamado de transação, para juntar várias alterações como unidade de trabalho.
* Se uma alteração falha, nenhuma alteração é aplicada (é feito um rollback da transação);
* Todas as alterações precisam funcionar para serem aceitas (é feito um commit), commit e rollback são operações clássicas de transações.
* Setando o Auto-Commit para "false". Explicitando o commit, assim como em caso de erro, o rollback precisará estar explícito.
### Usando o try-with-resources
* Para garantir o fechamento dos recursos, existe no Java uma cláusula try-with-resource. O recurso em questão deve usar a interface Autoclosable
* Na hora de tratar uma exceção ele não sair do bloco, enfim, o “try-with-resources” vai servir para isso. 
* Além de ficar com um código mais bonito, ele vem com esse benefício de tirar da nossa responsabilidade explicitar esses fechamentos.
* Try com recursos e o close, ao utilizar o try-with-resources, não é mais necessário explicitar o close para fechar o statements (ResultSet, Connection, PreparedStatement)?
* Pelo fato dos statements estenderem AutoCloseable, o try-with-resources executa o método close sem que precise estar explícito.
### Testando o pool de conexões
* Para conseguirmos testar o nosso Pool de conexões, a primeira coisa que teremos que fazer é ir na ConnectionFactory, nas configurações do Pool.
* Vou definir ele como comboPooledDataSource.setMaxPoolSize(15);. Então quando eu instanciar a minha Connection factory, 
* Ao carregar minhas informações no Pool, eu quero que ele já carregue o Pool com 15 conexões disponíveis.
* Vou fazer um for (int i = 0; i < 20; i++), eu quero requisitar 20 conexões. Eu quero fazer 20 requisições para o meu Pool de conexões.



package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Clientes;

public class ClientesDAO {
    // atributo
    private Connection connection;
    private List<Clientes> clientes;

    // construtor
    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes_lojacarros (NOME VARCHAR(255), IDADE VARCHAR(2), CPF VARCHAR(14) PRIMARY KEY, EMAIL VARCHAR(255), TELEFONE VARCHAR(255), ENDERECO VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela Clientes criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Clientes> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        clientes = new ArrayList<>();
        // Cria uma lista para armazenar os clientes recuperados do banco de dados
        try {
            String sql = "SELECT * FROM clientes_lojacarros";
            stmt = connection.prepareStatement(sql);

            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto clientes com os valores do
                // registro

                Clientes cliente = new Clientes(
                        rs.getString("nome"),
                        rs.getString("idade"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("endereco"));
                clientes.add(cliente); // Adiciona o objeto Cliente à lista de clientes
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return clientes; // Retorna a lista de clientes recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String nome, String idade, String cpf, String email, String telefone, String endereco) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO clientes_lojacarros (nome, idade, cpf, email, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, idade);
            stmt.setString(3, cpf);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            stmt.setString(6, endereco);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String nome, String idade, String cpf, String email, String telefone, String endereco) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela placa
        String sql = "UPDATE clientes_lojacarros SET nome = ?, idade = ?, email = ?, telefone = ?, endereco = ? WHERE cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, idade);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setString(5, endereco);
            // cpf é chave primaria não pode ser alterada.
            stmt.setString(6, cpf);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String cpf) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pelo cpf
        String sql = "DELETE FROM clientes_lojacarros WHERE cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}

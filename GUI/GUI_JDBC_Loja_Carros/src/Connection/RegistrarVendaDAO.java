package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.RegistrarVenda;

public class RegistrarVendaDAO {
    // atributo
    private Connection connection;
    private List<RegistrarVenda> vendas;

    // construtor
    public RegistrarVendaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS vendas_lojacarros (MARCA VARCHAR(255), MODELO VARCHAR(255), PRECO VARCHAR(255), PLACA VARCHAR(255) PRIMARY KEY, NOME VARCHAR(255), DATA_NASCIMENTO VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de Vendas criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<RegistrarVenda> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        vendas = new ArrayList<>();
        // Cria uma lista para armazenar as vendas recuperados do banco de dados
        try {
            String sql = "SELECT * FROM vendas_lojacarros";
            stmt = connection.prepareStatement(sql);

            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto vendas com os valores do
                // registro

                RegistrarVenda venda = new RegistrarVenda(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("preco"),
                        rs.getString("placa"),
                        rs.getString("nome"),
                        rs.getString("dataVenda"));
                vendas.add(venda); // Adiciona o objeto venda à lista de vendas
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return vendas; // Retorna a lista de vendas recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String marca, String modelo, String preco, String placa, String nome, String dataVenda) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO vendas_lojacarros (marca, modelo, preco, placa, nome, dataVendas) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setString(3, preco);
            stmt.setString(4, placa);
            stmt.setString(5, nome);
            stmt.setString(6, dataVenda);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}

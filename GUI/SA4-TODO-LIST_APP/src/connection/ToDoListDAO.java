package connection;

import java.util.ArrayList;
import java.util.List;

import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ToDoListDAO {

    private Connection connection;
    private List<Task> tasks;

    public ToDoListDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Método para criar a tabela no banco de dados
    public void criaTabela() {
        // Define a instrução SQL para criar a tabela MINHA_TABELA se não existir
        String sql = "CREATE TABLE IF NOT EXISTS ToDoList(ID SERIAL PRIMARY KEY,TAREFA VARCHAR(255),CONCLUSAO BOOLEAN)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql); // Executa a instrução SQL
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            // Captura exceções relacionadas a erros no banco de dados
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection); // Fecha a conexão
        }
    }

    // Método para inserir dados com um ID especifíco
    public void cadastrar(String tarefa, boolean conclusao) {
        // Define a instrução SQL parametrizada para inserir dados com ID
        String sql = "INSERT INTO ToDoList(tarefa, conclusao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa);
            stmt.setBoolean(2, conclusao);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para apagar um dado da tabela com base em um ID
    // específico
    public void apagar(int id) {
        // Define a instrução SQL parametrizada para apagar dados por ID
        String sql = "DELETE FROM ToDoList WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dados apagados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para atualizar dados na tabela com base em um ID
    // específico
    public void atualizar(int id, String tarefa, boolean conclusao) {
        // Define a instrução SQL parametrizada para atualizar dados por ID
        String sql = "UPDATE ToDoList SET tarefa = ?, conclusao = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa);
            stmt.setBoolean(2, conclusao);
            stmt.setInt(3, id);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para listar todos os valores cadastrados na tabela
    public List<Task> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        tasks = new ArrayList<>();
        // Cria uma lista para armazenar as tarefas recuperados do banco de dados
        try {
            String sql = "SELECT * FROM ToDoList";
            stmt = connection.prepareStatement(sql);

            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Carros com os valores do
                // registro

                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("tarefa"),
                        rs.getBoolean("conclusao"));
                tasks.add(task); // Adiciona o objeto Carros à lista de carros
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return tasks; // Retorna a lista de carros recuperados do banco de dados
    }
}
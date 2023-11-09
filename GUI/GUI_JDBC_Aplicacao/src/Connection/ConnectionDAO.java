package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDAO {
    private Connection connection;

    public ConnectionDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Método para criar a tabela no banco de dados
    public void criaTabela() {
        // Define a instrução SQL para criar a tabela MINHA_TABELA se não existir
        String sql = "CREATE TABLE IF NOT EXISTS minha_tabelinha (ID SERIAL PRIMARY KEY,NOME VARCHAR(255),EMAIL VARCHAR(255))";
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

    // Método para apagar a tabela do banco de dados
    public void apagarTabela() {
        // Define a instrução SQL para apagar a tabela Minha_Tabela
        String sql = "DROP TABLE minha_tabelinha";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql); // Executa a instrução SQL
            System.out.println("Tabela apagada com sucesso.");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao apagar tabela.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para inserir dados com um ID especifíco
    public void inserir(String nome, String email) {
        // Define a instrução SQL parametrizada para inserir dados com ID
        String sql = "INSERT INTO minha_tabela (NOME, EMAIL) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para buscar dados na tabela com base em um ID
    // específico
    public void buscarPorId(int id) {
        // Define a instrução SQL parametrizada para buscar dados por ID
        String sql = "SELECT * FROM MINHA_TABELA WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery(); // Executa a consulta e obtém resultados

            while (resultSet.next()) {
                int idBuscado = resultSet.getInt("ID");
                String nomeBuscado = resultSet.getString("NOME");
                String emailBuscado = resultSet.getString("EMAIL");
                System.out.println(
                        "O resultado da busca é id " + idBuscado + " nome: " + nomeBuscado + " email: " + emailBuscado);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para apagar um dado da tabela com base em um ID
    // específico
    public void apagarID(int id) {
        // Define a instrução SQL parametrizada para apagar dados por ID
        String sql = "DELETE FROM Minha_Tabela WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para atualizar dados na tabela com base em um ID
    // específico
    public void atualizarID(int id, String novoNome, String novoEmail) {
        // Define a instrução SQL parametrizada para atualizar dados por ID
        String sql = "UPDATE Minha_Tabela SET nome = ?, email = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setString(2, novoEmail);
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
    public void listarTodos() {
        ResultSet rs = null;
        // Define a instrução SQL para selecionar todos os registros da tabela
        String sql = "SELECT * FROM minha_tabela";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            rs = stmt.executeQuery(); // Executa a consulta e obtém resultados
            while (rs.next()) {
                System.out.println("id : " + rs.getInt("id") +
                        " nome: " + rs.getString("nome") +
                        " email: " + rs.getString("email"));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }
}
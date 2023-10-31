package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
    
    private static final String url = "jdbc:postgressql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "postgres";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeErrorException(null, "Erro ao obter conexão com o banco de dados: "+ e.getMessage());
        }
    }

    public static void closeConnection(Connection connection) {
    }
}

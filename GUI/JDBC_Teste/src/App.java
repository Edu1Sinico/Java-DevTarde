import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Statement stmt;
            String usuario = "postgres";
            String senha = "postgres";
            String url = "jdbc:postgresql://localhost:5432/postgres";

            Connection con = DriverManager.getConnection(url, usuario, senha);
            stmt = con.createStatement();
            stmt.executeQuery("INSERT INTO contato VALUES ('3','João Memes','joãoMemes@hotmail.com')");


            // stmt.executeQuery("DELETE FROM contato WHERE ID = ?");


            con.close();
        } catch (Exception e) {
            System.err.println("\n " + e);
        }
    }
}

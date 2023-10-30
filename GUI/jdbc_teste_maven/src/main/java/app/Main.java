package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Statement stmt;
            String usuario = "postgres";
            String senha = "postgres";
            String url = "jdbc:postgresql://localhost:5432/postgres";

            Connection con = DriverManager.getConnection(url, usuario, senha);
            stmt = con.createStatement();
            stmt.executeQuery("INSERT INTO contato VALUES ('3','João Memes','JoãoMemes@hotmail.com')");

            con.close();
        } catch (Exception e) {
            System.err.println("\n " + e);
        }
    }
}
package Connection;

import java.sql.Connection;
import java.util.List;

public class RegistrarVendaDAO {
    // atributo
    private Connection connection;
    private List<Carros> carros;

    // construtor
    public RegistrarVendaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
}

package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;

import java.awt.*;
import java.util.List;

import Model.Carros;
import Model.Clientes;

public class JanelaRegistarVenda extends JPanel {
    JComboBox<String> carrosComboBox, clienteComboBox;
    List<Carros> carros;
    List<Clientes> clientes;
    DefaultTableModel tableModel;
    JTable table;
    JPanel painelTop;
    JButton vender;

    public JanelaRegistarVenda() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro de Vendas"));

        painelTop = new JPanel();

        carrosComboBox = new JComboBox<>();
        // preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione um Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca()
                    + " - " + carro.getModelo() + " - " + carro.getPreco() +" - " + carro.getPlaca());

        }

        // preencha o JComboBox com os clientes
        clienteComboBox = new JComboBox<>();
        clientes = new ClientesDAO().listarTodos();
        clienteComboBox.addItem("Selecione um Cliente");
        for (Clientes cliente : clientes) {
            clienteComboBox.addItem(cliente.getNome());
        }

        vender = new JButton("Vender");

        painelTop.add(carrosComboBox);
        painelTop.add(clienteComboBox);
        painelTop.add(vender);

        add(painelTop);

        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Marca", "Modelo", "Placa", "Preço", "Comprador", "Vendido" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

    }

}
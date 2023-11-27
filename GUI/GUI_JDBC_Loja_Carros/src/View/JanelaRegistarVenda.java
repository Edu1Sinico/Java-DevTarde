package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Connection.RegistrarVendaDAO;
import Controller.CarrosControl;
import Controller.RegistrarVendaControl;
import Exception.CarValidationException;
import Exception.LimitedYearException;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.List;

import Model.Carros;
import Model.Clientes;
import Model.RegistrarVenda;

public class JanelaRegistarVenda extends JPanel {
    JComboBox<String> carrosComboBox, clienteComboBox;
    List<Carros> carros;
    List<Clientes> clientes;
    List<RegistrarVenda> vendas;
    DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    JTable table;
    JPanel painelTop;
    JButton vender;
    private Calendar calendario = Calendar.getInstance(); // Cria uma variável de calendario buscando sua instancia
    private int anoAtual = calendario.get(Calendar.YEAR);
    private int diaAtual = calendario.get(Calendar.DAY_OF_MONTH);
    private int mesAtual = calendario.get(Calendar.MONTH);

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
                    + " - " + carro.getModelo() + " - " + carro.getPlaca() + " - " + carro.getPreco());

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
                new String[] { "Marca", "Modelo", "Placa", "Preço", "Comprador", "Data da Venda" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela
        new RegistrarVendaDAO().criaTabela();

        // Atualizar a tabela
        atualizarTabela();

        // selecionar os elementos nas linhas da tabela
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {

                    String marca = (String) table.getValueAt(linhaSelecionada, 0);
                    String modelo = (String) table.getValueAt(linhaSelecionada, 1);
                    String placa = (String) table.getValueAt(linhaSelecionada, 2);
                    String cliente = (String) table.getValueAt(linhaSelecionada, 3);
                    String valor = (String) table.getValueAt(linhaSelecionada, 4);
                    String data = (String) table.getValueAt(linhaSelecionada, 5);
                }
            }
        });

        RegistrarVendaControl operacoes = new RegistrarVendaControl(vendas, tableModel, table);
        // TRATAMENTOS DE EVENTOS

        // Vender
        vender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(carrosComboBox.getSelectedItem().toString().equals("Selecione um Carro")
                        || clienteComboBox.getSelectedItem().toString().equals("Selecione um Cliente"))) {

                    String dataAtual = diaAtual + "/" + (mesAtual + 1) + "/" + anoAtual;

                    String[] detalhesCarro = carrosComboBox.getSelectedItem().toString().split(" - ");

                    // Verifica se os detalhes do carro têm o formato esperado
                    if (detalhesCarro.length >= 4) { // Supondo que os detalhes incluam pelo menos marca, modelo, valor
                                                     // e placa
                        String marca = detalhesCarro[0];
                        String modelo = detalhesCarro[1];
                        String valor = detalhesCarro[2];
                        String placa = detalhesCarro[3];

                        for (RegistrarVenda venda : vendas) {

                            venda.setMarca(marca);
                            venda.setModelo(modelo);
                            venda.setPreco(placa);
                            venda.setPlaca(placa);

                            if (placa.equals(venda.getPlaca())) {
                                JOptionPane.showMessageDialog(null,
                                        "Carro já vendidom por favor, selecione outro modelo.", "Aviso!",
                                        JOptionPane.WARNING_MESSAGE);
                            } else {
                                Object[] vendaInfo = { marca, modelo, valor, placa,
                                        (String) clienteComboBox.getSelectedItem(),
                                        dataAtual };
                                tableModel.addRow(vendaInfo);

                                System.out.println(
                                        "Marca: " + marca + " modelo: " + modelo + " valor: " + valor + " placa: "
                                                + placa + " nome: " + (String) clienteComboBox.getSelectedItem()
                                                + " Data Atual: "
                                                + dataAtual);

                                // Limpe os JComboBox após a venda ser registrada
                                carrosComboBox.setSelectedIndex(0);
                                clienteComboBox.setSelectedIndex(0);

                                operacoes.cadastrar(marca, modelo, valor, placa,
                                        (String) clienteComboBox.getSelectedItem(), dataAtual);
                            }
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma das opções de cliente ou produto.",
                            "Atenção!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new RegistrarVendaDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (RegistrarVenda venda : vendas) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getMarca(), venda.getModelo(),

                    venda.getPreco(), venda.getPlaca(), venda.getNome(), venda.getDataVendas() });
        }
    }

}
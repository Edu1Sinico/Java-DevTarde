package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.table.DefaultTableModel;

import control.OperacoesConsulta;
import control.SerializacaoConsulta;
import model.AgendarConsulta;

import java.util.ArrayList;
import java.util.List;

public class CadastroConsulta extends JPanel {
    private JTextField inputHora;
    private JTextField inputData;
    private JTextField inputDesc;
    private DefaultTableModel tableModel;
    private JTable table;
    private List<AgendarConsulta> agendarConsultaList = new ArrayList<>();
    private int linhaSelecionada = -1;

    public CadastroConsulta() {
        // Set do Frame
        setSize(600, 300);
        setVisible(true);

        // Set da Tabela;
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Hora");
        tableModel.addColumn("Data");
        tableModel.addColumn("Descrição");

        // Criação de Tabela
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Montando a input de dados e botões
        inputHora = new JTextField(5);
        inputData = new JTextField(10);
        inputDesc = new JTextField(30);
        JButton cadastrarConsultaButton = new JButton("Cadastrar Consulta");
        JButton atualizarConsultaButton = new JButton("Atualizar");
        JButton apagarConsultaButton = new JButton("Apagar");
        JButton apagarTodasConsultaButton = new JButton("Apagar Todos");
        JButton salvarConsultaButton = new JButton("Salvar");

        // Estruturando o frame
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDesc);
        inputPanel.add(cadastrarConsultaButton);
        inputPanel.add(atualizarConsultaButton);
        inputPanel.add(apagarConsultaButton);
        inputPanel.add(apagarTodasConsultaButton);
        inputPanel.add(salvarConsultaButton);

        // add ao layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Criação do arquivo
        File arquivo = new File("dadosConsulta.txt");
        try {
            if (arquivo.exists()) {
            agendarConsultaList = SerializacaoConsulta.deserializar("dadosConsulta.txt");
            atualizarTabela();
        }
        } catch (NullPointerException e) {
            System.err.println("Erro.");
        }


        // --------------- Ações e Eventos ---------------

        // Evento de Selecionar a linha da tabela em todas as colunas
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputHora.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputData.setText((String) table.getValueAt(linhaSelecionada, 1));
                    inputDesc.setText((String) table.getValueAt(linhaSelecionada, 2));
                }
            }
        });

        // Ação de adicionar o elementos dos Input para a Lista
        OperacoesConsulta operacoes = new OperacoesConsulta(agendarConsultaList, tableModel, table);
        cadastrarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.agendarConsulta(inputHora.getText(), inputData.getText(), inputDesc.getText());
                inputHora.setText("");
                inputData.setText("");
                inputDesc.setText("");
            }
        });

        // Ação para o botão de apagar o item selecionado
        apagarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarConsulta(linhaSelecionada);
            }
        });

        // Ação para o botão apagar todos os itens da tabela
        apagarTodasConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarTodasConsultas();
            }
        });

        // Salvar as informações de consultas
        salvarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarConsulta();
            }
        });
    }

    // Método para atualizar tabela
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (AgendarConsulta consulta : agendarConsultaList) {
            tableModel.addRow(new Object[] { consulta.getHora(), consulta.getData(), consulta.getDesc() });
        }
    }
}

package View;

// Importação básicas
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Controller.CarrosControl;
import Exception.*;
// Importação da Classe
import Model.Carros;

public class JanelaCarrosView extends JPanel {

    private JButton cadastrar, apagar, editar, limpar;
    private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField, carValorField;
    private List<Carros> carros;
    private JComboBox vendidoComboBox;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private Calendar calendario = Calendar.getInstance(); // Cria uma variável de calendario buscando sua instancia
    private int anoAtual = calendario.get(Calendar.YEAR); // Pega o ano atual e armazena em uma variável do tipo
                                                          // inteiro.

    public JanelaCarrosView() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Carros"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Marca"));
        carMarcaField = new JTextField(20);
        inputPanel.add(carMarcaField);
        inputPanel.add(new JLabel("Modelo"));
        carModeloField = new JTextField(20);
        inputPanel.add(carModeloField);
        inputPanel.add(new JLabel("Ano"));
        carAnoField = new JTextField(20);
        inputPanel.add(carAnoField);
        inputPanel.add(new JLabel("Placa"));
        carPlacaField = new JTextField(20);
        inputPanel.add(carPlacaField);
        inputPanel.add(new JLabel("Valor"));
        carValorField = new JTextField(20);
        inputPanel.add(carValorField);
        inputPanel.add(new JLabel("Vendido"));
        vendidoComboBox = new JComboBox();
        vendidoComboBox.addItem("Não Vendido");
        vendidoComboBox.addItem("Vendido");
        inputPanel.add(vendidoComboBox);

        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        add(botoes);
        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Marca", "Modelo", "Ano", "Placa", "Valor", "Vendido" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela
        new CarrosDAO().criaTabela();

        // Atualizar a tabela
        atualizarTabela();

        // Tratamento de eventos;

        // selecionar os elementos nas linhas da tabela
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    carMarcaField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carModeloField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    carAnoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    carPlacaField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    // Desativa o textfield da placa
                    carPlacaField.setEditable(false);
                    // Desativa o botão
                    cadastrar.setEnabled(false);
                    carValorField.setText((String) table.getValueAt(linhaSelecionada, 4));
                    vendidoComboBox.setSelectedItem((String) table.getValueAt(linhaSelecionada, 5));
                } else {
                    // Ativa o textfield da placa
                    carPlacaField.setEditable(true);
                    // Ativa o botão
                    cadastrar.setEnabled(true);
                }
            }
        });

        CarrosControl operacoes = new CarrosControl(carros, tableModel, table);

        // Cadastrar
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "cadastrar" do objeto operacoes com os valores dos

                // campos de entrada
                try {
                    if (!(carMarcaField.getText().isEmpty() || carModeloField.getText().isEmpty()
                            || carAnoField.getText().isEmpty()
                            || carPlacaField.getText().isEmpty() || carValorField.getText().isEmpty())) {

                        for (Carros carro : carros) {
                            if (carPlacaField.getText().equals(carro.getPlaca())) {
                                throw new CarValidationException("Placa já cadastrado, por favor utilize outro placa.");
                            }
                        }

                        int ano = Integer.parseInt(carAnoField.getText());

                        if (carPlacaField.getText().toUpperCase().matches("[A-Z]{3}-\\d{4}")) { // Define uma condição
                                                                                                // para verificar
                            // se o padrão da
                            // placa está entre A e Z com 3
                            // caracteres, se possui um
                            // "-" e colocar \\d de 0 a 9 com 4
                            // caracteres de
                            // tamanho.

                            if (ano > 1900 && ano <= anoAtual + 1) {
                                operacoes.cadastrar(carMarcaField.getText(), carModeloField.getText(),
                                        carAnoField.getText(), carPlacaField.getText().toUpperCase(),
                                        carValorField.getText(),
                                        (String) vendidoComboBox.getSelectedItem());

                                // Limpa os campos de entrada após a operação de cadastro
                                carMarcaField.setText("");
                                carModeloField.setText("");
                                carAnoField.setText("");
                                carPlacaField.setText("");
                                carValorField.setText("");

                            } else {
                                throw new LimitedYearException("Ano Inválido, Por favor digite um ano válido.");
                            }
                        } else {
                            throw new CarValidationException(
                                    "Placa de Carro Inválido, Por favor digite uma placa de carro válida. "
                                            + "\n\n Exemplo: "
                                            + "\n ABC-1234");
                        }
                    } else {
                        throw new NullPointerException(
                                "Informações inválidas. Por favor preencha as informações vazias.");
                    }
                } catch (LimitedYearException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "LimitedYearException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (CarValidationException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "CarValidationException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NullPointerException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro Desconhecido.", "Exception",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        // Limpar campos
        limpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                carMarcaField.setText("");
                carModeloField.setText("");
                carAnoField.setText("");
                carPlacaField.setText("");
                carValorField.setText("");
                vendidoComboBox.setSelectedIndex(0);
                carPlacaField.setEditable(true);
                cadastrar.setEnabled(true);
                table.clearSelection();
            }
        });

        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "atualizar" do objeto operacoes com os valores dos

                // campos de entrada
                try {
                    if (linhaSelecionada != -1) {
                        if (!(carMarcaField.getText().isEmpty() || carModeloField.getText().isEmpty()
                                || carAnoField.getText().isEmpty()
                                || carPlacaField.getText().isEmpty() || carValorField.getText().isEmpty())) {

                            int ano = Integer.parseInt(carAnoField.getText());

                            System.out.println(anoAtual);
                            if (ano > 1900 && ano < anoAtual + 1) {
                                operacoes.atualizar(carMarcaField.getText(), carModeloField.getText(),

                                        carAnoField.getText(), carPlacaField.getText(), carValorField.getText(),
                                        (String) vendidoComboBox.getSelectedItem());
                                // Limpa os campos de entrada após a operação de atualização
                                carMarcaField.setText("");
                                carModeloField.setText("");
                                carAnoField.setText("");
                                carPlacaField.setText("");
                                carValorField.setText("");
                                vendidoComboBox.setSelectedIndex(0);
                                cadastrar.setEnabled(true);
                                carPlacaField.setEditable(true);
                            } else {
                                throw new LimitedYearException("Ano Inválido, Por favor digite um ano válido.");
                            }

                        } else {
                            throw new NullPointerException(
                                    "Informações inválidas. Por favor preencha as informações vazias.");
                        }
                    } else {
                        throw new SelectedTableException("Erro de Seleção, por favor selecione uma linha.");
                    }
                } catch (LimitedYearException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "LimitedYearException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (SelectedTableException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "SelectedTableException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NullPointerException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Formatação inválida, por favor digite somente números válidos.", "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro Desconhecido.", "Exception",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "apagar" do objeto operacoes com o valor do campo de

                // entrada "placa"
                try {
                    if (linhaSelecionada != -1) {
                        if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse cadastro?",
                                "Excluindo cadastros...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            operacoes.apagar(carPlacaField.getText());
                            // Limpa os campos de entrada após a operação de exclusão
                            carMarcaField.setText("");
                            carModeloField.setText("");
                            carAnoField.setText("");
                            carPlacaField.setText("");
                            carValorField.setText("");
                        }
                    } else {
                        throw new SelectedTableException("Erro de Seleção, por favor selecione uma linha.");
                    }
                } catch (SelectedTableException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "SelectedTableException",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        });
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new CarrosDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Carros carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),

                    carro.getAno(), carro.getPlaca(), carro.getPreco(), carro.getVendido() });
        }
    }
}

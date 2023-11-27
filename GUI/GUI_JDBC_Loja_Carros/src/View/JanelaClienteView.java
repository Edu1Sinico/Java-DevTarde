package View;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Controller.ClientesControl;
import Exception.*;
import Model.Carros;
// Importação da Classe
import Model.Clientes;

public class JanelaClienteView extends JPanel {

    // Atributs
    private JButton cadastrar, apagar, editar, limpar;
    private JTextField cliNomeField, cliIdadeField, cliCpfField, cliEmailField, cliTelefoneField, cliEnderecoField;
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public JanelaClienteView() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Clientes"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Nome"));
        cliNomeField = new JTextField(20);
        inputPanel.add(cliNomeField);
        inputPanel.add(new JLabel("Idade"));
        cliIdadeField = new JTextField(20);
        inputPanel.add(cliIdadeField);
        inputPanel.add(new JLabel("CPF"));
        cliCpfField = new JTextField(20);
        inputPanel.add(cliCpfField);
        inputPanel.add(new JLabel("Email"));
        cliEmailField = new JTextField(20);
        inputPanel.add(cliEmailField);
        inputPanel.add(new JLabel("Telefone"));
        cliTelefoneField = new JTextField(20);
        inputPanel.add(cliTelefoneField);
        inputPanel.add(new JLabel("Endereço"));
        cliEnderecoField = new JTextField(20);
        inputPanel.add(cliEnderecoField);


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
                new String[] { "Nome", "Idade", "CPF", "Email", "Telefone", "Endereço" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela
        new ClientesDAO().criaTabela();

        // Atualizar a tabela
        atualizarTabela();

        // Tratamento de eventos;

        // selecionar os elementos nas linhas da tabela
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    cliNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    cliIdadeField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    cliCpfField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    cliEmailField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    cliTelefoneField.setText((String) table.getValueAt(linhaSelecionada, 4));
                    cliEnderecoField.setText((String) table.getValueAt(linhaSelecionada, 5));
                    // Desativa o textfield da cpf
                    cliCpfField.setEditable(false);
                    // Desativa o botão
                    cadastrar.setEnabled(false);
                } else {
                    // Ativa o textfield da placa
                    cliCpfField.setEditable(true);
                    // Ativa o botão
                    cadastrar.setEnabled(true);
                }
            }
        });

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

        // Cadastrar
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "cadastrar" do objeto operacoes com os valores dos

                // campos de entrada
                try {
                    if (!(cliNomeField.getText().isEmpty() || cliIdadeField.getText().isEmpty()
                            || cliCpfField.getText().isEmpty()
                            || cliEmailField.getText().isEmpty() || cliTelefoneField.getText().isEmpty()
                            || cliEnderecoField.getText().isEmpty())) {
                        
                        for (Clientes cliente : clientes) {
                            if (cliCpfField.getText().equals(cliente.getCpf())){
                                throw new CpfValidiationException("CPF já cadastrado, por favor utilize outro CPF.");
                            }
                        }
                            

                        int idade = Integer.parseInt(cliIdadeField.getText());

                        if (cliCpfField.getText().matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {

                            if (idade >= 18 && idade < 120) {
                                operacoes.cadastrar(cliNomeField.getText(), cliIdadeField.getText(),

                                        cliCpfField.getText(), cliEmailField.getText(),
                                        cliTelefoneField.getText(), cliEnderecoField.getText());

                                // Limpa os campos de entrada após a operação de cadastro
                                cliNomeField.setText("");
                                cliIdadeField.setText("");
                                cliCpfField.setText("");
                                cliEmailField.setText("");
                                cliTelefoneField.setText("");
                                cliEnderecoField.setText("");

                            } else {
                                throw new AgeValidationExcepetion(
                                        "Idade inválida, por favor digite uma idade compatível com o Código de Trânsito Brasileiro (CTB), Lei nº 9.503/1997."
                                                + "\n\n A idade tem que estar entre 18 a 120 anos.");
                            }
                        } else {
                            throw new CpfValidiationException(
                                    "CPF inválido, Por favor digite um número de CPF válido. "
                                            + "\n\n Exemplo: "
                                            + "\n 123.456.789-99");
                        }
                    } else {
                        throw new NullPointerException(
                                "Informações inválidas. Por favor preencha as informações vazias.");
                    }
                } catch (AgeValidationExcepetion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "LimitedYearException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (CpfValidiationException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "CarValidationException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NullPointerException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formatação inválida, por favor digite somente números válidos.", "NumberFormatException",
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
                cliNomeField.setText("");
                cliIdadeField.setText("");
                cliCpfField.setText("");
                cliEmailField.setText("");
                cliTelefoneField.setText("");
                cliEnderecoField.setText("");
                cliCpfField.setEditable(true);
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
                        if (!(cliNomeField.getText().isEmpty() || cliIdadeField.getText().isEmpty()
                                || cliCpfField.getText().isEmpty()
                                || cliEmailField.getText().isEmpty() || cliTelefoneField.getText().isEmpty()
                                || cliEnderecoField.getText().isEmpty())) {

                            int idade = Integer.parseInt(cliIdadeField.getText());

                            if (idade >= 18 && idade < 120) {
                                operacoes.atualizar(cliNomeField.getText(), cliIdadeField.getText(),

                                        cliCpfField.getText(), cliEmailField.getText(),
                                        cliTelefoneField.getText(), cliEnderecoField.getText());
                                // Limpa os campos de entrada após a operação de atualização
                                cliNomeField.setText("");
                                cliIdadeField.setText("");
                                cliCpfField.setText("");
                                cliEmailField.setText("");
                                cliTelefoneField.setText("");
                                cliEnderecoField.setText("");
                                cadastrar.setEnabled(true);
                                cliCpfField.setEditable(true);
                            } else {
                                throw new AgeValidationExcepetion(
                                        "Idade inválida, por favor digite uma idade compatível com o Código de Trânsito Brasileiro (CTB), Lei nº 9.503/1997."
                                                + "\n\n A idade tem que estar entre 18 a 120 anos.");
                            }
                        } else {
                            throw new NullPointerException(
                                    "Informações inválidas. Por favor preencha as informações vazias.");
                        }
                    } else {
                        throw new SelectedTableException("Erro de Seleção, por favor selecione uma linha.");
                    }
                } catch (AgeValidationExcepetion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "LimitedYearException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (SelectedTableException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "SelectedTableException",
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

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "apagar" do objeto operacoes com o valor do campo de

                // entrada "placa"
                try {
                    if (linhaSelecionada != -1) {
                        if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse cadastro?",
                                "Excluindo Tarefa...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            operacoes.apagar(cliCpfField.getText());
                            // Limpa os campos de entrada após a operação de exclusão
                            cliNomeField.setText("");
                            cliIdadeField.setText("");
                            cliEmailField.setText("");
                            cliCpfField.setText("");
                            cliTelefoneField.setText("");
                            cliEnderecoField.setText("");
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
        clientes = new ClientesDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getIdade(),

                    cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco() });
        }
    }
}

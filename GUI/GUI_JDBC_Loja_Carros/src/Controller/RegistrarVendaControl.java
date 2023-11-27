package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.RegistrarVendaDAO;
import Model.RegistrarVenda;

public class RegistrarVendaControl {
    
    private List<RegistrarVenda> vendas;
    private DefaultTableModel tableModel;
    private JTable table;

    public RegistrarVendaControl(List<RegistrarVenda> vendas, DefaultTableModel tableModel, JTable table) {
        vendas = vendas;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela(){
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new RegistrarVendaDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (RegistrarVenda venda : vendas) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getMarca(), venda.getModelo(),

                    venda.getPreco(), venda.getPlaca(), venda.getNome(), venda.getDataVendas()});
        }
    }

    // ATUALIZAR OS MÉTODOS DEPOIS

    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String marca, String modelo, String preco, String placa, String nome, String dataVenda) {
        new RegistrarVendaDAO().cadastrar(marca, modelo, preco, placa, nome, dataVenda);
        // Chama o método de cadastro no banco de dados

        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

}

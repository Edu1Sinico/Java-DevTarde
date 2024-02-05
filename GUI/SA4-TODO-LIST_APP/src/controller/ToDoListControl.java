package controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ToDoListDAO;
import model.Task;

public class ToDoListControl {
    // Atributos
    private List<Task> tasks;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public ToDoListControl(List<Task> tasks, DefaultTableModel tableModel, JTable table) {
        this.tasks = tasks;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        tasks = new ToDoListDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Task task : tasks) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { task.getDescription(), task.isDone()});
        }
    }
    
    // ATUALIZAR OS MÉTODOS DEPOIS

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String tarefa, boolean conclusao ) {
        new ToDoListDAO().cadastrar(tarefa,conclusao);
        // Chama o método de cadastro no banco de dados

        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(int index, String tarefa, boolean conclusao) {
        new ToDoListDAO().atualizar(index, tarefa, conclusao);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um carro do banco de dados
    public void apagar(int index) {
        new ToDoListDAO().apagar(index);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}

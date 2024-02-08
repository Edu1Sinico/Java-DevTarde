package controller;

import java.util.List;

import javax.swing.DefaultListModel;

import connection.ToDoListDAO;
import model.Task;

public class ToDoListControl {
    // Atributos
    private List<Task> tasks;
    private DefaultListModel<String> listModel;

    // Construtor
    public ToDoListControl(List<Task> tasks, DefaultListModel<String> listModel) {
        this.tasks = tasks;
        this.listModel = listModel;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        listModel.clear(); // Limpa todas as linhas existentes na tabela
        tasks = new ToDoListDAO().listarTodos();
    }

    // ATUALIZAR OS MÉTODOS DEPOIS

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String tarefa, boolean conclusao) {
        new ToDoListDAO().cadastrar(tarefa, conclusao);
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

package view;

// Importações
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import javax.swing.*;

import connection.ToDoListDAO;
import controller.ToDoListControl;
import model.Task;

import java.util.ArrayList;
import java.util.List;

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
// Criação do JFrame

public class TodoList extends JFrame {

    // Componentes e Atributos
    ImageIcon imagem = new ImageIcon(getClass().getResource("../resource/iconLixeira.png"));
    public JLabel lIconLixeira = new JLabel(imagem);
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JButton unmarkDoneButton;
    private JButton aboutButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;
    private int cont = 0;

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Construtor
    public TodoList() {
        // Configuração da janela principal
        super("To-Do List App");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Faz nada ao tentar fechar o programa
        this.setSize(470, 350);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Inicializa campos de entrada, botões e JComboBox
        // Inicializa campos de entrada, botões e JComboBox
        taskInputField = new JTextField(30);
        taskInputField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addButton = new JButton("Adicionar");
        addButton.setBackground(Color.GREEN);
        deleteButton = new JButton("Excluir");
        deleteButton.setBackground(Color.RED);
        markDoneButton = new JButton("Concluir");
        markDoneButton.setBackground(Color.GREEN);
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        filterComboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        filterComboBox.setBackground(Color.WHITE);
        clearCompletedButton = new JButton("Limpar Concluídas");
        clearCompletedButton.setBackground(Color.WHITE);
        unmarkDoneButton = new JButton("Desmarcar Tarefa Concluída");
        unmarkDoneButton.setBackground(Color.WHITE);
        aboutButton = new JButton("Sobre");
        aboutButton.setBackground(Color.BLUE);
        aboutButton.setForeground(Color.WHITE);

        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel();
        JPanel inputTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputTop.add(taskInputField);
        inputTop.add(addButton);
        inputPanel.add(inputTop);

        // Adicionando um painel para a parte south do programa
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        // Configurando um segundo painel de botões
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel2.add(unmarkDoneButton);
        buttonPanel2.add(aboutButton);

        // Adicionando o buttonPanel e buttonPanel2 para o bottomPanel
        bottomPanel.add(buttonPanel);
        bottomPanel.add(buttonPanel2);
        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        buttonPanel.add(lIconLixeira);
        // Adiciona o painel principal à janela
        this.add(mainPanel);
        // Configuração de Listener para os Eventos

        new ToDoListDAO().criaTabela();

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

        // ToDoListControl operacoes = new ToDoListControl(tasks, tableModel, table);

        // Tratamento de Eventos

        // Eventos com drag'n'drop

        // Evento de arrastar:
        // Define a fonte de arrastar
        DragSource dragText = DragSource.getDefaultDragSource(); // Declaração no qual o componente será arrastado,
                                                                 // nesse
                                                                 // caso, será o texto da lista.
        DragGestureRecognizer arrastar = dragText.createDefaultDragGestureRecognizer( // Declaração da função de
                                                                                      // arrastar o
                                                                                      // objeto, sendo ele o componente
                                                                                      // "TaskList", que é um JList
                                                                                      // declarado anteriormente.

                taskList, // Escolhendo o componente que será arrastado.
                DnDConstants.ACTION_COPY, // Está função significa que você está copiando o objeto arrastado ao invés de
                                          // movelo. Caso eu deseja mover, eu posso utilizar a ação: "ACTION_MOVE".

                new DragGestureListener() { // Ouvinete que implementa o método "dragGesturesRecognized", ele é acionado
                                            // quando você está arrastando o objeto for reconhecido.

                    public void dragGestureRecognized(DragGestureEvent e) {
                        // Obtém o índice do item selecionado na lista
                        int selectedIndex = taskList.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            String ItemSelecionado = listModel.getElementAt(selectedIndex); // Armazena em uma String a
                                                                                            // posição do item
                                                                                            // selecionado
                            Transferable transferencia = new StringSelection(ItemSelecionado); // Atribuindo a um objeto
                                                                                               // o
                                                                                               // "Transferable",
                                                                                               // elemento
                                                                                               // este que permite a
                                                                                               // tranferêcia de dados
                            e.startDrag(DragSource.DefaultCopyDrop, transferencia, new DragSourceAdapter() {
                            });
                        }
                    }
                });

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Define o alvo de soltar para o icone de lixeira
        DropTarget dropAlvo = new DropTarget(
                lIconLixeira, // Definindo o componente onde pode ser arrastado
                DnDConstants.ACTION_COPY, // especifica que a ação de cópia é permitida quando o item é solto.
                new DropTargetAdapter() { // No "DropTargetAdapter", você implementa o método "drop", que é chamado
                                          // quando o item é solto.
                    public void drop(DropTargetDropEvent event) {
                        Transferable tr = event.getTransferable();
                        if (tr.isDataFlavorSupported(DataFlavor.stringFlavor)) {// Dentro deste método, você verifica se
                                                                                // o
                            // Transferable contém dados com o formato
                            // DataFlavor.stringFlavor. Se contiver, você
                            // chama deleteTask() para executar a
                            // lógica de exclusão da mensagem (ou tarefa)
                            // associada ao item arrastado. Se o formato não
                            // for suportado, o evento é rejeitado.
                            deleteTask();
                            event.dropComplete(true);
                        } else {
                            event.rejectDrop();
                        }
                    }
                });

        // ----------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Evento de WindowListener
        this.addWindowListener(new WindowAdapter() { // Adiciona o ouvinte para o JFrame
            @Override
            public void windowOpened(WindowEvent e) {
                updateTaskList();
            }

            @Override
            public void windowClosing(WindowEvent e) { // Cria o evento de fechar
                close(); // Chama o método de fechar o programa
            }
        });

        // Eventos de Teclado
        // Adicionando tarefa pelo "ENTER"

        taskInputField.addKeyListener(new KeyListener() { // Adicioando o ouvinte de keyListener diretamente para o
                                                          // textField
            public void keyTyped(KeyEvent e) { // Decndo o evento de KeyTyped (Quando a tecla é clicada)
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }

            public void keyPressed(KeyEvent e) {
                // Implemente o que você deseja fazer quando uma tecla é pressionada.
            }

            public void keyReleased(KeyEvent e) {
                // Implemente o que você deseja fazer quando uma tecla é liberada.
            }
        });

        // Botão para exclusão
        taskList.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (taskList.getSelectedIndex() >= 0) { // Verifica se se o índice da lista está selecionado
                    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                        deleteTask(); // Chama o evento de deletar com a mensagem.
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        // Botão para marcar tarefa concluida
        markDoneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markTaskDone();
            }
        });

        // filtrar tarefas pelo combo box
        filterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filterTasks();
            }
        });

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Criando Instâncias dos Handlers
        DeleteClick dltClick = new DeleteClick();
        AddClick addClick = new AddClick();
        ClearCheckClick clearClick = new ClearCheckClick();
        UnmarkTaskClick unmarkClick = new UnmarkTaskClick();
        AboutClick abtClick = new AboutClick();

        // Adicionando o Handler como ouvinte de ação patra os Botões
        deleteButton.addMouseListener(dltClick);
        addButton.addMouseListener(addClick);
        clearCompletedButton.addMouseListener(clearClick);
        unmarkDoneButton.addMouseListener(unmarkClick);
        aboutButton.addMouseListener(abtClick);
    }

    ToDoListControl listControl = new ToDoListControl(tasks, listModel);
    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Criação de Handlers para receberem o eventos de MouseListener

    // Handler de MouseListener para os botões
    // Evento de exclusão para o mouse
    public class DeleteClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (taskList.getSelectedIndex() >= 0) {
                deleteTask();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

    }

    // Evento de adição para o mouse
    public class AddClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            addTask();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    // Evento de limpar para o mouse
    public class ClearCheckClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            clearCompletedTasks();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    // Evento de desmarcar tarefa para o mouse
    public class UnmarkTaskClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedIndex = taskList.getSelectedIndex();
            String selectedValue = taskList.getSelectedValue();
            if (selectedIndex >= 0 && selectedIndex < tasks.size()) {

                for (Task task : tasks) {
                    String[] parts = selectedValue.split(" ");

                    if (parts[1].equals(task.getDescription())) {
                        unmarkTaskDone();
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    // Evento para abrir a página de "Sobre nós com o mouse"
    public class AboutClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            aboutPage();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Criação de Métodos

    // Criação do método de adicionar lista.
    private void addTask() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = taskInputField.getText().trim();// remove espaços vazios
        Task newTask = new Task(taskDescription);

        if (!taskDescription.isEmpty()) {
            cont++;
            tasks = new ToDoListDAO().listarTodos();

            for (Task task : tasks) {
                newTask = new Task(taskDescription);
            }

            tasks.add(newTask);
            listControl.cadastrar(taskDescription, newTask.isDone());
            updateTaskList();
            taskInputField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, adicione uma tarefa!", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    // Método de Exclusão
    private void deleteTask() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Excluir Essa Tarefa?",
                "Excluindo Tarefa...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            // Exclui a task selecionada da lista de tasks
            int selectedIndex = taskList.getSelectedIndex();
            String selectedValue = taskList.getSelectedValue();
            if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
                tasks.remove(selectedIndex);
                tasks = new ToDoListDAO().listarTodos();
                for (Task task : tasks) {
                    String[] parts = selectedValue.split(" ");

                    if (parts[1].equals(task.getDescription())) {
                        listControl.apagar(task.getId());
                    }
                }
                updateTaskList();
                // if (!tasks.isEmpty()) {
                // if (selectedIndex < tasks.size()) {
                // for (int i = selectedIndex; i < tasks.size(); i++) {
                // tasks.get(i).setDescription((i + 1) + ". " +
                // tasks.get(i).getDescription().substring(3));
                // }
                // }
                // cont = tasks.size(); // redefine o contador para o tamanho atual da lista
                // } else {
                // cont = 0; // redefine o contador se a lista estiver vazia
                // }
            }
        }
    }

    // Método de Marcação
    private void markTaskDone() {
        // Marca a task selecionada como concluída
        int selectedIndex = taskList.getSelectedIndex();
        String selectedValue = taskList.getSelectedValue();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {

            for (Task task : tasks) {
                String[] parts = selectedValue.split(" ");

                if (parts[1].equals(task.getDescription())) {
                    listControl.atualizar(task.getId(), task.getDescription(), true);
                    System.out.println(task.isDone());
                    updateTaskList();
                }
            }
        }
    }

    // Método de Desmarcação
    private void unmarkTaskDone() {
        if (JOptionPane.showConfirmDialog(null, "Deseja desmarcar essa tarefa concluída?",
                "Desmarcando Tarefa...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // Desfaz a marcação da task selecionada
            int selectedIndex = taskList.getSelectedIndex();
            String selectedValue = taskList.getSelectedValue();
            if (selectedIndex >= 0 && selectedIndex < tasks.size()) {

                for (Task task : tasks) {
                    String[] parts = selectedValue.split(" ");

                    if (parts[1].equals(task.getDescription())) {
                        listControl.atualizar(task.getId(), task.getDescription(), false);
                        updateTaskList();
                    }
                }
            }
        }
    }

    // Método de Filtro
    private void filterTasks() {
        // Filtra as tasks com base na seleção do JComboBox

        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") &&
                    !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
            }
        }
    }

    // Método de Limpar Tarefas Concluídas
    private void clearCompletedTasks() {
        // Limpa todas as tasks concluídas da lista
        for (Task task : tasks) {
            if (task.isDone()) {
                if (JOptionPane.showConfirmDialog(null, "Deseja apagar todas as tarefas concluídas?",
                        "Remover Tarefas Concluídas...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    listControl.apagar(task.getId());
                }
            }
        }
        updateTaskList();
    }

    // Método de Atualizar Página
    private void updateTaskList() {
        // Atualiza a lista de tasks exibida na GUI
        listModel.clear();
        tasks = new ToDoListDAO().listarTodos();
        for (Task task : tasks) {
            listModel.addElement(task.getId() + ". " + task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
        }
    }

    // Método de Rodar o Programa
    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }

    // Método de Exibir Uma Mensagem ao Fechar Programa
    public void close() {
        if (JOptionPane.showConfirmDialog(null, "Deseja sair do programa?",
                "Saindo...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }

    // Método Céditos
    public void aboutPage() {
        JOptionPane.showMessageDialog(null, "Sobre o Programa:\n\n"
                + "Version: 0.3\n"
                + "Java JDK 18\n\n"
                + "Professor: Diogo Takamori\n"
                + "Colaboradores: Ezequiel e Eduardo\n\n"
                + "2023 ©Copyright", "Sobre o Programa", JOptionPane.INFORMATION_MESSAGE);
    }
}

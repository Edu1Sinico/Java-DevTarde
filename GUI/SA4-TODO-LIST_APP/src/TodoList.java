import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoList extends JFrame {

    ImageIcon imagem = new ImageIcon(getClass().getResource("resource/iconLixeira.png"));
    public JLabel lIconLixeira = new JLabel(imagem);

    // Atributos
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;

    private List<Task> tasks;

    public TodoList() {
        // Configuração da janela principal
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(460, 300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });

        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicializa campos de entrada, botões e JComboBox
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");

        // Adcionar Tarefa pelo ENTER
        taskInputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
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

        deleteButton = new JButton("Excluir");

        taskList.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    deleteBtnMessage();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        markDoneButton = new JButton("Concluir");

        markDoneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markTaskDone();
            }
        });

        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas",
                "Concluídas" });

        // filtrar tarefas pelo combo box
        filterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filterTasks();
            }
        });

        clearCompletedButton = new JButton("Limpar Concluídas");
        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(lIconLixeira);
        // Adiciona o painel principal à janela
        this.add(mainPanel);
        // Configuração de Listener para os Eventos

        // Crie uma instância dos Handlers
        DeleteClick dltClick = new DeleteClick();
        AddClick addClick = new AddClick();
        ClearCheckClick ClearClick = new ClearCheckClick();

        // Adicione o Handler como ouvinte de ação para o botão 'ok'
        deleteButton.addMouseListener(dltClick);
        addButton.addMouseListener(addClick);
        clearCompletedButton.addMouseListener(ClearClick);
    }

    // Criação de Listas e eventos

    // Criação do método de adicionar lista.
    private void addTask() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = taskInputField.getText().trim();// remove espaços vazios
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    private void deleteTask() {
        // Exclui a task selecionada da lista de tasks
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            tasks.remove(selectedIndex);
            updateTaskList();
        }
    }

    private void markTaskDone() {
        // Marca a task selecionada como concluída
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    private void filterTasks() {
        // Filtra as tasks com base na seleção do JComboBox
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") &&
                    !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    private void clearCompletedTasks() {
        // Limpa todas as tasks concluídas da lista
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
        updateTaskList();
    }

    private void updateTaskList() {
        // Atualiza a lista de tasks exibida na GUI
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
        }
    }

    // Handler de MouseListener para os botões
    public class DeleteClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            deleteBtnMessage();

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

    // Método
    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }

    // Método de fechar
    public void close() {
        if (JOptionPane.showConfirmDialog(null, "Você deseja sair?",
                "Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Obrigado por utilizar o meu programa!", "Agradecimentos",
                    JOptionPane.INFORMATION_MESSAGE);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }

    // Método de exibir um ShowConfirmDialog
    public void deleteBtnMessage() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Excluir Essa Tarefa?",
                "Exclui", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            deleteTask();
        }
    }

}

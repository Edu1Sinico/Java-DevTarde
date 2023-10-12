
// Importações
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
// Criação do JFrame

public class TodoList extends JFrame {

    // Atributos
    ImageIcon imagem = new ImageIcon(getClass().getResource("resource/iconLixeira.png"));
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
        this.setSize(465, 350);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Evento de WindowListener

        this.addWindowListener(new WindowAdapter() { // Adiciona o ouvinte para o JFrame
            @Override
            public void windowClosing(WindowEvent e) { // Cria o evento de fechar
                close(); // Chama o método de fechar o programa
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
        taskInputField = new JTextField(30);
        taskInputField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Adicionando tarefa pelo "ENTER"

        addButton = new JButton("Adicionar");

        taskInputField.addKeyListener(new KeyListener() { // Adicioando o ouvinte de keyListener diretamente para o
                                                          // textField
            public void keyTyped(KeyEvent e) { // Declarando o evento de KeyTyped (Quando a tecla é clicada)
                if (e.getKeyChar() == KeyEvent.VK_ENTER) { // Adicionando um leitor que possui um mapa da tecla "Enter".
                    addTask(); // Chama o método adicionar task
                }
            }

            public void keyPressed(KeyEvent e) {
                // Implemente o que você deseja fazer quando uma tecla é pressionada.
            }

            public void keyReleased(KeyEvent e) {
                // Implemente o que você deseja fazer quando uma tecla é liberada.
            }
        });

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Exclusão de tarefa pela tecla "DELETE"

        deleteButton = new JButton("Excluir");

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

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

        markDoneButton = new JButton("Concluir");

        markDoneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markTaskDone();
            }
        });

        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas",
                "Concluídas" });

        filterComboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // filtrar tarefas pelo combo box
        filterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filterTasks();
            }
        });

        clearCompletedButton = new JButton("Limpar Concluídas");
        unmarkDoneButton = new JButton("Desmarcar Tarefa Concluída");
        aboutButton = new JButton("Sobre");

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

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Crie uma instância dos Handlers

        DeleteClick dltClick = new DeleteClick();
        AddClick addClick = new AddClick();
        ClearCheckClick clearClick = new ClearCheckClick();
        UnmarkTaskClick unmarkClick = new UnmarkTaskClick();
        AboutClick abtClick = new AboutClick();

        // Adicione o Handler como ouvinte de ação para o botão 'ok'
        deleteButton.addMouseListener(dltClick);
        addButton.addMouseListener(addClick);
        clearCompletedButton.addMouseListener(clearClick);
        unmarkDoneButton.addMouseListener(unmarkClick);
        aboutButton.addMouseListener(abtClick);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------
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
                        Transferable tr = event.getTransferable(); // Dentro deste método, você verifica se o
                                                                   // Transferable contém dados com o formato
                                                                   // DataFlavor.stringFlavor. Se contiver, você
                                                                   // chama deleteTask() para executar a
                                                                   // lógica de exclusão da mensagem (ou tarefa)
                                                                   // associada ao item arrastado. Se o formato não
                                                                   // for suportado, o evento é rejeitado.
                        if (tr.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                            deleteTask();
                            event.dropComplete(true);
                        } else {
                            event.rejectDrop();
                        }
                    }
                });

    }

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Criação do método de adicionar lista.
    private void addTask() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = taskInputField.getText().trim();// remove espaços vazios
        cont++;
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(cont + ". " + taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    private void deleteTask() {
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir está tarefa?", // Um showConfirmDialog para confirmar se
                                                                               // a pessoa realmente quer excluir a
                                                                               // tarefa.
                "Exclui", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            // Exclui a task selecionada da lista de tasks
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
                tasks.remove(selectedIndex);
                updateTaskList();
            }
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

    private void unmarkTaskDone() {
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente desmarcar a tarefa concluída?",
                "Desmarcar tarefa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // Desfaz a marcação da task selecionada
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
                Task task = tasks.get(selectedIndex);
                task.setDone(false);
                updateTaskList();
            }
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

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Criação de Handlers para receberem o eventos de MouseListener

    // Handler de MouseListener para os botões
    public class DeleteClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            deleteTask();
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

    public class UnmarkTaskClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            for (Task task : tasks) {
                if (taskList.getSelectedIndex() >= 0 && task.isDone())
                    unmarkTaskDone();
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
    // Outros métodos simples

    // Método de rodar o programa
    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }

    // Método de exibir uma mensagem ao fechar programa
    public void close() {
        if (JOptionPane.showConfirmDialog(null, "Deseja sair do programa?",
                "Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso programa!");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }

    public void aboutPage() {
        JOptionPane.showMessageDialog(null, "Sobre o Programa:\n\n"
                + "Version: 0.1\n"
                + "Java JDK 18\n\n"
                + "Professor: Diogo Takamori\n"
                + "Colaboradores: Ezequiel e Eduardo\n\n"
                + "2023 ©Copyright", "Sobre o Programa", JOptionPane.INFORMATION_MESSAGE);
    }
}

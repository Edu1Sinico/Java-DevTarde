import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Exercicio5CardLayout extends JFrame {
    int cont = 0;

    public Exercicio5CardLayout() {
        super("Quiz dos Memes!");
        // Criação de um painel principal com Card Layout
        JPanel mainPanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);
        EmptyBorder bordaBotao = new EmptyBorder(5, 20, 5, 20);

        // Criação de cards e declarando layouts para eles
        JPanel cardMain = new JPanel(new BorderLayout());
        JPanel cardQuiz1 = new JPanel(new BorderLayout());
        JPanel cardQuiz2 = new JPanel(new BorderLayout());
        JPanel cardQuiz3 = new JPanel(new BorderLayout());
        JPanel cardQuiz4 = new JPanel(new BorderLayout());
        JPanel cardQuiz5 = new JPanel(new BorderLayout());
        JPanel cardResults = new JPanel(new BorderLayout());

        // Decorando a tela de inicio
        // Criando os JPanels
        JPanel centerMainJPanel = new JPanel(new BorderLayout());
        JPanel topSubJPanel = new JPanel();
        JPanel bottomSubJPanel = new JPanel();

        // título da página inicial
        topSubJPanel.add(new JLabel("Bem vindo ao Quiz dos Memes"));

        // botão de iniciar
        JButton btnStart = new JButton("Começar");
        btnStart.setBorder(bordaBotao);
        bottomSubJPanel.add(btnStart);

        // set do frame no painel cardMain
        centerMainJPanel.add(topSubJPanel, BorderLayout.NORTH);
        centerMainJPanel.add(bottomSubJPanel, BorderLayout.SOUTH);
        cardMain.add(centerMainJPanel, BorderLayout.CENTER);

        // Decorando a página quiz 1
        JPanel centerQuiz1JPanel = new JPanel(new BorderLayout());
        JPanel topQuiz1SubJPanel = new JPanel();
        JPanel bottomQuiz1SubJPanel = new JPanel();
        JPanel centerQuiz1SubJPanel = new JPanel(new GridLayout(4, 1));

        // Pergunta 1
        topQuiz1SubJPanel.add(new JLabel("Que criou o famoso vídeo: 'Rap dos Memes'?"));

        // Rádio Buttons
        JRadioButton btn1Quiz1 = new JRadioButton("Cauê Moura");
        JRadioButton btn1Quiz2 = new JRadioButton("Felipe Neto");
        JRadioButton btn1Quiz3 = new JRadioButton("Velberan");
        JRadioButton btn1Quiz4 = new JRadioButton("Pai Troll");

        ButtonGroup respQuiz1 = new ButtonGroup();
        respQuiz1.add(btn1Quiz1);
        respQuiz1.add(btn1Quiz2);
        respQuiz1.add(btn1Quiz3);
        respQuiz1.add(btn1Quiz4);

        centerQuiz1SubJPanel.add(btn1Quiz1);
        centerQuiz1SubJPanel.add(btn1Quiz2);
        centerQuiz1SubJPanel.add(btn1Quiz3);
        centerQuiz1SubJPanel.add(btn1Quiz4);

        // Botão de próximo
        JButton btnNextQuiz1 = new JButton("Próximo");
        btnNextQuiz1.setBorder(bordaBotao);
        bottomQuiz1SubJPanel.add(btnNextQuiz1);

        // set do frame no painel cardMain
        centerQuiz1JPanel.add(topQuiz1SubJPanel, BorderLayout.NORTH);
        centerQuiz1JPanel.add(centerQuiz1SubJPanel, BorderLayout.CENTER);
        centerQuiz1JPanel.add(bottomQuiz1SubJPanel, BorderLayout.SOUTH);
        cardQuiz1.add(centerQuiz1JPanel);

        // Decorando a página quiz 2
        JPanel centerQuiz2JPanel = new JPanel(new BorderLayout());
        JPanel topQuiz2SubJPanel = new JPanel();
        JPanel bottomQuiz2SubJPanel = new JPanel();
        JPanel centerQuiz2SubJPanel = new JPanel(new GridLayout(4, 1));

        // Pergunta 2
        topQuiz2SubJPanel.add(new JLabel("Quando se popularizou os memes de 'Rage Comics'?"));

        // Rádio Buttons
        JRadioButton btn2Quiz1 = new JRadioButton("1998");
        JRadioButton btn2Quiz2 = new JRadioButton("2015");
        JRadioButton btn2Quiz3 = new JRadioButton("2010");
        JRadioButton btn2Quiz4 = new JRadioButton("2008");

        ButtonGroup respQuiz2 = new ButtonGroup();
        respQuiz2.add(btn2Quiz1);
        respQuiz2.add(btn2Quiz2);
        respQuiz2.add(btn2Quiz3);
        respQuiz2.add(btn2Quiz4);

        centerQuiz2SubJPanel.add(btn2Quiz1);
        centerQuiz2SubJPanel.add(btn2Quiz2);
        centerQuiz2SubJPanel.add(btn2Quiz3);
        centerQuiz2SubJPanel.add(btn2Quiz4);

        // Botão de próximo
        JButton btnNextQuiz2 = new JButton("Próximo");
        btnNextQuiz2.setBorder(bordaBotao);
        bottomQuiz2SubJPanel.add(btnNextQuiz2);

        // set do frame no painel cardMain
        centerQuiz2JPanel.add(topQuiz2SubJPanel, BorderLayout.NORTH);
        centerQuiz2JPanel.add(centerQuiz2SubJPanel, BorderLayout.CENTER);
        centerQuiz2JPanel.add(bottomQuiz2SubJPanel, BorderLayout.SOUTH);
        cardQuiz2.add(centerQuiz2JPanel);

        // Decorando a página quiz 3
        JPanel centerQuiz3JPanel = new JPanel(new BorderLayout());
        JPanel topQuiz3SubJPanel = new JPanel();
        JPanel bottomQuiz3SubJPanel = new JPanel();
        JPanel centerQuiz3SubJPanel = new JPanel(new GridLayout(4, 1));

        // Pergunta 3
        topQuiz3SubJPanel.add(new JLabel("Qual é a 'música meme' mais antiga?"));

        // Rádio Buttons
        JRadioButton btn3Quiz1 = new JRadioButton("Hallehlujah Chorus");
        JRadioButton btn3Quiz2 = new JRadioButton("Canon In D");
        JRadioButton btn3Quiz3 = new JRadioButton("Never Gonna Give You Up");
        JRadioButton btn3Quiz4 = new JRadioButton("Fur Elise");

        ButtonGroup respQuiz3 = new ButtonGroup();
        respQuiz3.add(btn3Quiz1);
        respQuiz3.add(btn3Quiz2);
        respQuiz3.add(btn3Quiz3);
        respQuiz3.add(btn3Quiz4);

        centerQuiz3SubJPanel.add(btn3Quiz1);
        centerQuiz3SubJPanel.add(btn3Quiz2);
        centerQuiz3SubJPanel.add(btn3Quiz3);
        centerQuiz3SubJPanel.add(btn3Quiz4);

        // Botão de próximo
        JButton btnNextQuiz3 = new JButton("Próximo");
        btnNextQuiz3.setBorder(bordaBotao);
        bottomQuiz3SubJPanel.add(btnNextQuiz3);

        // set do frame no painel cardMain
        centerQuiz3JPanel.add(topQuiz3SubJPanel, BorderLayout.NORTH);
        centerQuiz3JPanel.add(centerQuiz3SubJPanel, BorderLayout.CENTER);
        centerQuiz3JPanel.add(bottomQuiz3SubJPanel, BorderLayout.SOUTH);
        cardQuiz3.add(centerQuiz3JPanel);

        // Decorando a página quiz 4
        JPanel centerQuiz4JPanel = new JPanel(new BorderLayout());
        JPanel topQuiz4SubJPanel = new JPanel();
        JPanel bottomQuiz4SubJPanel = new JPanel();
        JPanel centerQuiz4SubJPanel = new JPanel(new GridLayout(4, 1));

        // Pergunta 4
        topQuiz4SubJPanel.add(new JLabel("Em qual filme surgiu está frase: 'Ainda bem, até um outro dia.'"));

        // Rádio Buttons
        JRadioButton btn4Quiz1 = new JRadioButton("Obrigado a Matar");
        JRadioButton btn4Quiz2 = new JRadioButton("Um Pistoleiro Chamado Popaco");
        JRadioButton btn4Quiz3 = new JRadioButton("Charrito: Um Herói Mexicano");
        JRadioButton btn4Quiz4 = new JRadioButton("Tropa de Elite");

        ButtonGroup respQuiz4 = new ButtonGroup();
        respQuiz4.add(btn4Quiz1);
        respQuiz4.add(btn4Quiz2);
        respQuiz4.add(btn4Quiz3);
        respQuiz4.add(btn4Quiz4);

        centerQuiz4SubJPanel.add(btn4Quiz1);
        centerQuiz4SubJPanel.add(btn4Quiz2);
        centerQuiz4SubJPanel.add(btn4Quiz3);
        centerQuiz4SubJPanel.add(btn4Quiz4);

        // Botão de próximo
        JButton btnNextQuiz4 = new JButton("Próximo");
        btnNextQuiz4.setBorder(bordaBotao);
        bottomQuiz4SubJPanel.add(btnNextQuiz4);

        // set do frame no painel cardMain
        centerQuiz4JPanel.add(topQuiz4SubJPanel, BorderLayout.NORTH);
        centerQuiz4JPanel.add(centerQuiz4SubJPanel, BorderLayout.CENTER);
        centerQuiz4JPanel.add(bottomQuiz4SubJPanel, BorderLayout.SOUTH);
        cardQuiz4.add(centerQuiz4JPanel);

        // Decorando a página quiz 5
        JPanel centerQuiz5JPanel = new JPanel(new BorderLayout());
        JPanel topQuiz5SubJPanel = new JPanel();
        JPanel bottomQuiz5SubJPanel = new JPanel();
        JPanel centerQuiz5SubJPanel = new JPanel(new GridLayout(4, 1));

        // Pergunta 5
        topQuiz5SubJPanel.add(new JLabel("Qual é a frase que o famoso Galo Cego menciona quando estava preso?"));

        // Rádio Buttons
        JRadioButton btn5Quiz1 = new JRadioButton("'Faz tempo'");
        JRadioButton btn5Quiz2 = new JRadioButton("'Comprar Alimento'");
        JRadioButton btn5Quiz3 = new JRadioButton("'É o é'");
        JRadioButton btn5Quiz4 = new JRadioButton("'É só bagunça'");

        ButtonGroup respQuiz5 = new ButtonGroup();
        respQuiz5.add(btn5Quiz1);
        respQuiz5.add(btn5Quiz2);
        respQuiz5.add(btn5Quiz3);
        respQuiz5.add(btn5Quiz4);

        centerQuiz5SubJPanel.add(btn5Quiz1);
        centerQuiz5SubJPanel.add(btn5Quiz2);
        centerQuiz5SubJPanel.add(btn5Quiz3);
        centerQuiz5SubJPanel.add(btn5Quiz4);

        // Botão de próximo
        JButton btnNextQuiz5 = new JButton("Próximo");
        btnNextQuiz5.setBorder(bordaBotao);
        bottomQuiz5SubJPanel.add(btnNextQuiz5);

        // set do frame no painel cardMain
        centerQuiz5JPanel.add(topQuiz5SubJPanel, BorderLayout.NORTH);
        centerQuiz5JPanel.add(centerQuiz5SubJPanel, BorderLayout.CENTER);
        centerQuiz5JPanel.add(bottomQuiz5SubJPanel, BorderLayout.SOUTH);
        cardQuiz5.add(centerQuiz5JPanel);

        // Decorando a página de Resultados
        JPanel centerResultsJPanel = new JPanel(new BorderLayout());
        JPanel centerResultsSubJPanel = new JPanel();
        centerResultsSubJPanel.add(new JLabel("Você acertou " + cont + "/5 questões."));
        centerResultsJPanel.add(centerResultsSubJPanel, BorderLayout.CENTER);
        cardResults.add(centerResultsJPanel);

        // Adicionando os painéis para o painel principal
        mainPanel.add(cardMain);
        mainPanel.add(cardQuiz1);
        mainPanel.add(cardQuiz2);
        mainPanel.add(cardQuiz3);
        mainPanel.add(cardQuiz4);
        mainPanel.add(cardQuiz5);
        mainPanel.add(cardResults);

        // Set do Frame
        this.add(mainPanel);
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.pack();
        this.setVisible(true);

        // Ações ao botões:
        btnStart.addActionListener(e -> {
            cl.next(mainPanel);
        });

        // seleção dos radios buttons para a questão 1
        btnNextQuiz1.addActionListener(e -> {
            if (btn1Quiz1.isSelected()) {
                cont++;
                cl.next(mainPanel);
            } else if (btn1Quiz2.isSelected()) {
                cl.next(mainPanel);
            } else if (btn1Quiz3.isSelected()) {
                cl.next(mainPanel);
            } else if (btn1Quiz4.isSelected()) {
                cl.next(mainPanel);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma das Opções!");
            }
        });

        // seleção dos radios buttons para a questão 2
        btnNextQuiz2.addActionListener(e -> {
            if (btn2Quiz1.isSelected()) {
                cl.next(mainPanel);
            } else if (btn2Quiz2.isSelected()) {
                cl.next(mainPanel);
            } else if (btn2Quiz3.isSelected()) {
                cont++;
                cl.next(mainPanel);
            } else if (btn2Quiz4.isSelected()) {
                cl.next(mainPanel);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma das Opções!");
            }
        });

        // seleção dos radios buttons para a questão 3
        btnNextQuiz3.addActionListener(e -> {
            if (btn3Quiz1.isSelected()) {
                cl.next(mainPanel);
            } else if (btn3Quiz2.isSelected()) {
                cont++;
                cl.next(mainPanel);
            } else if (btn3Quiz3.isSelected()) {
                cl.next(mainPanel);
            } else if (btn3Quiz4.isSelected()) {
                cl.next(mainPanel);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma das Opções!");
            }
        });

        // seleção dos radios buttons para a questão 4
        btnNextQuiz4.addActionListener(e -> {
            if (btn4Quiz1.isSelected()) {
                cl.next(mainPanel);
            } else if (btn4Quiz2.isSelected()) {
                cont++;
                cl.next(mainPanel);
            } else if (btn4Quiz3.isSelected()) {
                cl.next(mainPanel);
            } else if (btn4Quiz4.isSelected()) {
                cl.next(mainPanel);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma das Opções!");
            }
        });

        // seleção dos radios buttons para a questão 5
        btnNextQuiz5.addActionListener(e -> {
            if (btn5Quiz1.isSelected()) {
                cl.next(mainPanel);
            } else if (btn5Quiz2.isSelected()) {
                cl.next(mainPanel);
            } else if (btn5Quiz3.isSelected()) {
                cl.next(mainPanel);
            } else if (btn5Quiz4.isSelected()) {
                cont++;
                cl.next(mainPanel);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma das Opções!");
            }
        });
    }
}

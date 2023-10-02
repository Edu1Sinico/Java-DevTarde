import javax.swing.*;

import java.awt.*;

public class Exercicio3CardLayout extends JFrame {

    public Exercicio3CardLayout() {
        super("Exercicio 3 - lista Cards & Tabs");

        // Criação de um painel principal com Card Layout
        JPanel mainPanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);


        
        // Criação de cards e declarando layouts para eles
        JPanel cardMain = new JPanel(new BorderLayout());
        JPanel cardLogin = new JPanel(new BorderLayout());
        JPanel cardRegister = new JPanel(new BorderLayout());



        // Criando paineis e adicionando eles para o CardMain
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Bem Vindo ao Programa do SENAI")).setForeground(Color.WHITE);
        titlePanel.setBackground(Color.RED);

        // Criando um painel para adicionar os botões de cadastro
        JPanel centerUpPanel = new JPanel();
        centerUpPanel.add(new JLabel("Faça o seu cadastro: "));
        JButton btnCadastro = new JButton("Cadastro");
        centerUpPanel.add(btnCadastro);

        // Criando um painel para adicionar os botões de login
        JPanel centerDownPanel = new JPanel();
        centerDownPanel.add(new JLabel("Faça o seu Login: "));
        JButton btnLogin = new JButton("Login");
        centerDownPanel.add(btnLogin);

        // Criando um painel para posicionar os elementos e posicionando eles com
        // gridlayout
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));
        centerPanel.add(centerUpPanel);
        centerPanel.add(centerDownPanel);
        cardMain.add(titlePanel, BorderLayout.NORTH);
        cardMain.add(centerPanel, BorderLayout.CENTER);



        // Criando paineis e adicionando eles para o CardLogin
        JPanel titlePanel2 = new JPanel();
        titlePanel2.add(new JLabel("Bem Vindo ao Programa do SENAI")).setForeground(Color.WHITE);
        titlePanel2.setBackground(Color.RED);

        // Criando um textfield para o usuário
        JPanel centerUpPanel2 = new JPanel();
        centerUpPanel2.add(new JLabel("Usuário: "));
        JTextField TextUser = new JTextField(20);
        centerUpPanel2.add(TextUser);

        // Criando um textfield para a senha
        JPanel centerDownPanel2 = new JPanel();
        centerDownPanel2.add(new JLabel("Senha: "));
        JTextField TextPassword = new JTextField(20);
        centerDownPanel2.add(TextPassword);

        // Adicionando o posicionamento para os textfields
        JPanel centerPanel2 = new JPanel(new GridLayout(2, 2));
        centerPanel2.add(centerUpPanel2);
        centerPanel2.add(centerDownPanel2);

        // Criando o botão cadastro
        JPanel bottomLeftPanel2 = new JPanel();
        JButton btnCadastro2 = new JButton("Cadastro");
        bottomLeftPanel2.add(btnCadastro2);

        // Criando o botão menu
        JPanel bottomRightPanel2 = new JPanel();
        JButton btnMenu = new JButton("Menu");
        bottomRightPanel2.add(btnMenu);

        // Adicionando os posicionamentos do botão com gridlayout
        JPanel bottomPanel2 = new JPanel(new GridLayout(1, 2));
        bottomPanel2.add(bottomLeftPanel2);
        bottomPanel2.add(bottomRightPanel2);

        // Adicionando os painéis de posicionamento para o cardLogin
        cardLogin.add(titlePanel2, BorderLayout.NORTH);
        cardLogin.add(centerPanel2, BorderLayout.CENTER);
        cardLogin.add(bottomPanel2, BorderLayout.SOUTH);

        // Adicionando os painéis para o painel principal
        mainPanel.add(cardMain);
        mainPanel.add(cardLogin);
        mainPanel.add(cardRegister);



        // Criando paineis e adicionando eles para o CardLogin
        JPanel titlePanel3 = new JPanel();
        titlePanel3.add(new JLabel("Bem Vindo ao Programa do SENAI")).setForeground(Color.WHITE);
        titlePanel3.setBackground(Color.RED);

        // Criando um textfield para o nome
        JPanel centerUpPanel3 = new JPanel();
        centerUpPanel3.add(new JLabel("Nome: "));
        JTextField TextName = new JTextField(20);
        centerUpPanel3.add(TextName);

        // Criando um textfield para a Idade
        JPanel center1Panel3 = new JPanel();
        center1Panel3.add(new JLabel("Idade: "));
        JTextField TextIdade = new JTextField(20);
        center1Panel3.add(TextIdade);

        // Criando um textfield para a Email
        JPanel center2Panel3 = new JPanel();
        center2Panel3.add(new JLabel("Email: "));
        JTextField TextEmail = new JTextField(20);
        center2Panel3.add(TextEmail);

        // Criando um textfield para a CEP
        JPanel centerDownPanel3 = new JPanel();
        centerDownPanel3.add(new JLabel("CEP: "));
        JTextField TextCEP = new JTextField(20);
        centerDownPanel3.add(TextCEP);

        // Adicionando o posicionamento para os textfields
        JPanel centerPanel3 = new JPanel(new GridLayout(4, 8));
        centerPanel3.add(centerUpPanel3);
        centerPanel3.add(center1Panel3);
        centerPanel3.add(center2Panel3);
        centerPanel3.add(centerDownPanel3);

        // Criando o botão login
        JPanel bottomLeftPanel3 = new JPanel();
        JButton btnLogin2 = new JButton("Login");
        bottomLeftPanel3.add(btnLogin2);

        // Criando o botão menu
        JPanel bottomRightPanel3 = new JPanel();
        JButton btnMenu2 = new JButton("Menu");
        bottomRightPanel3.add(btnMenu2);

        // Adicionando os posicionamentos do botão com gridlayout
        JPanel bottomPanel3 = new JPanel(new GridLayout(1, 2));
        bottomPanel3.add(bottomLeftPanel3);
        bottomPanel3.add(bottomRightPanel3);

        // Adicionando os painéis de posicionamento para o cardLogin
        cardRegister.add(titlePanel3, BorderLayout.NORTH);
        cardRegister.add(centerPanel3, BorderLayout.CENTER);
        cardRegister.add(bottomPanel3, BorderLayout.SOUTH);



        // Set do Frame
        this.add(mainPanel);
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);



        // Ação de trocar de painel
        btnLogin.addActionListener(e -> {
            cl.next(mainPanel);
        });

        btnLogin2.addActionListener(e -> {
            cl.previous(mainPanel);
        });



        btnCadastro.addActionListener(e -> {
            cl.previous(mainPanel);
        });

        btnCadastro2.addActionListener(e -> {
            cl.next(mainPanel);
        });



        btnMenu.addActionListener(e -> {
            cl.previous(mainPanel);
        });

        btnMenu2.addActionListener(e -> {
            cl.next(mainPanel);
        });
    }
}

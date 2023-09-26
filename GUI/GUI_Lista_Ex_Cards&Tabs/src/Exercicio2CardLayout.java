import javax.swing.*;
import java.awt.*;

public class Exercicio2CardLayout extends JFrame{

    public Exercicio2CardLayout() {
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

        JPanel centerUpPanel = new JPanel();
        centerUpPanel.add(new JLabel("Faça o seu cadastro: "));
        JButton btnCadastro = new JButton("Cadastro");
        centerUpPanel.add(btnCadastro);

        JPanel centerDownPanel = new JPanel();
        centerDownPanel.add(new JLabel("Faça o seu Login: "));
        JButton btnLogin = new JButton("Login");
        centerDownPanel.add(btnLogin);

        JPanel centerPanel = new JPanel(new GridLayout(2,1));
        centerPanel.add(centerUpPanel);
        centerPanel.add(centerDownPanel);

        cardMain.add(titlePanel,BorderLayout.NORTH);
        cardMain.add(centerPanel,BorderLayout.CENTER);

        // Adicionando os painéis para o painel principal
        mainPanel.add(cardMain);
        mainPanel.add(cardLogin);
        mainPanel.add(cardRegister);

        // Set do Frame
        this.add(mainPanel);
        this.setDefaultCloseOperation(2);
        this.setBounds(100,100,300,300);
        this.setVisible(true);

                // Ação de trocar de painel
        
                btnLogin.addActionListener( e ->{
                    cl.next(cardLogin);
                });
        
                btnCadastro.addActionListener( e ->{
                    cl.previous(cardRegister);
                });

    }
}

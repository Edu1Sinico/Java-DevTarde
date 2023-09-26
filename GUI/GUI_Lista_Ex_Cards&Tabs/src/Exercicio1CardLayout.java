import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio1CardLayout extends JFrame{
    public Exercicio1CardLayout() {
        super("Exercicio 1 - lista Cards & Tabs");

        // Criando o JPaneç Principal
        JPanel mainPanel = new JPanel();
        
        // Declarando o Layout
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);

        // Criar cards para adicionar ao mainPanel
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Card 1"));
        
        JPanel card2 = new JPanel();
        card2.add(new JLabel("Card 2"));
        
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Card 3"));

        // Criando um botão e adicionando ele nos cards
        JButton btnNext1 = new JButton("Next");
        JButton btnNext2 = new JButton("Next");
        JButton btnNext3 = new JButton("Next");

        card1.add(btnNext1);
        card2.add(btnNext2);
        card3.add(btnNext3);

        // Add cards ao mainPanel
        mainPanel.add(card1);
        mainPanel.add(card2);
        mainPanel.add(card3);

        // Set do frame
        this.add(mainPanel);
        this.setDefaultCloseOperation(2);
        this.setBounds(100,100,300,300);
        this.setVisible(true);

        // Ação de trocar de painel
        btnNext1.addActionListener( e ->{
            cl.next(mainPanel);
        });

        btnNext2.addActionListener( e ->{
            cl.next(mainPanel);
        });

        btnNext3.addActionListener( e ->{
            cl.next(mainPanel);
        });


    }

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercicio1CardLayout {
    public void janelaEx1() {

        // Declarando a janela e painéis da página
        JFrame janelaPrincipal = new JFrame();
        JPanel painel1 = new JPanel();
        // JPanel painel2 = new JPanel();
        // JPanel painel3 = new JPanel();

        // Definindo os seus layouts
        janelaPrincipal.setLayout(new BorderLayout());
        painel1.setLayout(new BorderLayout());
        // painel2.setLayout(new BorderLayout());
        // painel3.setLayout(new BorderLayout());

        // Painel principal com cards layouts

        // Adicionando os painéis para o JFrame
        janelaPrincipal.add(painel1, BorderLayout.CENTER);
        // janelaPrincipal.add(painel2, BorderLayout.CENTER);
        // janelaPrincipal.add(painel3, BorderLayout.CENTER);

        // Criando o card e adicionando ele para os paineis
        JPanel card = new JPanel();
        painel1.add(card, BorderLayout.SOUTH);
        // painel2.add(card, BorderLayout.SOUTH);
        // painel3.add(card, BorderLayout.SOUTH);

        // Adicionando labels para os painéis
        painel1.add(new JLabel("Está é a primeira(1ª) página!"),BorderLayout.CENTER);
        // painel2.add(new JLabel("Está é a segunda(2ª) página!"),BorderLayout.CENTER);
        // painel3.add(new JLabel("Está é a terceira(3ª) página!"),BorderLayout.CENTER);

        // Criando botões e adicionando elementos para o card
        JButton btnPag1 = new JButton("Página: 1");
        JButton btnPag2 = new JButton("Página: 2");
        JButton btnPag3 = new JButton("página: 3");
        card.add(btnPag1);
        card.add(btnPag2);
        card.add(btnPag3);

        // Escondendo os painéis
        painel1.setVisible(false);
        // painel2.setVisible(false);
        // painel3.setVisible(false);

        // definindo um comando para os botões
        btnPag1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    painel1.setVisible(true);
                    // painel2.setVisible(false);
                    // painel3.setVisible(false);
            }
        });

        // definindo um comando para os botões
        btnPag2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JPanel painel2 = new JPanel();
            painel2.setLayout(new BorderLayout());
            janelaPrincipal.add(painel2, BorderLayout.CENTER);
            painel2.add(card, BorderLayout.SOUTH);
            }
        });

        // definindo um comando para os botões
        btnPag3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // painel1.setVisible(false);
                // painel2.setVisible(false);
                // painel3.setVisible(true);
            }
        });

        // Setando o frame
        janelaPrincipal.setDefaultCloseOperation(janelaPrincipal.EXIT_ON_CLOSE);
        janelaPrincipal.setBounds(470, 100, 450, 335);
        // janelaPrincipal.pack();
        janelaPrincipal.setVisible(true);
    }

}

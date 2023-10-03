import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ExibirNome extends JFrame {

    public ExibirNome() {
        super("Exercício 1 - Exibir nome e sobrenome");
        // Criação de painéis
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        JPanel bottomPanel = new JPanel();

        // Criação de elementos para o painel do topo
        topPanel.add(new JLabel("Nome: "));
        JTextField textNome = new JTextField(20);
        topPanel.add(textNome);
        topPanel.add(new JLabel("Sobrenome: "));
        JTextField textSobreNome = new JTextField(20);
        topPanel.add(textSobreNome);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Criação de elementos para o painel de baixo
        JButton btnOk = new JButton("Ok");
        btnOk.setBorder(new EmptyBorder(5, 10, 5, 10));
        bottomPanel.add(btnOk);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        btnOk.addActionListener(new ActionListener() {
            String nome = "";
            String sobre = "";

            public void actionPerformed(ActionEvent e) {
                this.nome = textNome.getText(); // Obtém o texto do JTextField
                this.sobre = textSobreNome.getText(); // Obtém o texto do JTextField

                if (this.nome.equals("") || this.sobre.equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite o seu nome!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, this.nome + " " + this.sobre,"Seu nome",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        // setFrame
        this.add(mainPanel);
        this.setDefaultCloseOperation(2);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
}

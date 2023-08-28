import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContainerComps extends JFrame{
    int cont = 0;

    public ContainerComps() {
        super("Janela de Container");
        this.setBounds(500,500,500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        this.add(painel);

        JButton botao = new JButton("Clique aqui!");

        // JLabel label = new JLabel("Nº de Cliques: 0   ");

        botao.addActionListener(e ->{
            cont++;
            painel.add(new JButton("Botão "+cont));
            // label.setText("Nº de Cliques: " + cont);
        });
        painel.add(botao);
        // painel.add(label);
        
        this.setVisible(true);
        this.setResizable(false);
    }
}

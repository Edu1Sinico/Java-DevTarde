import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JframeUtil extends JFrame{
    public JframeUtil() {
        super();

        // Setando a janela
        this.setBounds(500, 500, 400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Ajustando o Layout da Classe

        FlowLayout flow = new FlowLayout();
        this.setLayout(flow);

        // Adicionando Componentes
        for (int i = 0; i < 6; i++) {

            this.add(new JButton(""+i));

        }
        this.add(new JTextField("Meu Textos", 15));
        this.setVisible(true);
    }
}

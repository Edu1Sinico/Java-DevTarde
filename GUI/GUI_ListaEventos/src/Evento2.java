import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Evento2 extends JFrame {

    private JTextField textReceber = new JTextField(20), textLetra = new JTextField(3), textCopiar = new JTextField(20);

    public Evento2() {

        super("Exercício 2 - Programa de Texto");
        JPanel painelPrincipal = new JPanel(new GridLayout(4, 1));
        JPanel painelTop = new JPanel(new GridLayout(1, 2));
        JPanel painelCenter1 = new JPanel();
        JPanel painelCenter2 = new JPanel();
        JPanel painelBottom = new JPanel();

        painelTop.add(new JLabel("Letra digitado: "));
        painelTop.add(textLetra);
        painelCenter1.add(new JLabel("Digite seu Texto:"));
        // Declara o handler
        Handler evt1 = new Handler();
        // Adiciona o evento do teclado
        textReceber.addKeyListener(evt1);
        painelCenter2.add(textReceber);
        painelBottom.add(textCopiar);

        painelPrincipal.add(painelTop);
        painelPrincipal.add(painelCenter1);
        painelPrincipal.add(painelCenter2);
        painelPrincipal.add(painelBottom);
        this.add(painelPrincipal);
        this.setDefaultCloseOperation(2);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    // Criação do handler
    public class Handler implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // pega a variável char digitada
            char letra = e.getKeyChar();
            textLetra.setText("" + letra); //Exibe na caixa de Texto
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
          textCopiar.setText(textReceber.getText()); //coloca o texto copiado na outra caixa de texto
        }
    }
}

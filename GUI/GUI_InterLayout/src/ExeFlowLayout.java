import javax.swing.*;
import java.awt.*;

public class ExeFlowLayout {

    int pegarTexto = 0; 

    // Constructor
    public ExeFlowLayout() {
        super();
        // Padrão: GridLayout
        JFrame janela1 = new JFrame("Janela 1");
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);
        JLabel texto1 = new JLabel("Informe o número de botões: ");
        JTextField painel1 = new JTextField("Insira nº ", 25);
        JButton botao1 = new JButton("Enviar");

        

        botao1.addActionListener(e -> {
            pegarTexto = Integer.parseInt(painel1.getText());
            for (int i = 0; i < pegarTexto; i++) {
                
                janela1.add(new JButton("" + i));

            }
        });
        

        janela1.add(texto1);
        janela1.add(painel1);
        janela1.add(botao1);

        janela1.setDefaultCloseOperation(2);
        janela1.pack();
        janela1.setVisible(true);
    }

}

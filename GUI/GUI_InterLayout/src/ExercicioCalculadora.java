import javax.swing.*;
import java.awt.*;

public class ExercicioCalculadora extends JFrame{
    public ExercicioCalculadora() {
        super("Calculadora FODA! 2000 4k");

        JPanel principal = new JPanel(new BorderLayout());
        JPanel painel = new JPanel();

        GridLayout grid = new GridLayout(4,4);
        painel.setLayout(grid);

        this.add(principal);

        // add dos componentes ao Jpanel
        String valores[] = {"7","8","9","x","4","5","6","-","3","2","1","+","/","0",",","="};

        for (int i = 0; i < valores.length; i++) {
            if(valores[i] == "x"){
                painel.add(new JButton(valores[i])).setBackground(Color.LIGHT_GRAY);
            }
            if(valores[i] == "=")
            {
                painel.add(new JButton(valores[i])).setBackground(Color.BLUE);
            }
            else{
            painel.add(new JButton(valores[i])).setBackground(Color.WHITE);
            }
        }

        principal.add(new JTextField(25),BorderLayout.NORTH);
        principal.add(painel,BorderLayout.CENTER);

        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}
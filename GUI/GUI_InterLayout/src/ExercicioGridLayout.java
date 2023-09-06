import javax.swing.*;
import java.awt.*;

public class ExercicioGridLayout extends JFrame{
    public ExercicioGridLayout() {
        super("Calculadora");

        // add um Jpanel
        JPanel painel = new JPanel();
        this.add(painel);

        // add dos componentes ao Jpanel
        String valores[] = {"7","8","9","x","4","5","6","-","3","2","1","+","/","0",".","="};
        
        // modificar o Layout do Painel(Jpanel) flow->Grid
        GridLayout grid = new GridLayout(4,4);
        painel.setLayout(grid);

        for (int i = 0; i < valores.length; i++) {
            if(valores[i] == "=")
            {
                painel.add(new JButton(valores[i])).setBackground(Color.BLUE);
            }
            else{
            painel.add(new JButton(valores[i]));
            }
        }

        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}

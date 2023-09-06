import java.awt.*;
import javax.swing.*;

public class ExeGridLayout extends JFrame{

    public ExeGridLayout() {
        super("Janela Principal");

        //Add um JPanel
        JPanel painel = new JPanel();
        this.add(painel);

        // modificar o Layout do Painel(Jpanel) Flow -> Grid
        GridLayout grid = new GridLayout(2,2);
        painel.setLayout(grid);

        // Add dos componentes ao JPanel
        for (int i = 0; i < 4; i++) {
            painel.add(new JButton(""+i));     
        }
        
        //Set do frame
        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}

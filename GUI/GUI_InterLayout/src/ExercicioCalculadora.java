import javax.swing.*;
import java.awt.*;

public class ExercicioCalculadora extends JFrame{
    public ExercicioCalculadora() {
        super("Calculadora FODA! 2000 4k");

        JPanel painel = new JPanel();
        this.add(painel);

        // add dos componentes ao Jpanel
        String valores[] = {"7","8","9","x","4","5","6","-","3","2","1","+","/","0",".","="};
    }
}
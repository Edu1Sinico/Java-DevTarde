import java.awt.Frame;

public class AWTFrameExe extends Frame{
    
    // constructor 
    public AWTFrameExe() {
        super("Olá, Mundo!");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setResizable(false); //Faz com que o programa não redimenciona 
    }


}

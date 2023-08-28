import javax.swing.JFrame;

public class GUISwingJFrameExe extends JFrame{
    public GUISwingJFrameExe() {
        super("Olá, Mundo!");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Fecha o programa ao apertar o x
        this.setVisible(true); //Transforma a janela visível
        this.setResizable(false);
    }
}

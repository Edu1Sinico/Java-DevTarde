import javax.swing.JOptionPane;

public class GUISwingJOP extends JOptionPane{
    public GUISwingJOP() {
        super("Janela do JOptionPane");
        this.showMessageDialog(getComponentPopupMenu(), "Você foi Avisado.", "Aviso", 2, icon);
    }
}

package TryCatchFinally;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String fraseInicial = null;
        String fraseFinal = null;
        fraseInicial = JOptionPane.showInputDialog("Digite uma Frase");
            if(fraseInicial.equals("")){
                fraseInicial = null;
            }
        try{
            fraseFinal = fraseInicial.toUpperCase();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            fraseFinal = "Não foi digitado uma frase";
        }finally{
            JOptionPane.showMessageDialog(null, fraseFinal);
        }
    }
}

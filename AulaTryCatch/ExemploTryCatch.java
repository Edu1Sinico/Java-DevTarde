package AulaTryCatch;

import javax.swing.JOptionPane;

public class ExemploTryCatch {
    public static void main(String[] args) {
        int n1 = 0, n2 = 0;

        try{
            n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
            n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o Segundo número:"));
            JOptionPane.showMessageDialog(null,"A soma do número " + n1 + " com o número " + n2 + " é igual a:a " + (n1+n2));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro - Só é aceito números inteiros!");
        }
    }
}

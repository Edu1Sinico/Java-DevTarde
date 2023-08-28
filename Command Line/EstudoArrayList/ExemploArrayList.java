package EstudoArrayList;

import javax.swing.JOptionPane;

public class ExemploArrayList {
    int vetor[] = new int[1];
    int x = 0, cont = 0, y = 0, temp = 0;
    boolean Verdadeiro = true;

    public void add() {
        while (Verdadeiro) {
            x = Integer.parseInt(JOptionPane.showInputDialog("Informe um n\u00FAmero para ser armazenado no vetor: "));
            cont++;
            vetor[0] = x;
            int vetor1[] = new int[cont];
            vetor1[cont-1] = vetor[0];
            for (int i = 0; i < vetor1.length; i++) {
                JOptionPane.showMessageDialog(null, "O valor do vetor["+ (1+i) +"] é: " + vetor1[0+i]);
            }
        }
    }
}

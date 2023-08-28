package IteracaoFor;

import java.util.Scanner;

public class ExemploFor {
    Scanner sc = new Scanner(System.in);

    public void Metodo01() {

        for (int i = 0; i < 100; i++) {
            System.out.println("O número da Iteração é " + i);
        }

    }

    public void Metodo02() {
        int[] vetor = new int[5];

        for(int i = 0; i < vetor.length; i++)
        {
            System.err.println("Informe o valor do vetor["+i+"]: ");
            vetor[i] = sc.nextInt();
        }
    }
}

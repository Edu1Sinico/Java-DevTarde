package IteracaoWhile;

import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicToolBarSeparatorUI;

public class ExemploWhile {
    Scanner sc = new Scanner(System.in);

    // Método 1
    public void Metodo01() {
        int i = 0;

        while (i < 10) {
            i++;
            System.out.println("O nº da Iteração é: " + i + ".");
        }
    }

    // Método 2
    public void Metodo02() {
        int[] vetor = new int[10];
        int i = 0;
        while (i < 10) {
            System.out.println("Informe o valor da indice de nº" + i + " do vetor.");
            vetor[i] = sc.nextInt();
            i++;
        }
        i = 0;
        while (i < 10) {
            System.out.println("O vetor[" + i + "] = " + vetor[i]);
            i++;
        }
        // ou

        /*
         * while(i>0){
         * i--;
         * System.out.println("O vetor["+i+"] = "+vetor[i]);
         * }
         */
    }

    
    // Método 3
    public void Metodo03() {
        Random rd = new Random();
        int valorSortado = rd.nextInt(10);
        int x; 
        Boolean verdade = true;

        while (verdade) {
            System.out.println("");
            System.out.println("Digite um número: ");
            x = sc.nextInt();

            if (x == valorSortado) {
                System.out.println("Você acertou o número! " + valorSortado);
                verdade = false;
                System.out.println("");
            } else {
                System.out.println("Você errou o número.");
            }
        }
    }


    // Método 4
    public void Metodo04() {
        int x = 0;
        boolean verdade = false;

        while (!verdade) {
            System.out.println("");
            System.out.println("Digite um número: ");
            x = sc.nextInt();

            if (x != 10) {
                System.out.println("Você errou o número.");
    
            } else {
                System.out.println("Você acertou o número 10!");
                verdade = true;
            }
        }
    }
}

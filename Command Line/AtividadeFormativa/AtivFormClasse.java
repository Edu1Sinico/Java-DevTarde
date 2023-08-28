package AtividadeFormativa;

import java.util.Random;
import java.util.Scanner;

/**
 * AtivForm_Classe
 */
public class AtivFormClasse {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    //Método 1
    public void Metodo01() {
        int x = 0, y = 0;

        System.out.println("Informe o tamanho das linhas da Matriz[x][y]: ");
        x = sc.nextInt();
        System.out.println();
        System.out.println("Informe o tamanho das colunas da Matriz[" + x + "][y]: ");
        y = sc.nextInt();
        System.out.println();
        int[][] matriz = new int[x][y];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rd.nextInt(0, 9);
            }
        }

        System.out.println("Matriz Random: ");
        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Matriz[" + (i+1) + "][" + (j+1) + "] = " + matriz[i][j]);
                System.out.println("");
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i > j) {
                    matriz[i][j] = 1;
                } else if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = 2;
                }
            }
        }

        System.out.println("===========================");
        System.out.println("");
        System.out.println("Matriz substituida: ");
        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Matriz[" + (i+1) + "][" + (j+1) + "] = " + matriz[i][j]);
                System.out.println("");
            }
        }

    }

    //Método 2
    public void Metodo02() {
        int valorSorteado = 0, x = 0, cont = 1;
        boolean verdadeiro = false;
        valorSorteado = rd.nextInt(0, 1000);

        while (verdadeiro == false) {
            System.out.println("===============================");
            System.out.println();
            System.out.println("Informe um número de 0 a 1000: ");
            x = sc.nextInt();
            System.out.println();

            if (x >= 0 && x <= 1000) {
                if (x == valorSorteado) {
                    System.out.println("Você acertou o número! " + x);
                    System.out.println("Número de tentativas: " + cont);
                    System.out.println();
                    verdadeiro = true;
                } else if (x > valorSorteado) {
                    System.out.println("O valor digitado é maior que o valor sorteado.");
                    cont++;
                } else {
                    System.out.println("O valor digitado é menor que o valor sorteado.");
                    cont++;
                }
            } else {
                System.out.println("Escolha um número de 0 a 1000!");
            }
        }
    }

    //Método 3
    public void Metodo03() {
        int[] vetor = new int[rd.nextInt(100,1000)];
        int cont = 0;

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(1,100);
        }

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] % 2 == 0){
                System.out.println("Números pares do vetor["+ (i+1) +"]: " + vetor[i]);
                System.out.println("");
                if (i % 2 != 0)
                {
                    cont++;
                }
            }
        }
        System.out.println("");
        System.out.println("Quantidade de pares nas posições ímpares: " + cont);
        cont = 0;
        System.out.println("");
        System.out.println("========================================");
        System.out.println("");
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] % 2 != 0){
                System.out.println("Números ímpares do vetor["+ (i+1) +"]: " + vetor[i]);
                System.out.println("");
                if (i % 2 == 0)
                {
                    cont++;
                }
            }
        }
        System.out.println("");
        System.out.println("Quantidade de ímpares nas posições pares: " + cont);
    }
}
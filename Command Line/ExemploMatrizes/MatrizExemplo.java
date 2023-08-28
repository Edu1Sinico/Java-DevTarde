package ExemploMatrizes;

import java.util.Random;
import java.util.Scanner;

public class MatrizExemplo {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void Exemplo01() {
        // exemplo de criação/preenchimento/impressão de matriz
        // declara a minha matriz de 2 dimensões
        int tab[][] = new int[10][9];
        // preencher a matriz
        for (int i = 0; i < 10; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            for (int j = 0; j < 9; j++) {
                // laço vai preencher a 2º dimensão da matriz
                // System.out.println("Tab["+(i+1)+"]["+(j+1)+"]=");
                tab[i][j] = rd.nextInt(9);// preencher o valor na posição
            }
        }

        // Imprimir a minha matriz
        for (int i = 0; i < 10; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            for (int j = 0; j < 9; j++) {
                // laço vai preencher a 2º dimensão da matriz
                System.out.println("Tab[" + (i + 1) + "][" + (j + 1) + "]=" + tab[i][j]);
            }
        }

        // Imprimindo em Formato de Matriz
        for (int i = 0; i < 10; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                // laço vai preencher a 2º dimensão da matriz
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    // Exemplo 2 - Exercicio diagonal
    public void Exemplo02() {
        int[][] matriz = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    // Exemplo 2 - Exercicio inverter linhas e colunas
    public void Exemplo03() {
        int[][] matriz = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = j + 1;
            }
        }

        // for com posições normais
        for (int i = 0; i < 4; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }

        // for com posições trocadas
        System.out.println(" ");
        for (int i = 0; i < 4; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println("|");
        }
    }

    public void Exemplo03b() {
        int[][] matriz = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = j + 1;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matriz[i][j] = (i+1) + (j+1);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    public void Exemplo04() {
        int[][] matriz = new int[5][5];
        int soma = 0, soma2 = 0;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    matriz[i][j] = rd.nextInt(9);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i >= j) {
                    soma += matriz[i][j];
                } else {
                    soma2 += matriz[i][j];
                }
            }
        }
        System.out.println("");

        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("");
        System.out.println(" A soma da parte inferior: "+soma);
        System.out.println("");
        System.out.println(" A soma da parte superior: "+soma2);
        System.out.println("");
    }
}
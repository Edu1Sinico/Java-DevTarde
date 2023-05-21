package exeMatrizExtra;

import java.util.Random;
import java.util.Scanner;

public class ExeMatriz {
    Scanner sc = new Scanner(System.in);

    // Método 1
    public void Metodo01() {
        int[][] matriz = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Digite o " + (j + 1) + "º nº para a Matriz[" + (i + 1) + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = i * matriz[i][j];
            }
        }

        System.out.println("");
        System.out.println("Resultado das contas: ");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Matriz[" + (i + 1) + "][" + (j + 1) + "]: " + matriz[i][j]);
            }
        }
    }

    // Método 2
    public void Metodo02() {
        Random rd = new Random();
        int[][] matriz = new int[4][4];
        int temp = 0, maiorNum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = rd.nextInt(100);
                if (matriz[i][j] > maiorNum) {
                    maiorNum = matriz[i][j];
                }
            }
        }

        System.out.println("");
        System.out.println("Matriz: ");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println((i + 1) + "º Matriz: " + matriz[i][j]);
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("Maior número: " + maiorNum);
        System.out.println("");
    }

    // Método 3
    public void Metodo03() {
        Random rd = new Random();
        int[][] matriz = new int[5][5];
        int x = 0, temp = 0;
        String text = "";
        boolean verdadeiro = false;
        
        System.out.println("");
        System.out.println("Digite um número (De 0 a 20): ");
        x = sc.nextInt();
        System.out.println("");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = rd.nextInt(20);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] == x) {
                    System.out
                            .println("Valor encontrado na Matriz[" + (i + 1) + "][" + (j + 1) + "] = " + matriz[i][j]);
                    System.out.println("");
                    verdadeiro = true;
                } else {
                    text = "Valor não encotrado.";
                }
            }
        }

        if (verdadeiro == false)
            System.out.println(text);
    }

    // Método 4
    public void Metodo04() {
        int[][] matriz = new int[10][10];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i < j) {
                    matriz[i][j] = 2 * i + 7 * j - 2;
                } else if (i == j) {
                    matriz[i][j] = (int) (3 * Math.pow(i, 2) - 1);
                } else if (i > j) {
                    matriz[i][j] = (int) (4 * Math.pow(i, 3) - 5 * Math.pow(j, 2) + 1);
                }
            }
        }
        System.out.println("");
        System.out.println("Matriz: ");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println((i + 1) + "º Matriz: " + matriz[i][j]);
                System.out.println("");
            }
        }
    }

    // Método 5
    public void Metodo05() {
        int[][] matriz = new int[5][4];

    }

    // Método 6
    public void Metodo06() {
        int[][] A = new int[3][3];
        int[][] B = new int[3][3];
        int[][] C = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o " + (j + 1) + "º nº para a matriz A[" + (i + 1) + "]: ");
                A[i][j] = sc.nextInt();
                B[i][j] = (i+1);
                System.out.println("");
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                C[i][j] = B[i][j]*A[i][j];
            }
        }

        System.out.println("Matriz C: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Matriz C[i][j] = " + C[i][j]);
            }
        }

    }
}

package exeMatrizExtra;

import java.util.Random;
import java.util.Scanner;

import ExeExtraForWhile.ForWhile;

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
        double[][] matriz = new double[5][4];
        double temp = 0, MatrAluno = 0, maiorNota = 0, media = 0;
        String text = "";

        System.out.println("Informações dos alunos");
        System.out.println("");
        System.out.println(
                "Informe o nº da matrícula, a média das provas e dos trabalhos de cada aluno respectivamente.");
        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {text = "Digite o número da matrícula: ";} 
                else if (j == 1) {text = "Digite a média das provas: ";} 
                else {text = "Digite a média dos trabalhos: ";}

                System.out.println("Aluno " + (i + 1) + " - " + text);
                matriz[i][j] = sc.nextDouble();
                System.out.println();
            }
            // Cálculo da nota final
            matriz[i][3] = (matriz[i][1] + matriz[i][2]) / 2;
        }  

        //Matriz com a maior nota
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][3] > maiorNota)
            {
                MatrAluno = matriz[i][0];
                maiorNota = matriz[i][3];
            }
        }

        
        System.out.println("O aluno de matrícula " + MatrAluno + " Obteve a maior nota: " + maiorNota);
        System.out.println("");

        for (int i = 0; i < 5; i++) {
            temp += matriz[i][3];
            media = temp/5;
        }

        System.out.println("Média aritmética das notas: " + media);

    }

    // Método 6
    public void Metodo06() {
        int[][] A = new int[3][3];
        int[][] B = new int[3][3];
        int[][] C = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
<<<<<<< HEAD
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
=======
                System.out.print("Digite o " + (j + 1) + "º nº para a matriz A[" + (i + 1) + "][" + (j + 1) + "]: ");
                A[i][j] = sc.nextInt();
                B[i][j] = (i + 1);
                System.out.println("");
            }
        }
>>>>>>> 9cf4a677350a0cb08e143d0de99b0974a7a8fbb0

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                C[i][j] = B[i][j] * A[i][j];
            }
        }

        System.out.println("Matriz C: ");
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Matriz C[i][j] = " + C[i][j]);
                System.out.println("");
            }
        }
    }
}

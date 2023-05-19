package exeMatrizExtra;

import java.util.Scanner;

public class ExeMatriz {
    Scanner sc = new Scanner(System.in);

    public void Metodo01() {
        int[][] matriz = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Digite o " + (j + 1) + "º nº para a Matriz[" + (i+1) + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
    }
}

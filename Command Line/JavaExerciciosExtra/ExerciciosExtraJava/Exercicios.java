package ExerciciosExtraJava;

import java.util.Scanner;

public class Exercicios {
    Scanner sc = new Scanner(System.in);
    int x = 0, y = 0, z = 0;

    // ---------------------------------------------------------//
    // Método 01
    public void Metodo01() {
        int A[] = { 1, 2, 3, 4, 5 };
        int B[] = new int[5];
        x = 0;
        y = 0;

        /*
         * B[0] = A[0];
         * B[1] = A[1];
         * B[2] = A[2];
         * B[3] = A[3];
         * B[4] = A[4];
         * 
         * ou
         * 
         */
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }

        System.out.println("Os elementos de A: ");
        for (int i = 0; i < A.length; i++) {
            x++;
            System.out.println(x + "º " + A[i]);
        }

        System.out.println("");

        System.out.println("Os elementos de B: ");
        for (int i = 0; i < B.length; i++) {
            y++;
            System.out.println(y + "º " + B[i]);
        }
    }

    // ---------------------------------------------------------//
    // Método 02
    public void Metodo02() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] B = new int[8];
        x = 0;
        y = 0;

        for (int i = 0; i < A.length; i++) {
            B[i] = A[i] * 2;
        }

        System.out.println("Os elementos de A: ");
        for (int i = 0; i < A.length; i++) {
            x++;
            System.out.println(x + "º " + A[i]);
        }

        System.out.println("");

        System.out.println("Os elementos de B: ");
        for (int i = 0; i < B.length; i++) {
            y++;
            System.out.println(y + "º " + B[i]);
        }
    }

    // ---------------------------------------------------------//
    // Método 03
    public void Metodo03() {
        int[] A = new int[15];
        int[] B = new int[15];

        /*
         * for(int i = 0; i < A.length; i++)
         * {
         * A[i] = i+1;
         * }
         * 
         * ou
         * 
         */

        for (int i = 0; i < A.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º elemento de A: ");
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < A.length; i++) {
            B[i] = A[i] * A[i];
        }
        System.out.println();

        System.out.println("Os elementos de A: ");
        for (int i = 0; i < A.length; i++) {
            x++;
            System.out.println(x + "º " + A[i]);
        }

        System.out.println("");

        System.out.println("Os elementos de B: ");
        for (int i = 0; i < B.length; i++) {
            y++;
            System.out.println(y + "º " + B[i]);
        }
    }

    // ---------------------------------------------------------//
    // Método 04
    public void Metodo04() {
        double[] A = new double[15];
        double[] B = new double[15];

        for (int i = 0; i < A.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º elemento de A: ");
            A[i] = sc.nextDouble();
        }

        for (int i = 0; i < A.length; i++) {
            B[i] = Math.sqrt(A[i]);
        }
        System.out.println();

        System.out.println("Os elementos de A: ");
        for (int i = 0; i < A.length; i++) {
            x++;
            System.out.println(x + "º " + A[i]);
        }

        System.out.println("");

        System.out.println("Os elementos de B: ");
        for (int i = 0; i < B.length; i++) {
            y++;
            System.out.println(y + "º " + B[i]);
        }
    }

    // ---------------------------------------------------------//
    // Método 05
    public void Metodo05() {
        int[] A = new int[10];
        int[] B = new int[10];

        for (int i = 0; i < A.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º elemento de A: ");
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < A.length; i++) {
            B[i] = A[i] * i;
        }
        System.out.println();

        System.out.println("Os elementos de A: ");
        for (int i = 0; i < A.length; i++) {
            x++;
            System.out.println(x + "º " + A[i]);
        }

        System.out.println("");

        System.out.println("Os elementos de B: ");
        for (int i = 0; i < B.length; i++) {
            y++;
            System.out.println(y + "º " + B[i]);
        }
    }

    // ---------------------------------------------------------//
    // Método 05
    public void Metodo06() {
        int[] A = new int[10];
        int[] B = new int[10];
        int[] C = new int[10];

        for (int i = 0; i < A.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º elemento de A: ");
            A[i] = sc.nextInt();
        }
        System.out.println("");

        for (int i = 0; i < B.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º elemento de B: ");
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < C.length; i++)
        {
            C[i] = A[i] + B[i];
        }
        System.out.println();

        System.out.println("Os elementos de A: ");
        for (int i = 0; i < A.length; i++) {
            x++;
            System.out.println(x + "º " + A[i]);
        }

        System.out.println("");

        System.out.println("Os elementos de B: ");
        for (int i = 0; i < B.length; i++) {
            y++;
            System.out.println(y + "º " + B[i]);
        }
        System.out.println("");
        
        System.out.println("Os elementos de C: ");
        for (int i = 0; i < C.length; i++) {
            z++;
            System.out.println(z + "º " + C[i]);
        }
    }
}

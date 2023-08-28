package IteracaoWhile;

import java.util.Scanner;

public class ExerciciosWhile {
    Scanner sc = new Scanner(System.in);

    public void Exercicio1() {
        int[] A = new int[]{5,7,9,10,13};
        int[] B = new int[5];
        int i = 0;

        while (i<5) {
            B[i] = A[i];
            System.out.println("Vetor B: " + B[i]);
            i++;
        }
    }

    public void Exercicio2() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] B = new int[8];
        int i = 0;

        while(i<8){
            B[i] = A[i]*2;
            System.out.println("Vetor B: " + B[i]);
            i++;
        }
    }

    public void Exercicio3() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int[] B = new int[15];
        int i = 0;

        while(i<15){
            B[i] = A[i]*A[i];
            System.out.println("Vetor B: " + B[i]);
            i++;
        }
    }

    public void Exercicio4() {
        double[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        double[] B = new double[15];
        int i = 0;

        while(i<15){
            B[i] = Math.sqrt(A[i]);
            System.out.println("Vetor B: " + B[i]);
            i++;
        }
    }

    public void Exercicio5() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] B = new int[10];
        int i = 0;

        while(i<10){
            B[i] = A[i]*i;
            System.out.println("Vetor B: " + B[i]);
            i++;
        }
    }

    public void Exercicio6() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] B = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] C = new int[10];
        int i = 0;

        while(i<10){
            C[i] = A[i]+B[i];
            System.out.println("Vetor C: " + C[i]);
            i++;
        }
    }
}

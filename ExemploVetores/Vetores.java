package ExemploVetores;

import java.util.Scanner;

public class Vetores {
    Scanner sc = new Scanner(System.in);

    public void Metodo01() {
        // Vetor de 5 nº inteiros
        int vetorInt[] = new int[5];
        int vetorInt2[] = new int[] {1, 2, 3, 4, 5};

        System.out.println("Digite um valor. [Números inteiros]");
        vetorInt[0] = sc.nextInt();
        System.out.println("Digite um valor. [Números inteiros]");
        vetorInt[1] = sc.nextInt();
        System.out.println("Digite um valor. [Números inteiros]");
        vetorInt[2] = sc.nextInt();
        System.out.println("Digite um valor. [Números inteiros]");
        vetorInt[3] = sc.nextInt();
        System.out.println("Digite um valor. [Números inteiros]");
        vetorInt[4] = sc.nextInt();

        System.out.println("O valor da 1ª posição é " + vetorInt[0]);
        System.out.println("O valor da 2ª posição é " + vetorInt[1]);
        System.out.println("O valor da 3ª posição é " + vetorInt[2]);
        System.out.println("O valor da 4ª posição é " + vetorInt[3]);
        System.out.println("O valor da 5ª posição é " + vetorInt[4]);
    }

    public void Metodo02(){

        double VetorDouble[] = new double [10];
        
        System.out.println("Digite um valor. [Números inteiros]");
        VetorDouble[0] = sc.nextDouble();
        VetorDouble[1] = sc.nextDouble();
        VetorDouble[2] = sc.nextDouble();
        VetorDouble[3] = sc.nextDouble();
        VetorDouble[4] = sc.nextDouble();
        VetorDouble[5] = sc.nextDouble();
        VetorDouble[6] = sc.nextDouble();
        VetorDouble[7] = sc.nextDouble();
        VetorDouble[8] = sc.nextDouble();
        VetorDouble[9] = sc.nextDouble();

        System.out.println("O valor da 10ª posição é " + VetorDouble[9]);
        System.out.println("O valor da 9ª posição é " + VetorDouble[8]);
        System.out.println("O valor da 8ª posição é " + VetorDouble[7]);
        System.out.println("O valor da 7ª posição é " + VetorDouble[6]);
        System.out.println("O valor da 6ª posição é " + VetorDouble[5]);
        System.out.println("O valor da 5ª posição é " + VetorDouble[4]);
        System.out.println("O valor da 4ª posição é " + VetorDouble[3]);
        System.out.println("O valor da 3ª posição é " + VetorDouble[2]);
        System.out.println("O valor da 2ª posição é " + VetorDouble[1]);
        System.out.println("O valor da 1ª posição é " + VetorDouble[0]);
    }
}

package ExeExtraIFElse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Exercicios ex = new Exercicios();
        Scanner sc = new Scanner(System.in);
        int Receber = 0, x;
        do {
            System.out.println("========================");
            System.out.println("Escolha uma das opções: ");
            System.out.println("1 - Exercício 1");
            System.out.println("2 - Exercício 2");
            System.out.println("3 - Exercício 3");
            System.out.println("4 - Exercício 4");
            System.out.println("5 - Exercício 5");
            Receber = sc.nextInt();

            switch (Receber) {
                case 1: {
                    ex.exercicio1();
                    break;
                }
                case 2: {
                    ex.exercicio2();
                    break;
                }
                case 3: {
                    ex.exercicio3();
                    break;
                }
                case 4: {
                    ex.exercicio4();
                    break;
                }
                case 5: {
                    ex.exercicio5();
                    break;
                }
                default:
                    System.out.println("Escolha uma dessas opções!");
                    break;
            }
            System.out.println("Deseja continuar? Pressione 0, caso contrário precione qualquer número.");
            x = sc.nextInt();
        } while (x == 0);
    }
}

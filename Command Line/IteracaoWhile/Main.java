package IteracaoWhile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExemploWhile obj = new ExemploWhile();
        ExerciciosWhile obj1 = new ExerciciosWhile();
        Scanner sc = new Scanner(System.in);
        int x = 0;
        do {
            System.out.println("");
            System.out.println("Pressione uma das opções: ");
            System.out.println("1º Exercicio 1;");
            System.out.println("2º Exercicio 2;");
            System.out.println("3º Exercicio 3;");
            System.out.println("4º Exercicio 4;");
            System.out.println("5º Exercicio 5;");
            System.out.println("6º Exercicio 6.");
            int receber = sc.nextInt();
            System.out.println("");
            System.out.println("--------------------------------------");
            System.out.println("");

            switch (receber) {
                case 1: {
                    obj1.Exercicio1();
                    break;
                }

                case 2: {
                    obj1.Exercicio2();
                    break;
                }

                case 3: {
                    obj1.Exercicio3();
                    break;
                }

                case 4: {
                    obj1.Exercicio4();
                    break;
                }

                case 5: {
                    obj1.Exercicio5();
                    break;
                }

                case 6: {
                    obj1.Exercicio6();
                    break;
                }


                default: {
                    System.out.println("Por favor, selecione uma das opções acima.");
                    break;
                }
            }

            System.out.println("");
            System.out.println("--------------------------------------");
            System.out.println("");
            System.out.println("Deseja continuar? Precione 0, caso contrário pressione qualquer número.");
            x = sc.nextInt();
        } while (x == 0);
    }

      // obj.Metodo01();

        // obj.Metodo02();

        // obj.Metodo03();

        // obj.Metodo04();
}
      

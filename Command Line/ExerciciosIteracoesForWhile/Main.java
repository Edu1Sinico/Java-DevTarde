package ExerciciosIteracoesForWhile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExercicioIteracoes obj = new ExercicioIteracoes();
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
            System.out.println("7º Exercicio 7.");
            System.out.println("8º Exercicio 8.");
            System.out.println("9º Exercicio 9.");
            int receber = sc.nextInt();
            System.out.println("");
            System.out.println("--------------------------------------");
            System.out.println("");

            switch (receber) {
                case 1: {
                    obj.Metodo01();
                    break;
                }

                case 2: {
                    obj.Metodo02();
                    break;
                }

                case 3: {
                    obj.Metodo03();
                    break;
                }

                case 4: {
                    // obj.Metodo04();
                    obj.Metodo04Mod();
                    break;
                }

                case 5: {
                    obj.Metodo05();
                    break;
                }

                case 6: {
                    obj.Metodo06();
                    break;
                }
                case 7: {
                    obj.Metodo07();
                    break;
                }
                case 8: {
                    obj.Metodo08();
                    break;
                }
                case 9: {
                    obj.Metodo09();
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
}


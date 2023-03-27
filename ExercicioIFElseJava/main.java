package ExercicioIFElseJava;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ClasseDecisao cd = new ClasseDecisao();
        Scanner sc = new Scanner(System.in);
        int receber = 0, continuar;
        do {
            System.out.println("Exercício de estruturad de decisão.");
            System.out.println("========================================");
            System.out.println("Precione 1 para o primeiro exercício.");
            System.out.println("Precione 2 para o segundo exercício.");
            System.out.println("Precione 3 para o terceiro exercício.");
            System.out.println("Precione 4 para o quarto exercício.");
            System.out.println("Precione 5 para o quinto exercício.");
            System.out.println("Precione 6 para o sexto exercício.");
            System.out.println("Precione 7 para o sétimo exercício.");
            System.out.println("");
            receber = sc.nextInt();

            switch (receber) {
                case 1: {
                    cd.Exercicio1();
                    break;
                }
                case 2: {
                    cd.Exercicio2();
                    break;
                }
                case 3: {
                    cd.Exercicio3();
                    break;
                }
                case 4: {
                    cd.Exercicio4();
                    break;
                }
                case 5: {
                    cd.Exercicio5();
                    break;
                }
                case 6: {
                    cd.Exercicio6();
                    break;
                }
                case 7: {
                    cd.Exercicio7();
                    break;
                }
                default: {
                    System.out.println("Por favor, digite um dos números pedidos acima.");
                    break;
                }
            }
            System.out.println("Deseja continuar? Precione 0, caso contrario, precione qualquer outro número.");
            continuar = sc.nextInt();
        } while (continuar == 0);
    } 
}

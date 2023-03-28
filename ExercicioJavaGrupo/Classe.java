package ExercicioJavaGrupo;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Classe {
    Scanner sc = new Scanner(System.in);
    int x = 0;

    public void metodo01() {
        do {
            System.out.println("=============================");
            System.out.println("---=Atividades dos alunos=---");
            System.out.println();
            System.out.println("Digite o seu nome:");
            String nome = sc.nextLine();
            System.out.println("Informe sua idade:");
            int idade = sc.nextInt();
            System.out.println("Informe seu sexo: 1 - Feminino, 2 - Masculino.");
            int sexo = sc.nextInt();
            System.out.println("Informe sua altura:");
            double altura = sc.nextDouble();
            System.out.println("Informe seu peso:");
            double peso = sc.nextDouble();

            System.out.println();
            System.out.println("Escolha uma das opções:");
            System.out.println();
            System.out.println("1 - Calcular o peso ideal");
            System.out.println("2 - Calcular o IMC do Aluno");
            int receber = sc.nextInt();

            switch (receber) {
                case 1: {
                    System.out.println();
                    System.out.println("---=Calculo de peso ideal=---");
                    System.out.println();

                    // Calculo do peso ideal:
                    switch (sexo) {

                        // Feminino
                        case 1: {
                            double pesoIdeal = 45.5 + 2.3 * ((altura * 100) - 152.4) / 2.54;
                            double diferenca = peso - pesoIdeal;
                            if (diferenca > 0) {
                                System.out.println("Peso ideal: " + String.format("%.1f", pesoIdeal));
                                System.out.println("Você precisa perder: " + String.format("%.1f", diferenca)
                                        + " Kg para chegar ao peso ideal.");
                            } else if (diferenca < 0) {
                                System.out.println("Peso ideal: " + String.format("%.1f", pesoIdeal));
                                System.out.println("Você precisa ganhar: " + String.format("%.1f", diferenca)
                                        + " Kg para chegar ao peso ideal.");
                            } else {
                                System.out.println("Você está no peso ideal: " + String.format("%.1f", pesoIdeal));
                            }
                            break;
                        }

                        // Masculino
                        case 2: {
                            double pesoIdeal = 50.0 + 2.3 * ((altura * 100) - 152.4) / 2.54;
                            double diferenca = peso - pesoIdeal;
                            if (diferenca > 0) {
                                System.out.println("Peso ideal: " + String.format("%.1f", pesoIdeal));
                                System.out.println("Você precisa perder: " + String.format("%.1f", diferenca)
                                        + " Kg para chegar ao peso ideal.");
                            } else if (diferenca < 0) {
                                System.out.println("Peso ideal: " + String.format("%.1f", pesoIdeal));
                                System.out.println("Você precisa ganhar: " + String.format("%.1f", diferenca)
                                        + " Kg para chegar ao peso ideal.");
                            } else {
                                System.out.println("Você está no peso ideal: " + String.format("%.1f", pesoIdeal));
                            }
                            break;
                        }

                        default: {
                            System.out.println("Por favor, selecione 1 para feminino ou 2 para masculino.");
                            break;
                        }
                    }
                    break;
                }

                case 2: {
                    System.out.println();
                    System.out.println("---=Calculo de IMC=---");
                    System.out.println();

                    // Calculo de IMC

                    

                    break;
                }

                default: {
                    System.out.println("Por favor escolha uma das opções acima.");
                    break;
                }
            }

            System.out.println("Deseja continuar? Precione 0, caso contrário precione qualquer outro número.");
            x = sc.nextInt();
        } while (x == 0);
    }
}
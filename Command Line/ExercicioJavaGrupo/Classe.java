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
                    System.out.println("=============================");
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
                    System.out.println("======================");
                    System.out.println("---=Calculo de IMC=---");
                    System.out.println();

                    // Calculo de IMC

                    double imc = peso / Math.pow(altura,2);
                    

                    //Nível difícil
                    if (imc < 20 && idade >= 25 && idade <=45)
                    {
                        System.out.println("Você está abaixo do peso ideal, seu nível é 'Difícil' e precisa ganhar massa muscular.");
                        System.out.println("Sua idade: " + idade);
                        System.out.println("Você pode realizar as seguintes atividades de acordo com seu nível e faixa etária: ");
                        System.out.println("");
                        System.out.println("Musculação intensa;");
                        System.out.println("Luta livre.");
                        System.out.println("");
                    }
                    else if (imc < 20 && idade >= 36 && idade <= 55)
                    {
                        System.out.println("Você está abaixo do peso ideal, seu nível é 'Difícil' e precisa ganhar massa muscular.");
                        System.out.println("Sua idade: " + idade);
                        System.out.println("Você pode realizar as seguintes atividades de acordo com seu nível e faixa etária: ");
                        System.out.println("");
                        System.out.println("Luta livre.");
                        System.out.println("");
                    }
                    else if (imc < 20 && idade >= 46)
                    {
                        System.out.println("Você está abaixo do peso ideal, seu nível é 'Difícil' e precisa ganhar massa muscular.");
                        System.out.println("Sua idade: " + idade);
                        System.out.println("Você pode realizar as seguintes atividades de acordo com seu nível e faixa etária: ");
                        System.out.println("");
                        System.out.println("Pilates.");
                        System.out.println("");
                    }

                    //Nível moderado
                    else if (imc > 20 && imc < 27 && idade >= 16 && idade <= 55)
                    {
                        System.out.println("Você está no seu peso ideal, seu nível é 'Moderado' e está com o peso normal.");
                        System.out.println("Sua idade: " + idade);
                        System.out.println("Você pode realizar as seguintes atividades de acordo com seu nível e faixa etária: ");
                        System.out.println("");
                        System.out.println("Dança;");
                        System.out.println("Musculação moderada.");
                        System.out.println("");
                    }
                    else if (imc > 20 && imc < 27 && idade >= 25 && idade <= 65)
                    {
                        System.out.println("Você está no seu peso ideal, seu nível é 'Moderado' e está com o peso normal.");
                        System.out.println("Sua idade: " + idade);
                        System.out.println("Você pode realizar as seguintes atividades de acordo com seu nível e faixa etária: ");
                        System.out.println("");
                        System.out.println("Dança;");
                        System.out.println("Corrida.");
                        System.out.println("");
                    }

                    //Nível leve
                    else if (imc > 27 && idade >= 16 && idade >= 66)
                    {
                        System.out.println("Você está acima do peso ideal, seu nível é 'leve' e precisa perder peso.");
                        System.out.println("Sua idade: " + idade);
                        System.out.println("Você pode realizar as seguintes atividades de acordo com seu nível e faixa etária: ");
                        System.out.println("");
                        System.out.println("Musculação leve;");
                        System.out.println("Ioga.");
                        System.out.println("");
                    }
                    else
                    {
                        System.out.println("Você está em seu peso ideal de acordo com sua idade e IMC");
                        System.out.println("Você está em seu peso ideal de acordo com sua idade e IMC.");
                        System.out.println("Sua idade: " + idade);
                    }
                    
                    break;
                }

                default: {
                    System.out.println("Por favor escolha uma das opções acima.");
                    break;
                }
            }

            System.out.println("");
            System.out.println("Deseja continuar? Precione 0, caso contrário precione qualquer outro número.");
            x = sc.nextInt();
        } while (x == 0);
    }
}

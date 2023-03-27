package ExeExtraIFElse;

import java.util.Scanner;

public class Exercicios {
    Scanner sc = new Scanner(System.in);
    int x = 0;
    String letra;

    // Exercício 1
    public void exercicio1() {
        System.out.println("Digite um número: ");
        x = sc.nextInt();
        if (x % 2 == 0) {
            System.out.println("O número digitado é par: " + x);
        } else {
            System.out.println("O número digitado é ímpar: " + x);
        }
    }

    // Exercício 2
    public void exercicio2() {
        System.out.println("Digite sua nota: ");
        x = sc.nextInt();
        if (x >= 0 && x <= 10) {
            if (x >= 7 && x <= 10) {
                System.out.println("Passou!");
            } else if (x >= 5 && x <= 7) {
                System.out.println("Recuperação!");
            } else if (x >= 0 && x <= 5) {
                System.out.println("Reprovado!");
            }
        } else {
            System.out.println("Nota invalida, digite novamente.");
        }
    }

    //Exercício 3
    public void exercicio3() {
        System.out.println("Digite uma letra: ");
        letra = sc.nextLine().toLowerCase();
            if (letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o")
                    || letra.equals("u")) {
                System.out.println("Essa letra é uma vogal.");
            } else {
                System.out.println("Essa letra é um consoante.");
            }
    }
    
    //Exercício 4
    public void exercicio4() {
        System.out.println("Digite seu salário: ");
        double salario = sc.nextDouble();
        if (salario <= 1280.00) {
            double total = salario + 0.20 * salario;
            System.out.println("Salário atual: R$ " + salario);
            System.out.println("Aumento de 20%");
            double aumento = total - salario;
            System.out.println("O aumento será de: R$ " + aumento);
            System.out.println("Salário após o aumento: R$ " + total);
        } else if (salario > 1280.00 && salario <= 1700.00) {
            double total = salario + 0.15 * salario;
            System.out.println("Salário atual: R$ " + salario);
            System.out.println("Aumento de 15%");
            double aumento = total - salario;
            System.out.println("O aumento será de: R$ " + aumento);
            System.out.println("Salário após o aumento: R$ " + total);
        } else if (salario > 1700.00 && salario < 2500.00) {
            double total = salario + 0.10 * salario;
            System.out.println("Salário atual: R$ " + salario);
            System.out.println("Aumento de 10%");
            double aumento = total - salario;
            System.out.println("O aumento será de: R$ " + aumento);
            System.out.println("Salário após o aumento: R$ " + total);
        } else if (salario >= 2500.00) {
            double total = salario + 0.05 * salario;
            System.out.println("Salário atual: R$ " + salario);
            System.out.println("Aumento de 5%");
            double aumento = total - salario;
            System.out.println("O aumento será de: R$ " + aumento);
            System.out.println("Salário após o aumento: R$ " + total);
        }
    }

    //Exercício 5
    public void exercicio5() {
        System.out.println("Informe sua carga horária do trabalho: ");
        int cargaHora = sc.nextInt();
        System.out.println("Agora informe a quantidade de horas trabalhas no mês: ");
        int HoraMes = sc.nextInt();
        double salarioBruto = cargaHora*HoraMes;
        if (salarioBruto <= 900)
        {
            System.out.println("O salário não será descontado.");
            System.out.println("A sua carga horária é de: " + cargaHora + " horas, e a quantidade de horas trabalhadas no mês foi de: " + HoraMes + " horas.");
            System.out.println("O salário bruto será de: R$ " + salarioBruto);
        }
        else if (salarioBruto > 900 && salarioBruto <= 1500)
        {
            System.out.println("O salário será descontado.");
            System.out.println("Salário bruto: R$ " + salarioBruto);
            double IR = salarioBruto*0.05;
            System.out.println("O IR(5%) será: R$ " + IR);
            double inss = salarioBruto*0.10;
            System.out.println("O INSS(10%) será: R$ " + inss);
            double fgts = salarioBruto*0.11;
            System.out.println("O FGTS(11%) será: R$ " + fgts);
            double descTotal = IR + inss + fgts;
            System.out.println("Valor total descontado: " + descTotal);
            double salarioLiq = salarioBruto - descTotal;
            System.out.println("O salário líquido será: R$ " + salarioLiq);
        }
        else if (salarioBruto > 1500 && salarioBruto <= 2500)
        {
            System.out.println("O salário será descontado.");
            System.out.println("Salário bruto: R$ " + salarioBruto);
            double IR = salarioBruto*0.10;
            System.out.println("O IR(10%) será: R$ " + IR);
            double inss = salarioBruto*0.10;
            System.out.println("O INSS(10%) será: R$ " + inss);
            double fgts = salarioBruto*0.11;
            System.out.println("O FGTS(11%) será: R$ " + fgts);
            double descTotal = IR + inss + fgts;
            System.out.println("Valor total descontado: " + descTotal);
            double salarioLiq = salarioBruto - descTotal;
            System.out.println("O salário líquido será: R$ " + salarioLiq);
        }
        else if (salarioBruto > 2500)
        {
            System.out.println("O salário será descontado.");
            System.out.println("Salário bruto: R$ " + salarioBruto);
            double IR = salarioBruto*0.20;
            System.out.println("O IR(20%) será: R$ " + IR);
            double inss = salarioBruto*0.10;
            System.out.println("O INSS(10%) será: R$ " + inss);
            double fgts = salarioBruto*0.11;
            System.out.println("O FGTS(11%) será: R$ " + fgts);
            double descTotal = IR + inss + fgts;
            System.out.println("Valor total descontado: " + descTotal);
            double salarioLiq = salarioBruto - descTotal;
            System.out.println("O salário líquido será: R$ " + salarioLiq);
        }
        
    }
}

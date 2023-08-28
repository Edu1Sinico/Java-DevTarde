package ExercicioExtraJava2;

import java.util.Scanner;

public class Exercicios {
    Scanner sc = new Scanner(System.in);
    int x = 0, y = 0, z = 0;
    double total = 0;


    public void Exercicio1() {
        System.out.println("Digite um número: ");
        x = sc.nextInt();
        if (x == 10)
        {
            System.out.println("Esse número é 10.");
        }
        else if(x >= 10)
        {
            System.out.println("Esse número é maior que 10: " + x);
        }
        else
        {
        System.out.println("Esse número é menor que 10: " + x);
        }
    }

    public void Exercicio2() {
        System.out.println("Digite a quantidade de horas trabalhas no mês:");
        x = sc.nextInt();
        System.out.println("Informe o salário por hora:");
        double z = sc.nextDouble();
        total = x*z;
        double horasExtras = x - 200;
        if(x > 200){
            double total2 = (horasExtras*z)*0.5;
            double resultado = total + total2;
            System.out.println("Salário com um acrésimo de 50%: R$ " + resultado + ".");
        }
        else
        System.out.println("Salário total: R$" + total);
    }

    public void Exercicio3() {
        System.out.println("Informe o seu salário:");
        double x = sc.nextDouble();
        System.out.println("Informe o valor total dos produtos vendidos:");
        double y = sc.nextDouble();
        total = x;
        if (y >= 0 && y <= 2500)
        {
            total += x*0.3;
            System.out.println("Salário total: R$ " + total);
        }
        else{
            total += x*0.5;
            System.out.println("Salário total: R$ " + total);
        }
    }

    public void Exercicio4() {
        System.out.println("Informe o número da conta:");
        x = sc.nextInt();
        System.out.println("Informe seu saldo:");
        double z = sc.nextDouble();
        System.out.println("Informe o débito:");
        double w = sc.nextDouble();
        System.out.println("Informe o crédito:");
        double y = sc.nextDouble();
        double saldoAtual = z - w + y;

        if (saldoAtual >= 0)
        {
            System.out.println("Saldo atual: Positivo.");
        }
        else 
        {
            System.out.println("Saldo atual: Negativo.");
        }
    }

    public void Exercicio5() {
        System.out.println("Digite um número:");
        x = sc.nextInt();
        System.out.println("Digite outro número:");
        y = sc.nextInt();
        System.err.println("Digite o último número:");
        z = sc.nextInt();

        if (x != y && x != z && z != y)
        {
            if (x > y && x > z)
            {
                System.out.println("O primeiro valor digitado é o maior número: " + x);
            }
            else if(y > x && y > z)
            {
                System.out.println("O segundo valor digitado é o maior número: " + y);
            }
            else
            {
                System.out.println("O terceiro valor digitado é o maior número: " + z);
            }
        }
        else{
            System.out.println("Os valores são iguais.");
        }
    }

    public void Exercicio6() {
        
    }

    public void Exercicio7() {
        System.out.println("Informe a descrição do produto:");
        sc.nextLine();
        String descricao = sc.nextLine();
        System.out.println("Digite a quantidade adquirida do produto:");
        x = sc.nextInt();
        System.out.println("Agora digite o preço desse produto:");
        double preco = sc.nextDouble();
        total = x*preco;
        if (x <= 5)
        {
            double totalPagar = total - total*0.2;
            System.out.println("Total a pagar será: R$" + totalPagar);
        }
        else if (x > 5 && x <= 10)
        {
            double totalPagar = total - total*0.3;
            System.out.println("Total a pagar será: R$" + totalPagar);
        }
        else
        {
            double totalPagar = total - total*0.5;
            System.out.println("Total a pagar será: R$" + totalPagar);
        }
    }
}

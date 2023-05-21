package ExeExtraForWhile;

import java.util.Scanner;

public class ForWhile {
    Scanner sc = new Scanner(System.in);

    // Exercício 1
    public void Metodo01() {
        String nome, senha;
        boolean verdadeiro = true;

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        while (verdadeiro) {
            System.out.println("Digite seu nome: ");
            nome = sc.next();
            System.out.println("");
            System.out.println("Digite sua senha: ");
            senha = sc.next();
            System.out.println("");
            if (nome.equals(senha)) {
                System.out.println("O nome e a senha não podem ser iguais.");
            } else {
                verdadeiro = false;
            }
            System.out.println("");
            System.out
                    .println("---------------------------------------------------------------------------------------");
        }
    }

    // Exercício 2
    public void Metodo02() {
        String nome;
        int idade = 0;
        double salario = 0;
        char sexo, estCivil;
        boolean verdadeiro = true;

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        while (verdadeiro) {
            System.out.println("Digite seu nome: ");
            nome = sc.nextLine();
            if (nome.length() < 3) {
                System.out.println("O nome não pode ter menos que 3 caracteres.");
            } else {
                verdadeiro = false;
            }
        }
        verdadeiro = true;

        while (verdadeiro) {
            System.out.println("Digite sua idade: ");
            idade = sc.nextInt();
            if (idade < 0 || idade > 150) {
                System.out.println("A idade precisa estar entre 0 e 150.");
            } else {
                verdadeiro = false;
            }
        }
        verdadeiro = true;

        while (verdadeiro) {
            System.out.println("Digite seu salário: ");
            salario = sc.nextDouble();
            if (salario < 0) {
                System.out.println("Não existe salário negativo.");
            } else {
                verdadeiro = false;
            }
        }
        verdadeiro = true;

        while (verdadeiro) {
            System.out.println("Digite seu sexo ('M' - Masculino; 'F' - Feminino): ");
            sexo = sc.next().toLowerCase().charAt(0);
            if (sexo == 'f' || sexo == 'm') {
                verdadeiro = false;
            } else {
                System.out.println("Caracter inválido.");
            }
        }
        verdadeiro = true;

        while (verdadeiro) {
            System.out
                    .println("Digite seu estado civil('C' - Casado; 'S' - Solteiro; 'V' - Viúvo; 'D' - Divorciado): ");
            estCivil = sc.next().toLowerCase().charAt(0);
            if (estCivil == 'c' || estCivil == 's' || estCivil == 'v' || estCivil == 'd') {
                verdadeiro = false;
            } else {
                System.out.println("Caracter inválido.");
            }
        }
        System.out.println("Parabéns, você completou o formulário!");
        // System.out.println("Informações coletadas: ");
        // System.out.println("Nome: " + nome);
        // System.out.println("Idade: " + idade);
        // System.out.println("Salário: R$" + salario);
        // System.out.println("Sexo: " + sexo);
        // System.out.println("Estado Civil: " + estCivil);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 3
    public void Metodo03() {
        int A = 80000, B = 200000, cont = 0, ano = 0;
        double conta1 = 0, conta2 = 0;
        boolean verdadeiro = true;

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("População do país A: " + A + " Habitantes.");
        System.out.println("");
        System.out.println("População do país B: " + B + " Habitantes.");
        System.out.println("");
        while (verdadeiro) {
            cont++;
            conta1 = A * (Math.pow(3, cont));
            conta2 = B * (Math.pow(1.5, cont));
            ano++;
            if (conta1 >= conta2) {
                verdadeiro = false;
            }
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("A quantidade de anos necessário para o país A ultrapassar o país B é: " + ano + " anos.");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 4
    public void Metodo04() {
        int A = 0, B = 0, ano = 0, cont = 0;
        double conta1 = 0, conta2 = 0, taxa1 = 0, taxa2 = 0;
        boolean verdadeiro = true;

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Informe a quantidade de habitantes do país A: ");
        A = sc.nextInt();
        System.out.println("Informe a taxa de crescimento do país A: ");
        taxa1 = sc.nextDouble();
        System.out.println("");
        System.out.println("Informe a quantidade de habitantes do país B: ");
        B = sc.nextInt();
        System.out.println("Informe a taxa de crescimento do país B: ");
        taxa2 = sc.nextDouble();
        System.out.println("");

        while (verdadeiro) {
            cont++;
            conta1 = A * (Math.pow(taxa1, cont));
            conta2 = B * (Math.pow(taxa2, cont));
            ano++;
            if (conta1 >= conta2) {
                verdadeiro = false;
            }
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("A quantidade de anos necessário para o país A ultrapassar o país B é: " + ano + " anos.");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 5
    public void Metodo05() {
        int[] vetor = new int[8];
        int temp = 0;

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Informe 8  números para o vetor: ");
        System.out.println("");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print((i + 1) + "º posição: ");
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > temp) {
                temp = vetor[i];
            }
        }
        System.out.println("");
        System.out.println("O maior número digitado foi: " + temp);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 6
    public void Metodo06() {
        int[] vetor = new int[1000];
        int[] vetor1 = new int[1000];

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
            if (vetor[i] % 3 == 0) {
                vetor1[i] = vetor[i];
            }
        }

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Vetor com números divisíveis por 3 menores que 1000: ");
        System.out.println("");
        for (int i = 0; i < vetor1.length; i++) {
            if (vetor1[i] != 0 && vetor1[i] < 1000)
                System.out.println(vetor1[i]);
        }
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 7
    public void Metodo07() {
        int num1 = 0, num2 = 0, temp = 0;
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("digite um número: ");
        num1 = sc.nextInt();
        System.out.println("");
        System.out.println("Digite outro número: ");
        num2 = sc.nextInt();
        System.out.println("");

        if (num1 > num2) {
            temp = num1;
            System.out.println("Números compreendidos entre o número " + num2 + " e o número " + num1 + ":");
            System.out.println("");
        } else {
            temp = num2;
            System.out.println("Números compreendidos entre o número " + num1 + " e o número " + num2 + ":");
            System.out.println("");
        }
        int[] vetor = new int[temp];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
            if (vetor[i] > num1 && vetor[i] < num2) {
                System.out.println(vetor[i]);
            } else if (vetor[i] > num2 && vetor[i] < num1) {
                System.out.println(vetor[i]);
            }
        }

        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");

    }

    // Exercício 8
    public void Metodo08() {
        int num = 0;
        int[] vetorTab = new int[10];
        int[] vetor = new int[10];

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("<-----[Programa de tabuada]----->");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Informe um número: ");
        num = sc.nextInt();
        System.out.println("");

        for (int i = 0; i < vetorTab.length; i++) {
            vetorTab[i] = i + 1;
            vetor[i] = num * vetorTab[i];
        }

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Tabuada do " + num + ":");
        System.out.println("");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println((i + 1) + "º Posição: " + vetor[i]);
        }
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 9
    public void Metodo09() {
        int num1 = 0, num2 = 0, total = 1;

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Digite um base: ");
        num1 = sc.nextInt();
        System.out.println("");
        System.out.println("Digite um expoente: ");
        num2 = sc.nextInt();
        System.out.println("");
        // total = Math.pow(num1, num2);
        for (int i = 0; i < num2; i++) {
            total *= num1;
        }
        System.out.println("O resultado será: " + total);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 10
    public void Metodo10() {
        int num = 0, CalcFib = 0, x = 0, y = 1;
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("-----[Série Fibonacci]-----");
        System.out.println("");
        System.out.println("Informe o n-ésimo termo que você deseja que pare.");
        num = sc.nextInt();
        System.out.println("");
        System.out.println("Sequência:");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        for (int i = 0; i < num; i++) {
            CalcFib = x + y;
            System.out.println((i + 1) + "º Posição: " + CalcFib);
            x = y; // O número que está em y, vai ficar armazenado em x, ex: x=0 e y=1 ---> x = y
                   // ---> x = 1.
            y = CalcFib; // O número que está na variavel CalcFib, vai ficar armazenado em y, ex: y=1 e
                         // calcFib=n ---> y = calcFib ---> y = n. O y irá ficar com o resultado da
                         // conta, fazendo com que se torne um ciclo.
        }
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 11
    public void Metodo11() {
        int num = 0, total = 1;
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Digite um número: ");
        num = sc.nextInt();
        System.out.println("");
        for (int i = num; i > 1; i--) {
            total *= i;
        }
        System.out.println("Resultado da fatoração do número " + num + ": " + total + ".");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Exercício 12
    public void Metodo12() {
        int num = 0;
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Digite um número: ");
        num = sc.nextInt();
        System.out.println("");
    }
}

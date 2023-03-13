package ExercicioIFElseJava;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class ClasseDecisao {

//Variáveis globais
int x = 0, y = 0, z = 0, total = 0;
double total1;
Scanner sc = new Scanner(System.in);

    //Método do exercício 1
    public void Exercicio1(){
        System.out.println("Digite o primeiro número: ");
        x = sc.nextInt();
        System.out.println("Agora digite o segundo número: ");
        y = sc.nextInt();
        if (x != y){
            if (x > y)
            {
                System.out.println("O primeiro número digitado '"+ x +"' é maior que o segundo '" + y +"'.");
            }
            else{
                System.out.println("O segundo número digitado '"+ y +"' é maior que o primeiro '" + x + "'.");
            }
        }
        else{
            System.out.println("Os números digitados são iguais.");
        }
    }

    //Método do exercício 2
    public void Exercicio2(){
        System.out.println("Digite o ano de seu nascimento: ");
        x = sc.nextInt();
        total = 2022 - x;
        if (total >= 16)
        {
            System.out.println("Você pode votar.");
        }
        else{
            System.out.println("Você não poderá votar esse ano.");
        }
    }

    //Método do exercício 3
    public void Exercicio3(){
        System.out.println("Digite a senha: ");
        x = sc.nextInt();
        if (x == 1234)
        {
            System.out.println("Access granted.");
        }
        else{
            System.out.println("Access denied.");
        }
    }

    //Método do exercício 4
    public void Exercicio4(){
        System.out.println("Digite a quantidade de maçãs coletadas: ");
        int x = sc.nextInt();
        if (x < 12)
        {
            total1 = x*0.30;
            System.out.println("As maçãs irão custar: " + total1);
        }
        else //if (x >= 12)
        {
            total1 = x*0.25;
            System.out.println("As maçãs irão custar: " + total1);
        }
    }

    //Método do exercício 5
    public void Exercicio5(){
        System.out.println("Digite o 1º número: ");
        x = sc.nextInt();
        System.out.println("Digite o 2º número: ");
        y = sc.nextInt();
        System.out.println("Digite o 3º número: ");
        z = sc.nextInt();
        if (x != y && x != z && y != z){
            if(x > y && x > z && z < y)
            {
                System.out.println("Ordem crescente:");
                System.out.println("1º " + z);
                System.out.println("2º " + y);
                System.out.println("3º " + x);
            }
            else if(y > x && y > z && z < x)
            {
                System.out.println("Ordem crescente:");
                System.out.println("1º " + z);
                System.out.println("2º " + x);
                System.out.println("3º " + y);
            }
            else if(z > x && z > y && y < x)
            {
                System.out.println("Ordem crescente:");
                System.out.println("1º " + y);
                System.out.println("2º " + x);
                System.out.println("3º " + z);
            }
            //-----------------------------------------------
            else if(x > y && x > z && y < z)
            {
                System.out.println("Ordem crescente:");
                System.out.println("1º " + y);
                System.out.println("2º " + z);
                System.out.println("3º " + x);
            }
            else if(y > x && y > z && x < z)
            {
                System.out.println("Ordem crescente:");
                System.out.println("1º " + x);
                System.out.println("2º " + z);
                System.out.println("3º " + y);
            }
            else if(z > x && z > y && x < y)
            {
                System.out.println("Ordem crescente:");
                System.out.println("1º " + x);
                System.out.println("2º " + y);
                System.out.println("3º " + z);
            }
        }
        else{
            System.out.println("Os números digitados são iguais.");
        }
    }

    //Método do excercício 6
    public void Exercicio6(){
        System.out.println("Digite sua altura: ");
        double altura = sc.nextDouble();
        System.out.println("Precione 1 para o sexo masculino ou 2 para o sexo feminino.");
        int sexo = sc.nextInt();
        if (sexo == 1)
        {
            total1 = (72.7*altura)-58;
            System.out.println("O peso ideal é: " + total1);
        }
        else if (sexo == 2)
        {
            total1 = (62.1*altura)-44.7;
            System.out.println("O peso ideal é: " + total1);
        }
        else
        System.out.println("Precione um desses números.");
    }

    //Método do exercício7
    public void Exercicio7(){
        System.out.println("Informe a nota 1 do aluno: ");
        x = sc.nextInt();
        System.out.println("Informe a nota 2 do aluno: ");
        y = sc.nextInt();
        double media = (x+y)/2;
        System.out.println("A média do aluno é: " + media);
        if (media >= 50)
        {
            System.out.println("Aluno aprovado por nota.");
        }
        else{
            System.out.println("Aluno reprovado por nota.");
        }
        System.out.println("Informe a frequência do aluno: ");
        int freqAluno = sc.nextInt();
        if (freqAluno >= 75)
        {
            System.out.println("Aluno aprovado por frequência.");
        }
        else{
            System.out.println("Aluno reprovado por frequência.");
        }
        if (media >= 50 && freqAluno >= 75)
        {
            System.out.println("Aluno aprovado no curso.");
        }
        else{
            System.out.println("Aluno reprovado no curso.");
        }
    }
}
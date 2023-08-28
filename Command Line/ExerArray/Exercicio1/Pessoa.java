package ExerArray.Exercicio1;

import java.util.Scanner;

public class Pessoa {
    Scanner sc = new Scanner(System.in);
    private String nome;
    private double altura;
    private int dia, mes, ano, idade;

    public void recolherDados() {
        System.out.println("Informe o nome da pessoa: ");
        setNome(sc.nextLine());
        System.out.println("\nInforme a altura da pessoa: ");
        setAltura(sc.nextDouble());
        System.out.println("\nInforme o dia de nascimento da pessoa: ");
        setDia(sc.nextInt());
        System.out.println("\nInforme o mes de nascimento da pessoa: ");
        setMes(sc.nextInt());
        System.out.println("\nInforme o ano de nascimento da pessoa: ");
        setAno(sc.nextInt());
        imprimirDados();
    }

    public void imprimirDados() {
        System.out.println("\nNome da pessoa: " + nome);
        System.out.printf("\nAltura da pessoa: %.2f\n", altura);
        System.out.println("\nData de nascimento: " + dia + "/" + mes + "/" + ano);
        System.out.println("\nSua idade é: " + calcIdade());
    }

    public int calcIdade() {
        if (dia <= 5 && mes <= 6) {
            idade = 2023 - ano;
        }
        else
        {
            idade = 2023 - ano - 1;
        }
        return idade;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

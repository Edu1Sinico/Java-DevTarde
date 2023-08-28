package CalculadoraVelocidadeScanner;

import java.util.Scanner;

public class calcularVelocidade {

    public void calcular()
    {
        Scanner sc = new Scanner(System.in);
        int distanciaPercorrida = 0, tempoGasto = 0;
        double velocidadeMedia = 0.0;
        System.out.println("Digite a distância percorrida: ");
        distanciaPercorrida = sc.nextInt();
        System.out.println("Agora digite o tempo percorrido: ");
        tempoGasto = sc.nextInt();
        velocidadeMedia = distanciaPercorrida/tempoGasto;
        System.out.println("A velocidade média é de: " + velocidadeMedia + " km/h");
        sc.close();
    }
}
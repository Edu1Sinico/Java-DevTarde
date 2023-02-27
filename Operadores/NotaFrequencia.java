package Operadores;

import java.util.Scanner;

public class NotaFrequencia {
    
    Scanner sc = new Scanner(System.in);
    int nota1 = 0, nota2 = 0;
    double media;
    int frequencia = 0;

    public void NotaMedia(){
        System.out.println("Digite a sua primeira nota: ");
        nota1 = sc.nextInt();
        System.out.println("Agora digite a sua segunda: ");
        nota2 = sc.nextInt();
        media = (nota1 + nota2)/2;
        System.out.println("Sua média foi de: " + media );
        if (media >= 50) //ou boolean MediaAprov = media >= 50;
        {
            System.out.println("Aluno aprovado por nota.");
        }
        else 
        {
            System.out.println("Aluno reprovado por nota.");
        }
    }

    public void Frequencia()
    {
        System.out.println("Informe sua frequência: ");
        frequencia = sc.nextInt();
        System.out.println("Sua frequência é de: " + frequencia);
        if (frequencia >= 75)
        {
            System.out.println("Aluno aprovado por frequência.");
        }
        else
        {
            System.out.println("Aluno reprovado por frequência.");
        }
    }

    public void MediaEFrequencia()
    {
        System.out.println("Aprovação no curso.");
        if (media >= 50 && frequencia >= 75)
        {
            System.out.println("Aluno aprovado no curso.");
        }
        else 
        {
            System.out.println("Aluno reprovado no curso.");
        }
    }

}

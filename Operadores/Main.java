package Operadores;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NotaFrequencia NF = new NotaFrequencia();
        int voltar;
        do
        {
        System.out.println("Pressione 1 para informar a Nota. Pressione 2 para informar a frequência. Pressione 3 para verificar a aprovação no curso. ");
        int escolha = sc.nextInt();
        switch (escolha)
        {
            case 1:
            {
                NF.NotaMedia();
                break;
            }
            case 2: 
            {
                NF.Frequencia();
                break;
            }
            case 3:
            {
                NF.MediaEFrequencia();
                break;
            }
            default:
            {
                System.out.println("Precione uma dessas teclas.");
            }
            
        }
        System.out.println("Deseja continuar? Pressione 0.");
        voltar = sc.nextInt();
    }while(voltar == 0);
    }
}

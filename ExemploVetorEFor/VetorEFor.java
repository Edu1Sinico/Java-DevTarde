package ExemploVetorEFor;

import java.util.Scanner;

public class VetorEFor {
    Scanner sc = new Scanner(System.in);
    
    public void Metodo01() {
        //Criando os vetores
        int[] Vetor = new int[5]; // Tamanho do vetor vai de: (0,1,2,3,4) onde 0 é a linha 1 (inicial) e 4 é a linha 5 (final) 
        int[] Vetor1 = {1,2,5,9,10}; // Declarando os vetor com os atributos já prontos.

        //Declarando vetores
        Vetor[0] = 4; // ---> Colocando o 4 na linha 0 (inicial)
        Vetor[1] = 7; // ---> Colocando o 7 na linha 1
        Vetor[2] = 5; // ---> Colocando o 5 na linha 2
        Vetor[3] = 8; // ---> Colocando o 8 na linha 3
        Vetor[4] = 10;// ---> Colocando o 10 na linha 4 (Final)
        
        //Exibindo os elementos dos vetores
        System.out.println(Vetor[0]); // ---> Exibir o 4
        System.out.println(Vetor[1]); // ---> Exibir o 7
        System.out.println(Vetor[2]); // ---> Exibir o 5
        System.out.println(Vetor[3]); // ---> Exibir o 8
        System.out.println(Vetor[4]); // ---> Exibir o 10
    }

    public void Metodo02() {
        //Criando os vetores
        int[] Vetor = new int[10];

        //Criação do for de forma incrementar (Adiciona 1)
        for (int i = 0; i < 10; i++) {
            Vetor[i] = (i+1);
        }

        //Criação do for de forma incrementar (Adiciona 1)
        for (int i = 0; i < 10; i++) {
            Vetor[i] = sc.nextInt();
        }

        //Exibindo os elementos dos vetores
        System.out.println("");
        System.out.println("Os valores do vetor são: ");
        System.out.println("");
        for(int i = 0; i < 10; i++)
        {
            System.out.println(Vetor[i]);
        }
    }
}

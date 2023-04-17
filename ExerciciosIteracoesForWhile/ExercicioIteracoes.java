package ExerciciosIteracoesForWhile;

import java.util.Scanner;

public class ExercicioIteracoes {
    Scanner sc = new Scanner(System.in);

    // -----------------------------------------------------------------------------------------
    // Método 1
    public void Metodo01() {
        int[] vetor = new int[5];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe para o vetor de índice " + (i+1) + ": ");
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("O elemento do vetor no índice " + (i+1) + " é:" + vetor[i]);
        }
    }

    // -----------------------------------------------------------------------------------------
    // Método 2
    public void Metodo02() {
        double[] vetor = new double[10];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe para o vetor de índice " + (i+1) + ": ");
            vetor[i] = sc.nextDouble();
        }
        for (int i = 9; i < vetor.length; i--) {
            System.out.println("O elemento do vetor no índice " + (i+1) + " é:" + vetor[i]);
        }
    }

    // -----------------------------------------------------------------------------------------
    // Método 3
    public void Metodo03() {
        double[] vetor = new double[4];
        double nota = 0, total = 0, media = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe a " + (i+1) + "ª nota do aluno: ");
            vetor[i] = sc.nextDouble();
        }

        for (int i = 0; i < vetor.length; i++) {
            nota = vetor[i];
            total += nota;
        }
        media = total / 4;
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("A " + (i+1) + "ª nota digita foi: " + vetor[i]);
        }
        System.out.println("A média será de: " + media);

    }

    // -----------------------------------------------------------------------------------------
    // Método 4
    public void Metodo04() {
        char[] vetorLetras = new char[10];
        int consoantes = 0;

        System.out.println("Digite 10 caracteres: ");
        for (int i = 0; i < vetorLetras.length; i++) {
            System.out.print((i+1) + "º ");
            vetorLetras[i] = sc.next().charAt(0);
            if (Character.isLetter(vetorLetras[i]) && !Vogal(vetorLetras[i])) {
                consoantes++;
            }
        }

        System.out.println("Número de consoantes lidas: " + consoantes);
        System.out.println("Consoantes lidas:");
        for (char c : vetorLetras) {
            if (Character.isLetter(c) && !Vogal(c)) {
                System.out.println(c);
            }
        }

    }

    public static boolean Vogal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public void Metodo04Mod() {
        System.out.println("Digite uma palavra: ");
        int cont = 0;
        String palavra = sc.next();
        palavra.toLowerCase();
        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            if (Character.isLetter(c) && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u')
            {
                cont++;
                System.out.println("Consoantes da palavra: " + c);
            }
        }
        System.out.println("Total de consoantes da palavra: " + cont);
    }

    // -----------------------------------------------------------------------------------------
    // Método 5
    public void Metodo05() {
        int[] vetor = new int[20];
        int[] vetorPar = new int[20];
        int[] vetorImpar = new int[20];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe para o vetor de índice " + (i+1) + ": ");
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                vetorPar[i] = vetor[i];
            } else {
                vetorImpar[i] = vetor[i];
            }
        }

        System.out.println("Números que você informou: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println((i+1) + "º " + vetor[i]);
        }

        System.out.println("");
        System.out.println("Vetor de números pares: ");
        for (int i = 0; i < vetorPar.length; i++) {
            if (vetorPar[i] != 0)
                System.out.println(vetorPar[i]);
        }

        System.out.println("");
        System.out.println("Vetor de números impares: ");
        for (int i = 0; i < vetorImpar.length; i++) {
            if (vetorImpar[i] != 0)
                System.out.println(vetorImpar[i]);
        }
    }

    public void Metodo05Mod() {
        int[] vetor = new int[20];
        int contImpar = 0, contPar = 0;
        int[] vetorPar = new int[contPar];
        int[] vetorImpar = new int[contImpar];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe para o vetor de índice " + (i+1) + ": ");
            vetor[i] = sc.nextInt();
        }
        
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                contPar++;
            }
            else{
                contImpar++;
            }
        }
        contImpar = 0;
        contPar = 0;
        for(int i = 0; i < vetor.length; i++)
        {
            if (vetor[i] % 2 == 0)
            {
                vetorPar[contPar] = vetor[i];
                contPar++;
            }
            else{
                vetorImpar[contImpar] = vetor[i];
                contImpar++;
            }
            
        }
        System.out.println("Números que você informou: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println((i+1) + "º " + vetor[i]);
        }

        System.out.println("");
        System.out.println("Vetor de números pares: ");
        for (int i = 0; i < vetorPar.length; i++) {
                System.out.println(vetorPar[i]);
        }

        System.out.println("");
        System.out.println("Vetor de números impares: ");
        for (int i = 0; i < vetorImpar.length; i++) {
                System.out.println(vetorImpar[i]);
        }



        

    }

    // -----------------------------------------------------------------------------------------
    // Método 6
    public void Metodo06() {
        double[][] notas = new double[10][4];
        double[] medias = new double[10];
        double[] nota = new double [4];
        int alunos = 0;
        double media = 0;

        for (int i = 0; i < notas.length; i++)
        {
            System.out.println("Digite as quatro notas do aluno " + (i+1) + ":");
            for (int j = 0; j < 4; j++) {
                notas[i][j] = sc.nextDouble();
                nota[i] += notas[i][j];
            }
            medias[i] = nota[i]/4;
        }

        for (int i = 0; i < medias.length; i++)
        {
            if (medias[i] >= 7) {
                alunos++;
            }  
        }
        System.out.println("Número de alunos com média maior ou igual a 7: " + alunos);
    }

    // -----------------------------------------------------------------------------------------
    // Método 7
    public void Metodo07() {
        int[] vetor = new int[5];
        int[] vetorTotalSoma = new int[5];
        int[] vetorTotalMult = new int[5];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe para o vetor de índice " + (i+1) + ": ");
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i < vetorTotalSoma.length; i++) {
            vetorTotalSoma[i] = vetor[i] + vetor[i];
        }

        for (int i = 0; i < vetorTotalMult.length; i++) {
            vetorTotalMult[i] = vetor[i] * vetor[i];
        }

        System.out.println("Os valores que você informou: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println((i+1) + "º " + vetor[i]);
        }

        System.out.println("");
        System.out.println("A soma dos vetores ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println((i+1) + "º " + vetorTotalSoma[i]);
        }

        System.out.println("");
        System.out.println("A multiplicação dos vetores ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println((i+1) + "º " + vetorTotalSoma[i]);
        }
    }

    // -----------------------------------------------------------------------------------------
    // Método 8
    public void Metodo08() {

    }

    // -----------------------------------------------------------------------------------------
    // Método 9
    public void Metodo09() {
        int[] vetor = new int[10];
        int[] vetorQuad = new int[10];
        int[] vetorTotal = new int[10];
        int j = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe para o vetor de índice " + (i+1) + ": ");
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i < vetor.length; i++)
        {
            vetorQuad[i] = (int) Math.pow(vetor[i], 2);
        }

        for (int i = 0; i < vetor.length; i++)
        {
            vetorTotal[i] = vetorQuad[i] + vetorQuad[i];
        }

        System.out.println("A soma dos quadrados para cada elemento será: ");
        for (int i = 0; i < vetor.length; i++)
        {
            j++;
            System.out.println(j + "º " + vetorTotal[i]);
        }
    }
}

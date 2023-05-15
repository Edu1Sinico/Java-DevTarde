package POOIntroducao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // criar 3 objetos ResgistraAluno
        RegistraAluno rAluno = new RegistraAluno();

        System.out.println("Digite o nome do aluno(a): ");
        String nome = sc.nextLine();
        rAluno.setNome(nome);
        System.out.println("");

        System.out.println("Digite a idade do aluno(a): ");
        int idade = sc.nextInt();
        rAluno.setIdade(idade);
        System.out.println("");

        System.out.println("Digite o endereço do aluno(a): ");
        sc.next();
        String endereco = sc.nextLine();
        rAluno.setEndereco(endereco);
        System.out.println("");

        System.out.println("Digite a nota de matemática do aluno(a): ");
        double notaMat = sc.nextDouble();
        rAluno.setNotaMatematica(notaMat);
        System.out.println("");

        System.out.println("Digite a nota de Língua Portuguesa do aluno(a): ");
        double notaLP = sc.nextDouble();
        rAluno.setNotaPortugues(notaLP);
        System.out.println("");

        System.out.println("Digite a nota de Ciências do aluno(a): ");
        double notaCN = sc.nextDouble();
        rAluno.setNotaCiencias(notaCN);
        System.out.println("");

        System.out.println("==================================");
        System.out.println("");

        System.out.println("Nome: " + rAluno.getNome());
        System.out.println("");
        System.out.println("Idade: " + rAluno.getIdade());
        System.out.println("");
        System.out.println("Endereço: " + rAluno.getEndereco());
        System.out.println("");
        System.out.println("Média do aluno(a):" + rAluno.getMedia());
        System.out.println("");
        System.out.println("Contador: " + RegistraAluno.getQuantidadeAlunos());

        // --------------------------------------------------------------------------

        Alunos aluno1 = new Alunos();
        aluno1.setNome("Alberto");
        System.out.println(aluno1.getNome());
    }
}

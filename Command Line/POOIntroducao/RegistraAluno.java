package POOIntroducao;

public class RegistraAluno extends Pessoas{
    private int idade;
    private double notaMatematica;
    private double notaPortugues;
    private double notaCiencias;
    private static int contadorEstudante;

    // getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public double getMedia() {
        double resultado = 0;
        resultado = (notaMatematica
                + notaPortugues
                + notaCiencias) / 3;

        return resultado;
    }

    public static int getQuantidadeAlunos() {
        return contadorEstudante;
    }


    // Setters
public void setNome(String nome){
    this.nome = nome;
    }

    public void setEndereco(String endereco){
    this.endereco = endereco;
    }

    public void setIdade(int idade){
    this.idade = idade;
    }

    public void setNotaMatematica(double notaMatematica){
    this.notaMatematica = notaMatematica;
    }

    public void setNotaPortugues(double notaPortugues){
    this.notaPortugues = notaPortugues;
    }

    public void setNotaCiencias(double notaCiencias){
    this.notaCiencias = notaCiencias;
    }
}

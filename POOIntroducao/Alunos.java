package POOIntroducao;

/**
 * Alunos
 */
public class Alunos extends Pessoas{
    private int notas;

    public Alunos(int notas) {
        this.notas = notas;
    }

    public String getNotas() {
        return notas;
    }
    
    public void setNotas(String notas) {
        this.notas = notas;
    }
}
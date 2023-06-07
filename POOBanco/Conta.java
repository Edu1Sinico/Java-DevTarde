package POOBanco;

import javax.swing.JOptionPane;

/**
 * Conta
 */
public class Conta extends Pessoa {
    public double saldo;
    public int codigo;
    public String contaPF;
    public String contaPJ;
    public String senha;

    public void criarConta() {
        JOptionPane.showMessageDialog(null,"Criação de Contas (Somente pessoas maiores de 18 podem criar uma conta).");
        

        if (getIdade() < 18) {
            int receber = Integer.parseInt(JOptionPane
                    .showInputDialog("Escolha o tipo de conta (1 - Conta Pessoa Física; 2 - Conta Pessoa Jurídica)"));

            switch (receber) {
                case 1: {
                    JOptionPane.showMessageDialog(null, "Criação de Conta: Pessoa Física");
                    setNome(JOptionPane.showInputDialog("Informe o nome da conta: "));
                    JOptionPane.showMessageDialog(null, "");
                    break;
                }
                case 2: {

                    break;
                }

                default:
                    JOptionPane.showMessageDialog(null, "Selecione um desses valores!");
                    break;
            }
        }
        else
        JOptionPane.showMessageDialog(null,"Somente adultos maiores de 18 anos podem criar conta!");
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getContaPF() {
        return contaPF;
    }

    public void setContaPF(String contaPF) {
        this.contaPF = contaPF;
    }

    public String getContaPJ() {
        return contaPJ;
    }

    public void setContaPJ(String contaPJ) {
        this.contaPJ = contaPJ;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
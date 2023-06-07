package POOBanco;

import javax.swing.JOptionPane;

/**
 * Conta
 */
public class Conta extends Pessoa {
    public double saldo;
    public int codigo = 0;
    public String contaPF;
    public String contaPJ;
    public int senha;

    public void criarConta() {
        JOptionPane.showMessageDialog(null,"Criação de Contas (Somente pessoas maiores de 18 podem criar uma conta).");
        setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade: ")));

        if (getIdade() > 18) {
            int receber = Integer.parseInt(JOptionPane
                    .showInputDialog("Escolha o tipo de conta (1 - Conta Pessoa Física; 2 - Conta Pessoa Jurídica)"));

            switch (receber) {
                case 1: {
                    JOptionPane.showMessageDialog(null, "Criação de Conta: Pessoa Física");
                    setNome(JOptionPane.showInputDialog("Informe o nome da conta: "));
                    setSenha(Integer.parseInt(JOptionPane.showInputDialog("Informe o nome da conta (Apenas 6 digitos): ")));
                    codigo++;
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

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}
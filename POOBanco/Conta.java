package POOBanco;

import javax.swing.JOptionPane;

/**
 * Conta
 */
public class Conta extends Pessoa{

    public double saldo;
    public int codigo;
    public String contaPF;
    public String contaPJ;

    public void conta() {
        JOptionPane.showInputDialog("Escolha o tipo de conta (1 - Conta Pessoa Física; 2 - Conta Pessoa Jurídica)");
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


    
}
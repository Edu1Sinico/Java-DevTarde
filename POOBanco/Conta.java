package POOBanco;

import javax.swing.JOptionPane;

/**
 * Conta
 */
public class Conta extends Pessoa {
    public double saldo;
    public int codigo = 0;
    public String contaTipo;
    public int senha;
    public double saque = 0;
    public double deposito = 0;
    public double emprestimo = 0;

    public void criarConta() {
        JOptionPane.showMessageDialog(null, "Criação de Contas (Somente pessoas maiores de 18 podem criar uma conta).");
        setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade: ")));

        if (getIdade() >= 18) {
            int receber = Integer.parseInt(JOptionPane
                    .showInputDialog("Escolha o tipo de conta (1 - Conta Pessoa Física; 2 - Conta Pessoa Jurídica)"));

            switch (receber) {
                case 1: {
                    JOptionPane.showMessageDialog(null, "Criação de Conta: Pessoa Física");
                    setNome(JOptionPane.showInputDialog("Informe o nome da conta: "));
                    setSenha(Integer
                            .parseInt(JOptionPane.showInputDialog("Informe a senha da conta (Apenas 6 digitos): ")));
                    codigo++;
                    setContaTipo("Conta PF");
                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(null, "Criação de Conta: Pessoa Jurídica");
                    setNome(JOptionPane.showInputDialog("Informe o nome da conta: "));
                    setSenha(Integer
                            .parseInt(JOptionPane.showInputDialog("Informe a senha da conta (Apenas 6 digitos): ")));
                    codigo++;
                    setContaTipo("Conta PJ");
                    break;
                }

                default:
                    JOptionPane.showMessageDialog(null, "Selecione um desses valores!");
                    break;
            }
        } else
            JOptionPane.showMessageDialog(null, "Somente adultos maiores de 18 anos podem criar conta!");
    }

    //Método Incompleto
    public double saque(){ 
        JOptionPane.showMessageDialog(null,"Método de Saques");
        int saquear = Integer.parseInt(JOptionPane.showInputDialog("Selecione a quantidade de valores para saquear (Limite: 3000):"));
        if(saquear > 0 && saquear < 3000)
        {
            saque += saquear;
        }
        else{
            JOptionPane.showMessageDialog(null,"Valor inválido!");
        }
        return saque;
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

    public String getContaTipo() {
        return contaTipo;
    }

    public void setContaTipo(String contaTipo) {
        this.contaTipo = contaTipo;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public double getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(double emprestimo) {
        this.emprestimo = emprestimo;
    }
    
}
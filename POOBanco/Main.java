package POOBanco;

import javax.swing.JOptionPane;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Conta[] Conta = new Conta[2];
        int receber, x, contaAtual = 0;
        do {
            JOptionPane.showMessageDialog(null, "Programa do Banco");
            receber = Integer
                    .parseInt(JOptionPane.showInputDialog("Pressione: \n1 - Criar conta; \n2 - Buscar conta."));
            switch (receber) {
                case 1: {
                    for (int i = 0; i < Conta.length; i++) {
                        Conta[i] = new Conta();
                        Conta[i].criarConta();
                    }
                    break;
                }
                case 2: {
                    int cont = 0;
                    boolean encontrar = true;
                    JOptionPane.showMessageDialog(null, "Buscar Contas");
                    String buscarNome = JOptionPane.showInputDialog("Informe o nome da conta para ser buscado:");
                    int y = Integer.parseInt(JOptionPane.showInputDialog(
                            "O que deseja fazer? \n1 - Ver informações da conta \n2 - Acessar conta"));

                    switch (y) {
                        case 1: {
                            while (encontrar) {
                                if (buscarNome.equals(Conta[cont].getNome())) {
                                    contaAtual = cont;
                                    if (Conta[cont].getContaTipo().equals("Conta PF")) {
                                        JOptionPane.showMessageDialog(null,
                                                "Nome: " + Conta[cont].getNome() + "\nIdade: " + Conta[cont].getIdade()
                                                        + "\nCPF: " + Conta[cont].getCpf()
                                                        + "\nCódigo: " + Conta[cont].getCodigo() + "\nTipo da Conta: "
                                                        + Conta[cont].getContaTipo() + "\nSaldo: "
                                                        + Conta[cont].getSaldo());
                                    } else if (Conta[cont].getContaTipo().equals("Conta PJ")) {
                                        JOptionPane.showMessageDialog(null,
                                                "Nome: " + Conta[cont].getNome() + "\nIdade: " + Conta[cont].getIdade()
                                                        + "\nTipo da conta: " + Conta[cont].getCnpj()
                                                        + "\nCNPJ: " + Conta[cont].getCnpj()
                                                        + "\nCódigo: " + Conta[cont].getCodigo() + "\nTipo de Conta: "
                                                        + Conta[cont].getContaTipo() + "\nSaldo: "
                                                        + Conta[cont].getSaldo());

                                    }
                                    encontrar = false;
                                } else {
                                    cont++;
                                }
                            }
                            break;
                        }
                        case 2: {
                            Conta[contaAtual].entrarConta();
                            break;
                        }
                        default:
                        JOptionPane.showMessageDialog(null,"Selecionado uma das opções.");
                        break;
                    }
                    break;
                }

                default: {
                    JOptionPane.showMessageDialog(null, "Selecione uma dessas opções.");
                    break;
                }
            }
            x = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar? \n0 - Sim; \n1 - Não."));
        } while (x == 0);
    }
}
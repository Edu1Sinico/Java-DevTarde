package POOBanco;

import javax.swing.JOptionPane;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Conta[] Conta = new Conta[2];
        int receber, x, cont = 0;
        do {
            JOptionPane.showMessageDialog(null, "Programa do Banco");
            receber = Integer.parseInt(JOptionPane.showInputDialog("Pressione: 1 - Criar conta; 2 - Buscar conta"));
            switch (receber) {
                case 1: {
                    for (int i = 0; i < Conta.length; i++) {
                        Conta[i] = new Conta();
                        Conta[i].criarConta();
                    }
                    break;
                }
                case 2: {
                    boolean encontrar = true;
                    JOptionPane.showMessageDialog(null, "Buscar Contas");
                    String buscarNome = JOptionPane.showInputDialog("Informe o nome da conta para ser buscado:");
                    while (encontrar) {
                        // Método não funcionando
                        if (buscarNome.equals(Conta[cont].getNome())) {
                            JOptionPane.showMessageDialog(null, "Nome: " + Conta[cont].getNome());
                            JOptionPane.showMessageDialog(null, "Idade: " + Conta[cont].getIdade());
                            JOptionPane.showMessageDialog(null, "Código: " + Conta[cont].getCodigo());
                            JOptionPane.showMessageDialog(null, "Tipo da conta: " + Conta[cont].getContaTipo());
                            JOptionPane.showMessageDialog(null, "Saldo: " + Conta[cont].getSaldo());
                            encontrar = false;
                        }
                        cont++;
                    }
                    break;
                }

                default: {
                    JOptionPane.showMessageDialog(null, "Selecione uma dessas opções.");
                    break;
                }
            }
            x = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar? 0 - Sim; 1 - Não"));
        } while (x == 0);
    }
}
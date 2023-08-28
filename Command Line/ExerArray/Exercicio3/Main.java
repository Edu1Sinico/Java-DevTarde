package ExerArray.Exercicio3;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        //Construir o elevador
        Elevador elevador = new Elevador(10, 5);

        elevador.inicializar();
        boolean ligado = (true);
        int acao = 0;
        while (ligado) {
            acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a Ação (1 - Entrar; 2 - Sair; 3 - Subir; 4 - Descer; 5 - Cancelar):"));
            switch (acao) {
                case 1:{
                    int pessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pessoas para entrar (Capacidade máxima, 5 pessoas): "));
                    elevador.entrar(pessoa);
                    break;
                }
                case 2:{
                    int pessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pessoas para sair:"));
                    elevador.sair(pessoa);
                    break;
                }
                case 3:{
                    int numAndares = Integer.parseInt(JOptionPane.showInputDialog("Digite o andar para subir (Capacidade máxima, 10 andares):"));
                    elevador.subir(numAndares);
                    break;
                }
                case 4:{
                    int numAndares = Integer.parseInt(JOptionPane.showInputDialog("Digite o andar para descer:"));
                    elevador.descer(numAndares);
                    break;
                }
                case 5:{
                    ligado = false;
                    break;
                }
            
                default:{
                    JOptionPane.showMessageDialog(null, "Selecione um dos valores!");
                    break;
                }
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        List<Carros> listaCarros = new ArrayList<>();
        Carros objCarro = new Carros();
        

        String[] options = { "Cadastrar", "Listar", "Consultar", "Excluir", "Sair" };
        String[] option1 = {"Sim","Não"};

        boolean verdade = true;

        while (verdade) {
            int x = JOptionPane.showOptionDialog(null, "Selecione o método que deseje.", "Seleção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (x) {
                case 0: {
                    objCarro.cadastrarCarro();
                    listaCarros.add(objCarro);
                    break;
                }

                case 1: {
                    for (Carros i : listaCarros) {
                        objCarro.exibirCarro();
                    }
                    break;
                }

                case 2: {
                    // String nome = JOptionPane.showInputDialog("Informe o nome do modelo do carro para buscar:").toLowerCase();
                    // for (Carros i: listaCarros) {
                    //     if(i.getModelo().startsWith(nome)){
                    //         objCarro.exibirCarro();
                    //     }
                    // }
                    break;
                }

                case 3: {

                    break;
                }

                default: {
                    verdade = false;
                    break;
                }
            }

            int y = JOptionPane.showOptionDialog(null, "Deseja continuar?", "Seleção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option1, option1[0]);

            switch (y) {
                case 0:{
                    break;
                }

                case 1:{
                    JOptionPane.showMessageDialog(null,"Obrigado por utilizar o meu programa!");
                    verdade = false;
                    break;
                }
            
                default:{
                    verdade = false;
                    break;
                }
            }
        }
    }
}

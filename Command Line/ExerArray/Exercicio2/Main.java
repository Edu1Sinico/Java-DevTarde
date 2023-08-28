package ExerArray.Exercicio2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // criar um vetor de objeto com 10
        Agenda[] contatos = new Agenda[3];

        // Criar os objetos e preencher os valores
        for (int i = 0; i < contatos.length; i++) {
            // construir o objeto
            contatos[i] = new Agenda();

            // Preencher com JOptionPane
            contatos[i].setNome(JOptionPane.showInputDialog("Digite o seu nome: "));
            contatos[i].setIdade(JOptionPane.showInputDialog("Digite a sua idade: "));
            contatos[i].setAltura(JOptionPane.showInputDialog("Digite a sua altura: "));
        }

        // pesquisar a minha lista de contatos
        int cont = 0; // contador~
        String nome = JOptionPane.showInputDialog("Digite o nome a ser buscado: ");
        boolean naoEncotrado = true;
        while (naoEncotrado) {
            if (nome.equals(contatos[cont].getNome())) {
                JOptionPane.showMessageDialog(null, "Idade: " + contatos[cont].getIdade());
                JOptionPane.showMessageDialog(null, "Altura: " + contatos[cont].getAltura());
                naoEncotrado = false;
            }
            cont++;
        }
    }
}
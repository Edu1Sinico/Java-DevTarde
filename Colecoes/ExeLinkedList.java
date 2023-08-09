package Colecoes;

import java.util.LinkedList;

public class ExeLinkedList {
    LinkedList<String> pessoa = new LinkedList<>();


    public void teste() {
        pessoa.add("Pedro");
        pessoa.add("Maria");
        pessoa.add("João");
        pessoa.addFirst("Cecilia");
        System.out.println("\n" + pessoa + "\n");

        pessoa.removeLast();

        System.out.println(pessoa + "\n");
    }
}

package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ExemploArrayList {
    //Criando a arraylist
    ArrayList<String> carros = new ArrayList<>();
    ArrayList<Integer> inteiros = new ArrayList<>();
    Random random = new Random();

    public void test() {
        //Adicionando ao vetor os seus elementos
        carros.add("Fusca");
        carros.add("Brasília");
        carros.add("Chevette");
        carros.add("Monza");
        carros.add("Monza");

        System.out.println("========================\n");

        //Exibindo o vetor na tela
        System.out.println(carros  + "\n");

        System.out.println("========================\n");

        //For de elementos da array
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i) + "\n");
        }

        System.out.println("========================\n");

        //For-each de elementps da array
        for (String i : carros) {
              System.out.println(i);
        }
        System.out.println("");

        System.out.println("========================\n");

        //Ordernar a lista de [a - z]
        Collections.sort(carros);
        System.out.println(carros  + "\n");

        System.out.println("========================\n");

        //Ordernar a lista de [z - a]
        Collections.reverse(carros);
        System.out.println(carros  + "\n");

        System.out.println("========================\n");

        //Excluindo os elementos da array
        carros.clear();
        System.out.println(carros  + "\n");
    }

    public void exercicio1() {
        int x = 0;
        while(inteiros.size() < 5){
            x = random.nextInt(100);
            inteiros.add(x);
        }

        System.out.println("");

        for (Integer i : inteiros) {
              System.out.println(i);
        }

        System.out.println("");
    }

}

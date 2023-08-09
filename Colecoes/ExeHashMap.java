package Colecoes;

import java.util.                     HashMap;

public class ExeHashMap {
    HashMap<String,String> CapitalEstado = new HashMap<>();
    HashMap<String,Integer> NomeIdade = new HashMap<>();
    
    public void teste(){
        CapitalEstado.put("SP","São Paulo");
        CapitalEstado.put("RJ","Rio de Janeiro");
        CapitalEstado.put("MG","Minas Gerais");
        CapitalEstado.put("ES","Espírito Santo");
        System.out.println("\n" + CapitalEstado + "\n");

        for (String i : CapitalEstado.keySet()) {
            System.out.println(i + ": " + CapitalEstado.get(i));
        }
    }

    public void exercicio2() {
        NomeIdade.put("Lorenzo",18);
        NomeIdade.put("Eduardo",17);
        NomeIdade.put("Vinícius",16);
        NomeIdade.put("Ezequiel",16);

        System.out.println("\n" + NomeIdade + "\n");

        for (String i : NomeIdade.keySet()) {
            System.out.println(i + ": " + NomeIdade.get(i));
        }
    }
}

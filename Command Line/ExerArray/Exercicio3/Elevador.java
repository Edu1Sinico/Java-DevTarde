package ExerArray.Exercicio3;

import java.security.DrbgParameters.Capability;

import javax.swing.JOptionPane;

public class Elevador {
    int numMaxAndar;
    int numMaxPessoas;
    int andarAtual;
    int capacidadeAtual;

     //construir los metodos

    //Métodos adicionais
    public void inicializar() {
        capacidadeAtual = 0;
        andarAtual = 0;
    }

    //método entrar
    public void entrar(int pessoas) {
        if((capacidadeAtual + pessoas) >= numMaxPessoas)
        {
            JOptionPane.showMessageDialog(null,"Capacidade máxima atiginda");
            JOptionPane.showMessageDialog(null,"Pessoas para fora: "+ (capacidadeAtual+pessoas-numMaxPessoas));
        }
        else{
            capacidadeAtual+=pessoas;
        }
    }

    //método sair
    public void sair(int pessoas) {
        if(pessoas < capacidadeAtual){ 
            capacidadeAtual-=pessoas;
        }
        else{
            JOptionPane.showMessageDialog(null,"Informe um número válido. Quantidade atual: " + capacidadeAtual);
        }
    }
    
    //Método de subir
    public void subir(int numAndares) {
        if((numAndares+andarAtual) >= numMaxAndar)
        {
            JOptionPane.showMessageDialog(null,"Número ultrapassado de andares.");
            JOptionPane.showMessageDialog(null,"Andar atual: " + andarAtual);
        }
        else{
            andarAtual+=numAndares;
        }
    }

    //método de descer

    public void descer(int numAndares) {
        if(numAndares < andarAtual){ 
            andarAtual-=numAndares;
        }
        else{
            JOptionPane.showMessageDialog(null,"Informe um número válido. Andar atual: " + andarAtual);
        }
    }

    //getters e setters
    public Elevador(int numMaxAndar, int numMaxPessoas) {
        this.numMaxAndar = numMaxAndar;
        this.numMaxPessoas = numMaxPessoas;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public void setCapacidadeAtual(int capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
    }
}

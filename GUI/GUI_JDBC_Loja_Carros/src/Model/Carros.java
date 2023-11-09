package Model;

public class Carros {

    // Atributos
    private String modelo;
    private String marca;
    private String ano;
    private double preco;
    private String placa;
    private Boolean vendido;
    
    // Construtores
    public Carros(String modelo, String marca, String ano, double preco, String placa, Boolean vendido) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
        this.placa = placa;
        this.vendido = vendido;
    }

    public Carros(){}

    // Métodos Getters e Setters
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Boolean getVendido() {
        return vendido;
    }
    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

}

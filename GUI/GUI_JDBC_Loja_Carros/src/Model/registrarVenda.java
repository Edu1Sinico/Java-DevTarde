package Model;

public class RegistrarVenda {
    
    private String marca;
    private String modelo;
    private String preco;
    private String placa;
    private String nome;
    private String dataVendas;

    public RegistrarVenda(String marca, String modelo, String preco, String placa, String nome, String dataVendas) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.placa = placa;
        this.nome = nome;
        this.dataVendas = dataVendas;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataVendas() {
        return dataVendas;
    }

    public void setDataVendas(String dataVendas) {
        this.dataVendas = dataVendas;
    }
    
}

import javax.swing.JOptionPane;

public class Carros {

    // Atributos

    String marca, modelo, ano, cor;

    // Construtor

    public Carros(String marca, String modelo, String ano, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public Carros() {
    }


    
    // Métodos da Classe

    public void cadastrarCarro() {
        JOptionPane.showMessageDialog(null, "Método de Cadastrar Carros.");
        setMarca(JOptionPane.showInputDialog("Informe a marca do carro:").toLowerCase()); 
        setModelo(JOptionPane.showInputDialog("Informe o modelo do carro:").toLowerCase());
        setAno(JOptionPane.showInputDialog("Informe o ano do carro:").toLowerCase());
        setCor(JOptionPane.showInputDialog("Informe a cor do carro:").toLowerCase());
    }

    public void exibirCarro() {
        JOptionPane.showMessageDialog(null, "Método de Listar Carros.");
        JOptionPane.showMessageDialog(null,"A marca do carro é: " + getMarca()
        + "\nO modelo do carro é: "  + getModelo()
        + "\nO ano do carro é: " + getAno()
        + "\nA cor do carro é: " + getCor());
    }

    public void consultarCarro() {
        JOptionPane.showMessageDialog(null, "Método de consultar Carros.");
        JOptionPane.showMessageDialog(null,"A marca do carro é: " + getMarca()
        + "\nO modelo do carro é: "  + getModelo()
        + "\nO ano do carro é: " + getAno()
        + "\nA cor do carro é: " + getCor());
    }

    public void ExcluirCarro() {
        
    }

    // Métodos Getters and Setters

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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    } 
}

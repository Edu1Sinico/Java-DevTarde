package CalculadoraDeDescontos;

/**
 * CalculadoraDescontos
 */
public class CalculadoraDescontos {

  public void Calculadora20()
    {
        System.out.println("=======================================");
        double precoProduto = 115, percentualDesconto = 20; 
        System.out.println("O preço do produto é de " + precoProduto + " reais"); 
        System.out.println("O desconto será de " + percentualDesconto + " %");
        double desconto = precoProduto*percentualDesconto/100;
        double total = precoProduto-desconto;
        System.out.println("o preço do produto com o desconto: R$ " + total);
        System.out.println("=======================================");
    }

    public void Calculadora30()
    {
        System.out.println("=======================================");
        double precoProduto = 115, percentualDesconto = 30; 
        System.out.println("O preço do produto é de " + precoProduto + " reais"); 
        System.out.println("O desconto será de " + percentualDesconto + " %");
        double desconto = precoProduto*percentualDesconto/100;
        double total = precoProduto-desconto;
        System.out.println("o preço do produto com o desconto: R$ " + total);
        System.out.println("=======================================");
    }
}
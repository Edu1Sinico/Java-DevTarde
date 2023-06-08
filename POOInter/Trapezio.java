package POOInter;

public class Trapezio implements FigurasGeometricas{

    int lado1, lado2, baseMaior, baseMenor, altura;
    
    public Trapezio(int lado1, int lado2, int baseMaior, int baseMenor, int altura) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    @Override
    public double area() {
        double area = ((baseMaior+baseMenor)*altura)/2;
        return area;
    }

    @Override
    public String nomeFigura() {
        return "Trapézio";
    }

    @Override
    public double perimetro() {
        double perimetro = lado1+lado2+baseMaior+baseMenor;
        return perimetro;
    }
    
}

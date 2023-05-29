package POOInter;

public class Quad implements FigurasGeometricas{
    private int lado;

    public Quad(int lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        int area = lado*lado;
        return area;
    }

    @Override
    public String nomeFigura() {
        return "Quadrado";
    }

    @Override
    public double perimetro() {
        double perimetro = lado*4;
        return perimetro;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    
}

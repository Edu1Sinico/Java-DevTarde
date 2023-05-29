package POOInter;

import POOIntroducao.Alunos;

public class Retangulo implements FigurasGeometricas{
    int base = 0, altura = 0; 

    public Retangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        double area = base*altura;
        return area;
    }

    @Override
    public String nomeFigura() {
        return "Retângulo";
    }

    @Override
    public double perimetro() {
        double perimetro = (base*2) + (altura*2);
        return perimetro;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}

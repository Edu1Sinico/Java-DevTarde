package POOInter;

public class Main {
    public static void main(String[] args) {
        Quad figura1 = new Quad(7);
        Retangulo figura2 = new Retangulo(10, 5);
        Trapezio figura3 = new Trapezio(5, 5, 15, 10, 7);
        
        Trapezio figTrapezio[] = new Trapezio[5];
        figTrapezio[0] = new Trapezio(5, 5, 15, 10, 7);

        for (int i = 0; i < figTrapezio.length; i++) {
            figTrapezio[i] = new Trapezio(i+5, i, i+1, i+2, i+3);
        }

        System.out.println("\nNome da figura: " + figura1.nomeFigura() + " \nÁrea da figura: " + figura1.area() + " \nPerimetro da figura: " + figura1.perimetro());
        System.out.println("\nNome da figura: " + figura2.nomeFigura() + " \nÁrea da figura: " + figura2.area() + " \nPerimetro da figura: " + figura2.perimetro());
        System.out.println("\nNome da figura: " + figura3.nomeFigura() + " \nÁrea da figura: " + figura3.area() + " \nPerimetro da figura: " + figura3.perimetro());

    }
}

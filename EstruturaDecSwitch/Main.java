package EstruturaDecSwitch;

import java.util.Scanner;

import ExercicioIFElseJava.main;

public class Main {
    public static void main(String[] args) {
        SwitchCase obj = new SwitchCase();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 1 para o primeiro método ou 2 para o segundo método: ");
        int x = sc.nextInt();

        switch(x)
        {
            case 1:
            {
                obj.letra();
                break;
            }
            case 2:
            {
                obj.mes();
                break;
            }
            default:
            System.out.println("Digite um desses números citados acima.");
        }
    }
}

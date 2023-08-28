package EstruturaDecSwitch;

import java.util.Scanner;

public class SwitchCase {
    Scanner sc = new Scanner(System.in);

    public void letra() {
        System.out.println("Digite uma letra: ");
        String letra = sc.nextLine();
        switch(letra)
        {
            case "a":
            {
                System.out.println("Essa letra é uma vogal.");
                break;
            }
            case "e":
            {
                System.out.println("Essa letra é uma vogal.");
                break;
            }
            case "i":
            {
                System.out.println("Essa letra é uma vogal.");
                break;
            }
            case "o":
            {
                System.out.println("Essa letra é uma vogal.");
                break;
            }
            case "u":
            {
                System.out.println("Essa letra é uma vogal.");
                break;
            }
            default: System.out.println("Essa letra é consoante.");
            break;
        }
    }

    public void mes(){
        System.out.println("Digite um número entre 1 e 12");
        int mes = sc.nextInt();
        switch(mes)
        {
            case 1:
            {
                System.out.println("Janeiro");
                break;
            }
            case 2:
            {
                System.out.println("Fevereiro");
                break;
            }
            case 3:
            {
                System.out.println("Março");
                break;
            }
            case 4:
            {
                System.out.println("Abril");
                break;
            }
            case 5:
            {
                System.out.println("Maio");
                break;
            }
            case 6:
            {
                System.out.println("Junho");
                break;
            }
            case 7:
            {
                System.out.println("Julho");
                break;
            }
            case 8:
            {
                System.out.println("Agosto");
                break;
            }
            case 9:
            {
                System.out.println("Setembro");
                break;
            }
            case 10:
            {
                System.out.println("Outubro");
                break;
            }
            case 11: 
            {
                System.out.println("Novembro");
                break;
            }
            case 12: 
            {
                System.out.println("Dezembro");
                break;
            }
            default: System.out.println("Escolha um número entre 1 e 12.");
            break;
        }
    }

}

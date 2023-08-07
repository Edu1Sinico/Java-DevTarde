package AulaTryCatch;

import javax.swing.JOptionPane;

public class ExemploTryCatch {
    public static void main(String[] args) {
        int escolha = 0, x = 0, n1 = 0, n2 = 0; ;
        boolean verdadeiro = true;

        do {
            // JOptionPane.showMessageDialog(null,"O valor é :"+ a );

            escolha = Integer.parseInt(JOptionPane.showInputDialog("Calculadora de Operações\n\n"
                    + "1 - Adição;\n"
                    + "2 - Subtração;\n"
                    + "3 - Multiplicação;\n"
                    + "4 - Divisão;\n\n"));

            switch (escolha) {
                case 1: {
                    while (verdadeiro) {
                        try {
                            JOptionPane.showMessageDialog(null, "Operação de Adição.");
                            n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
                            n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o Segundo número:"));
                            JOptionPane.showMessageDialog(null,
                                    "A soma do número " + n1 + " com o número " + n2 + " é igual a:\n " + (n1 + n2));
                            verdadeiro = false;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro - Só é aceito números inteiros!");
                        }
                    }
                    verdadeiro = true;
                    break;
                }
                case 2: {
                    while (verdadeiro) {
                        try {
                            JOptionPane.showMessageDialog(null, "Operação de Subtração.");
                            n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
                            n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o Segundo número:"));
                            JOptionPane.showMessageDialog(null,
                                    "A subtração do número " + n1 + " com o número " + n2 + " é igual a:\n " + (n1 - n2));
                            verdadeiro = false;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro - Só é aceito números inteiros!");
                        }
                    }
                    verdadeiro = true;
                    break;
                }
                case 3: {
                    while (verdadeiro) {
                        try {
                            JOptionPane.showMessageDialog(null, "Operação de Multiplicação.");
                            n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
                            n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o Segundo número:"));
                            JOptionPane.showMessageDialog(null,
                                    "A multiplicação do número " + n1 + " com o número " + n2 + " é igual a:\n " + (n1 * n2));
                            verdadeiro = false;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro - Só é aceito números inteiros!");
                        }
                    }
                    verdadeiro = true;
                    break;
                }
                case 4: {
                    while (verdadeiro) {
                        try {
                            JOptionPane.showMessageDialog(null, "Operação de Divisão.");
                            n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
                            n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o Segundo número:"));
                            JOptionPane.showMessageDialog(null,
                                    "A divisão do número " + n1 + " com o número " + n2 + " é igual a:\n " + (n1 / n2));
                            verdadeiro = false;
                        } catch (ArithmeticException e) {
                            JOptionPane.showMessageDialog(null, "Erro - Não existe divisão por zero!");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro!");
                        }
                    }
                    verdadeiro = true;
                    break;
                }

                default: {
                    JOptionPane.showMessageDialog(null, "Escolha uma dessas opções!");
                    break;
                }
            }
            while (verdadeiro) {
                try {
                    x = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar?\n\n"
                            + "0 - Sim;\n"
                            + "Qualquer Número - Não.\n\n"));
                            verdadeiro = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro - Só é aceito números inteiros!");
                }
            }
            verdadeiro = true;

        } while (x == 0);

    }
}

package CalculoGastoViagem;

public class CalculoGastoViagem {
    public static void main(String[] args) {
        int distanciaLocal = 150, gastaPorKM = 10;
        float precoGasolina = 6, gastoDeGasolina = 0, gastoTotal = 0;

        System.out.println("===== Calculo de Gastos da Viagem =====");
        gastoDeGasolina = gastaPorKM/precoGasolina;
        gastoTotal = distanciaLocal*gastoDeGasolina;

        System.out.println("O gasto total da viagem será: " + gastoTotal + " R$.");
    }
}

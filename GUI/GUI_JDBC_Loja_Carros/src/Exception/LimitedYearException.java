package Exception;

import java.util.Calendar;

public class LimitedYearException extends Exception {

    private int anoDigitado;
    private int anoInicio = 1900;
    Calendar data = Calendar.getInstance();
    int anoAtual = data.get(Calendar.YEAR) + 1;

    public void LimitedYearException(int anoDigitado){
        if (!(anoDigitado > anoInicio && anoDigitado < anoAtual)){
            
        }
    }
}

package modelo.excepciones;

/**
 * Created by nico on 28/11/17.
 */
public class ExceptionArrojoDoblesTresVeces extends Throwable {

    public String mensaje(){
        return "Los Dados arrojaron tres veces Dobles. ";
    }
}

package modelo.excepciones;

/**
 * Created by nico on 12/11/17.
 */
public class ImposiblePagarFianzaPrimerTurnoExeption extends Throwable{
    public String mensaje(){
        return "Un jugador no puede pagar su fianza en la primera ronda preso, debe cumplir una al menos una vuelta.";
    }
}

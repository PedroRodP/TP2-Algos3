package modelo.excepciones;

/**
 * Created by nico on 23/11/17.
 */
public class ExcepcionNoSePuedeConstruirHotelAun extends Throwable {
    public String mensaje(){
        return "Debe tener completos las edificaciones para construir un Hotel";
    }
}

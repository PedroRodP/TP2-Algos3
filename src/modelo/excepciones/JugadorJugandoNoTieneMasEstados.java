package modelo.excepciones;

/**
 * Created by nico on 12/11/17.
 */
public class JugadorJugandoNoTieneMasEstados extends Throwable {
    public String mensaje(){
        return "Este jugador no está preso, no debe estar detenido.";
    }
}

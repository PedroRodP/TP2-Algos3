package modelo.excepciones;

/**
 * Created by nico on 12/11/17.
 */
@SuppressWarnings("serial")
public class ExcepcionJugadorYaEstaJugando extends Exception {
	
    public String mensaje(){
        return "El jugador esta jugando, no tiene siguiente Estado.";
    }
}

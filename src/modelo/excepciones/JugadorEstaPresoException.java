package modelo.excepciones;

/**
 * Created by nico on 11/11/17.
 */
public class JugadorEstaPresoException extends Exception {

    public String message(){
        return "Jugador está preso. Imposible realizar acciones. ";
    }
}

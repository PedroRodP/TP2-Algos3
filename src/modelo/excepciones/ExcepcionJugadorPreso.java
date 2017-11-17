package modelo.excepciones;

/**
 * Created by nico on 11/11/17.
 */
@SuppressWarnings("serial")
public class ExcepcionJugadorPreso extends Exception {

    public String mensaje(){
        return "Jugador esta preso. Imposible realizar acciones. ";
    }
}

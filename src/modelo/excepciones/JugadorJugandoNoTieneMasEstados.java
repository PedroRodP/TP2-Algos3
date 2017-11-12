package modelo.excepciones;

/**
 * Created by nico on 12/11/17.
 */
public class JugadorJugandoNoTieneMasEstados extends Exception {
    public String mensaje(){
        return "El judor está jugando, no tiene siguiente Estado.";
    }
}

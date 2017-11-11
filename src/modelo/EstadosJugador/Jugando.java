package modelo.EstadosJugador;

import modelo.excepciones.JugadorEstaPresoException;

/**
 * Created by nico on 11/11/17.
 */
public class Jugando implements EstadoJugador {
    @Override
    public void avanzar(int cantidadDePasos) throws JugadorEstaPresoException {
        for (int i = 0;i<cantidadDePasos; i++){
            iteradorDelTablero.next();
        }
    }
}

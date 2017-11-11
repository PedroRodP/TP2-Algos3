package modelo.EstadosJugador;

import modelo.excepciones.JugadorEstaPresoException;

/**
 * Created by nico on 11/11/17.
 */
public class Preso implements EstadoJugador {
    @Override
    public void avanzar(int cantidadDePasos) throws JugadorEstaPresoException {
        throw new JugadorEstaPresoException();
    }
}

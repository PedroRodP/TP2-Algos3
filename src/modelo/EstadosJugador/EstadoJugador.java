package modelo.EstadosJugador;

import modelo.excepciones.JugadorEstaPresoException;

/**
 * Created by nico on 11/11/17.
 */
public interface EstadoJugador {

    void avanzar(int cantidadDePasos) throws JugadorEstaPresoException;
}

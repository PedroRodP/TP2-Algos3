package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.JugadorJugandoNoTieneMasEstados;

/**
 * Created by nico on 11/11/17.
 */
public interface EstadoJugador {

    public int avanzar(int cantidadDePasos) throws JugadorEstaPresoException;

    EstadoJugador siguienteEstado() throws JugadorJugandoNoTieneMasEstados;
}

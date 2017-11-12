package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.JugadorJugandoNoTieneMasEstados;

/**
 * Created by nico on 11/11/17.
 */
public class Jugando implements EstadoJugador {

    public Jugando(){}

    @Override
    public void avanzar(int cantidadDePasos, Jugador esteJugador, Tablero miTablero) throws JugadorEstaPresoException {
        miTablero.avanzar(esteJugador, cantidadDePasos);
    }

    @Override
    public EstadoJugador siguienteEstado() throws JugadorJugandoNoTieneMasEstados {
        throw new JugadorJugandoNoTieneMasEstados();
    }
}

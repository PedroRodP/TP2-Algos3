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
    public int avanzar(int cantidadDePasos) throws JugadorEstaPresoException {
        return cantidadDePasos;
    }

    @Override
    public EstadoJugador siguienteEstado() throws JugadorJugandoNoTieneMasEstados {
        throw new JugadorJugandoNoTieneMasEstados();
    }
}

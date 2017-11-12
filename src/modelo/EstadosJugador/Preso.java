package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.JugadorJugandoNoTieneMasEstados;

/**
 * Created by nico on 11/11/17.
 */
public class Preso implements EstadoJugador {

    public Preso(){}

    @Override
    public void avanzar(int cantidadDePasos, Jugador esteJugador, Tablero miTablero) throws JugadorEstaPresoException {
        throw new JugadorEstaPresoException();
    }

    @Override
    public EstadoJugador siguienteEstado() throws JugadorJugandoNoTieneMasEstados {
        return new PresoBajoFianza1();
    }
}

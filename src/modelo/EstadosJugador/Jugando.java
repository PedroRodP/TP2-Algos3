package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.excepciones.ImposiblePagarFianzaPrimerTurnoExeption;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.JugadorJugandoNoTieneMasEstados;
import modelo.excepciones.JugadorNoEstaPreso;

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

    @Override
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ImposiblePagarFianzaPrimerTurnoExeption, JugadorNoEstaPreso {
        throw new JugadorNoEstaPreso();
    }

}

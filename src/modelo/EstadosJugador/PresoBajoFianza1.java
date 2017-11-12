package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.excepciones.*;

/**
 * Created by nico on 12/11/17.
 */
public class PresoBajoFianza1 implements EstadoJugador {

    public PresoBajoFianza1(){}

    @Override
    public void avanzar(int cantidadDePasos, Jugador esteJugador, Tablero miTablero) throws JugadorEstaPresoException {
        throw new JugadorEstaPresoException();
    }

    @Override
    public EstadoJugador siguienteEstado() throws JugadorJugandoNoTieneMasEstados {
        return new PresoBajoFianza2();
    }

    @Override
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ImposiblePagarFianzaPrimerTurnoExeption, JugadorNoEstaPreso, ExcepcionCapitalInsuficiente {
        laCarcel.cobrarFianza(esteJugador);
    }
}

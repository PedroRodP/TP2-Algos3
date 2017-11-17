package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.casilleros.Carcel;
import modelo.excepciones.ExcepcionPagarFianzaNoCorresponde;
import modelo.excepciones.ExcepcionJugadorPreso;

/**
 * Created by nico on 11/11/17.
 */
public class Preso implements EstadoJugador {

    @Override
    public int avanzar(int cantidadDePasos) throws ExcepcionJugadorPreso {
        throw new ExcepcionJugadorPreso();
    }

    @Override
    public EstadoJugador siguienteEstado() {
        return new PresoBajoFianza1();
    }

    @Override
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ExcepcionPagarFianzaNoCorresponde {
        throw new ExcepcionPagarFianzaNoCorresponde();
    }

}

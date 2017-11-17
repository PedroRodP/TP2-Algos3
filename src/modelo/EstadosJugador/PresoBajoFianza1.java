package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.casilleros.Carcel;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

/**
 * Created by nico on 12/11/17.
 */
public class PresoBajoFianza1 implements EstadoJugador {

    @Override
    public int avanzar(int cantidadDePasos) throws ExcepcionJugadorPreso {
        throw new ExcepcionJugadorPreso();
    }

    @Override
    public EstadoJugador siguienteEstado() {
        return new PresoBajoFianza2();
    }

    @Override
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ExcepcionCapitalInsuficiente {
        laCarcel.cobrarFianza(esteJugador);
    }
}

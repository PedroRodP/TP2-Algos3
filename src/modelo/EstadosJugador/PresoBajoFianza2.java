package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

/**
 * Created by nico on 12/11/17.
 */
public class PresoBajoFianza2 implements EstadoJugador {

    @Override
    public Casillero avanzar(Casillero casillero) throws ExcepcionJugadorPreso {
        throw new ExcepcionJugadorPreso();
    }

    @Override
    public EstadoJugador siguienteEstado() {
        return new Jugando();
    }

    @Override
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ExcepcionCapitalInsuficiente {
        laCarcel.cobrarFianza(esteJugador);
        esteJugador.recobrarLibertad();
    }
}

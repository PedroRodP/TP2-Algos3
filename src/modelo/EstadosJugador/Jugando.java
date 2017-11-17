package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.casilleros.Carcel;
import modelo.excepciones.ExcepcionPagarFianzaNoCorresponde;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionJugadorYaEstaJugando;

/**
 * Created by nico on 11/11/17.
 */
public class Jugando implements EstadoJugador {
	
    @Override
    public int avanzar(int cantidadDePasos) throws ExcepcionJugadorPreso {
        return cantidadDePasos;
    }

    @Override
    public EstadoJugador siguienteEstado() throws ExcepcionJugadorYaEstaJugando {
    	throw new ExcepcionJugadorYaEstaJugando();
    }

    @Override
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ExcepcionPagarFianzaNoCorresponde {
        throw new ExcepcionPagarFianzaNoCorresponde();
    }

}

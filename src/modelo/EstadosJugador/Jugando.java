package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.casilleros.Carcel;
import modelo.excepciones.ExcepcionPagarFianzaNoCorresponde;
import modelo.excepciones.ExcepcionJugadorPreso;

/**
 * Created by nico on 11/11/17.
 */
public class Jugando implements EstadoJugador {

	@Override
	public boolean esLibre() {
		return true;
	}
	
    @Override
    public int avanzar(int cantidadDePasos) throws ExcepcionJugadorPreso {
        return cantidadDePasos;
    }

    @Override
    public EstadoJugador siguienteEstado() {
    	return new Jugando();
    }

    @Override
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ExcepcionPagarFianzaNoCorresponde {
        throw new ExcepcionPagarFianzaNoCorresponde();
    }

}

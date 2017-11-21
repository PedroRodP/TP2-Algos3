package modelo.casilleros;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Impuesto implements Casillero {

	@Override
	public void caer(Jugador jugador, int velorDeLosDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		jugador.pagar(0.1 * jugador.getCapital());
	}

}

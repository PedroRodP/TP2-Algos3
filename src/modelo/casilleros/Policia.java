package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Policia implements Casillero {

	@Override
	public void caer(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		
		unTablero.avanzar(unJugador, 10);
		
	}

}

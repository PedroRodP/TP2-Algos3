package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

public class Policia implements Casillero {

	@Override
	public void caer(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		
		unTablero.avanzar(unJugador, 10);
		
	}

}

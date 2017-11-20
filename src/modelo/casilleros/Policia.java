package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Policia implements Casillero {

	Tablero tablero;
	
	public Policia(Tablero referencia) {
		
		tablero = referencia;
	}
	
	public void enviarACarcel(Jugador jugador) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		
		tablero.enviarALaCarcel(jugador);
	}
	
	@Override
	public void caer(Jugador jugador, int velorDeLosDados) throws ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso {
		
		this.enviarACarcel(jugador);
	}

}

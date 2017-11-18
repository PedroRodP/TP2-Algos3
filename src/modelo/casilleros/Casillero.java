package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorNoRegistrado;
import modelo.excepciones.ExcepcionJugadorPreso;

public interface Casillero {

	public void caer(Jugador unJugador, Tablero unTablero, int valorDeLosDados) throws ExcepcionJugadorPreso,ExcepcionCapitalInsuficiente, ExcepcionJugadorNoRegistrado;
	
}

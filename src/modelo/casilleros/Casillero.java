package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

public interface Casillero {

	public void hazLoTuyo(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException,ExcepcionCapitalInsuficiente;

}

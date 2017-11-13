package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.JugadorEstaPresoException;

public class Neuquen extends Barrio implements Casillero {


	public Neuquen(){
		
		precioTerreno = 17000;
		
	}

	@Override
	public void hazLoTuyo(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException {
		// TODO Auto-generated method stub
		
	}

}

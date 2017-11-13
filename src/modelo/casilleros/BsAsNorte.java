package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.JugadorEstaPresoException;

public class BsAsNorte extends Barrio implements Casillero {

	public BsAsNorte(){
		
		precioTerreno = 25000;
	
	}

	@Override
	public void hazLoTuyo(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException {
		// TODO Auto-generated method stub
		
	}

}

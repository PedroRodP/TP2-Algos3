package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.JugadorEstaPresoException;

public class CordobaNorte extends Barrio implements Casillero {


	
	public CordobaNorte(){
		
		precioTerreno = 20000;
		
	}

	@Override
	public void hazLoTuyo(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException {
		// TODO Auto-generated method stub
		
	}

}

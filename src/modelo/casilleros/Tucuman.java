package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

public class Tucuman extends Barrio implements Casillero {


	public Tucuman(){
		
		precioTerreno = 25000;
		
	}

	@Override
	public void hazLoTuyo(Jugador unJugador, Tablero unTablero, int velorDeLosDados)
			throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		// TODO Auto-generated method stub
		
	}

}

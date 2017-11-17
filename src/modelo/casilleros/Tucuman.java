package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Tucuman extends Barrio {


	public Tucuman(){
		
		precioTerreno = 25000;
		
	}

	@Override
	public void caer(Jugador unJugador, Tablero unTablero, int velorDeLosDados)
			throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		// TODO Auto-generated method stub
		
	}

}

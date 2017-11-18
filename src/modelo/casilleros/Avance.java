package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorNoRegistrado;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Avance implements Casillero {

	private void avanzarDinamicamente(Jugador jugador, Tablero tablero, int valorDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionJugadorNoRegistrado {
		
		if (valorDados <= 6) {
			
			tablero.avanzar(jugador, valorDados-2);
		
		} else if (valorDados > 6 && valorDados <= 10) {
			
			tablero.avanzar(jugador, (int) (jugador.getCapital() % valorDados));
			
		} else {
			
			tablero.avanzar(jugador, Math.abs(valorDados - jugador.cantidadDeInmuebles()));
			
		}	
	}

	@Override
	public void caer(Jugador jugador, Tablero tablero, int valorDados)
			throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionJugadorNoRegistrado {
		
		this.avanzarDinamicamente(jugador, tablero, valorDados);
	}

	
}

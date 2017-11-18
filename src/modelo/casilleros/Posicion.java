package modelo.casilleros;

import java.util.HashMap;

import modelo.Jugador;

public class Posicion {
	
	private HashMap<Jugador, Casillero> posiciones = new HashMap<>();
	
	public Casillero getPosicion(Jugador jugador) {
		return posiciones.get(jugador);
	}

	public void setPosicion(Jugador jugador, Casillero casillero) {
		
		if (posiciones.containsKey(jugador)) {
			posiciones.replace(jugador, casillero);
		}
		else {
			posiciones.put(jugador, casillero);
		}
	}

	public boolean estaRegistrado(Jugador jugador) {

		return posiciones.containsKey(jugador);
	}
}

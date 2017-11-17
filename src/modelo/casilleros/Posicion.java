package modelo.casilleros;

import java.util.HashMap;

import modelo.Jugador;

public class Posicion {
	
	private HashMap<Jugador, Casillero> posiciones = new HashMap<>();
	
	public Casillero getCasillero(Jugador jugador) {
		return posiciones.get(jugador);
	}

	public void setCasillero(Jugador jugador, Casillero casillero) {
		
		if (posiciones.containsKey(jugador)) {
			posiciones.replace(jugador, casillero);
		}
		else {
			posiciones.put(jugador, casillero);
		}
	}
}

package modelo;

import java.util.ArrayList;

public class GrupoJugadores {

		Jugador jugadorRojo = new Jugador();
		Jugador jugadorAmarillo = new Jugador();
		Jugador jugadorAzul = new Jugador();
	
		
	ArrayList<Jugador> getJugadores() {
		
		ArrayList<Jugador> lista = new ArrayList<>();
		
		lista.add(jugadorRojo);
		lista.add(jugadorAmarillo);
		lista.add(jugadorAzul);
		
		return lista;
	}
	
}

package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Turnador {

	private ArrayList<Jugador> jugadores;
	private Iterator<Jugador> turno;
	
	public Turnador(ArrayList<Jugador> listaJugadores) {
		this.agregarJugadores(listaJugadores);
		this.generarOrdenAleatorio();
		this.setIteradorEnInicio();
	}
	
	private void agregarJugadores(ArrayList<Jugador> listaJugadores) {
		jugadores = listaJugadores;
	}
		
	private void generarOrdenAleatorio() {
		Collections.shuffle(jugadores);
	}
	
	private void setIteradorEnInicio() {
		turno = jugadores.listIterator();
	}
	
	public Jugador siguienteTurno() {
		
		if (!turno.hasNext()) {
			this.setIteradorEnInicio();
		}
		return turno.next();
	}
}

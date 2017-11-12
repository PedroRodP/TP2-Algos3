package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import modelo.casilleros.Casillero;
import modelo.excepciones.JugadorEstaPresoException;

public class AlgoPoly {

	private Tablero tablero = new Tablero();
	private Tirada tirada = new Tirada();
	private Jugador jugadorRojo;
	private Jugador jugadorAmarillo;
	private Jugador jugadorAzul;
	private ArrayList<Jugador> turnos;
	private Iterator<Jugador> turno;
	
	public AlgoPoly() {
		
		jugadorRojo = new Jugador();
		jugadorAmarillo = new Jugador();
		jugadorAzul = new Jugador();
		
		tablero.setJugador(jugadorRojo);
		tablero.setJugador(jugadorAmarillo);
		tablero.setJugador(jugadorAzul);
		
		this.generarOrdenAleatorio();
	}
	
	private void generarOrdenAleatorio() {
		
		turnos.add(jugadorAzul);
		turnos.add(jugadorAmarillo);
		turnos.add(jugadorRojo);
		
		Collections.shuffle(turnos);
		
		turno = turnos.listIterator();
	}
	
	private Jugador turnoActual() {

		if (!turno.hasNext()) {
			//Reiniciar iterador
			turno = turnos.listIterator();
		}
		return turno.next();
	}
	
	private void opcionDeEdificar(Jugador jugador) {
		
	}
	
	private void opcionCompraOAlquiler(Casillero casillero, Jugador jugador) {
		
	}
	
	public void jugar() {
		
		Jugador jugador = this.turnoActual();
		
		if (jugador.tieneInmuebles()) {
			this.opcionDeEdificar(jugador);
		}
		
		try {
			int cantidadDePasos = tirada.arrojarDados();
			Casillero casilleroActual = tablero.avanzar(jugador, cantidadDePasos);
			
			this.opcionCompraOAlquiler(casilleroActual, jugador);
		}
		catch (JugadorEstaPresoException e){
		}
		
		
		//El iterador cambia los turnos al devolver el siguiente
	}
	
}

package modelo;

import java.util.ArrayList;

import modelo.casilleros.Casillero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

public class AlgoPoly {

	private Tablero tablero = new Tablero();
	private Tirada tirada = new Tirada();
	private Turnador turnador;
	
	private Jugador jugadorRojo;
	private Jugador jugadorAmarillo;
	private Jugador jugadorAzul;
	
	
	public AlgoPoly() {
		
		jugadorRojo = new Jugador();
		jugadorAmarillo = new Jugador();
		jugadorAzul = new Jugador();
		
		tablero.agregarJugadores(this.listaDeJugadores());
		turnador = new Turnador(this.listaDeJugadores());
	}

	private ArrayList<Jugador> listaDeJugadores() {
		
		ArrayList<Jugador> lista = new ArrayList<>();
		
		lista.add(jugadorRojo);
		lista.add(jugadorAmarillo);
		lista.add(jugadorAzul);
		
		return lista;
	}

	private void opcionPagarFianza(Jugador jugador) throws ExcepcionCapitalInsuficiente{
		//jugador.pagarFianza();
	}
	
	private void opcionDeEdificar(Jugador jugador) {
		
	}
	
	private void opcionCompraOAlquiler(Casillero casillero, Jugador jugador) {
		
	}

	public void jugar() throws ExcepcionCapitalInsuficiente, JugadorEstaPresoException {
		
		Jugador jugador = turnador.siguienteTurno();
		
		this.opcionPagarFianza(jugador);
		
		//Bloque pre-movida
		this.opcionDeEdificar(jugador);
		
		//Bloque movida
		int cantidadDePasos = tirada.arrojarDados();
		Casillero casilleroActual = tablero.avanzar(jugador, cantidadDePasos);
		
		//Bloque casillero
		this.opcionCompraOAlquiler(casilleroActual, jugador);
	}		
		
}

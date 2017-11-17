package modelo;

import java.util.ArrayList;

import modelo.casilleros.Casillero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

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

	private void opcionPagarFianza(Jugador jugador) {
		//jugador.pagarFianza();
	}
	
	private void opcionEdificar(Jugador jugador) {
		
	}
	
	private void opcionMoverse(Jugador jugador) {
		
		try {
			int numeroDados = tirada.arrojarDados();
			Casillero casilleroAvanzado = tablero.avanzar(jugador, numeroDados);
			
			casilleroAvanzado.caer(jugador, tablero, numeroDados);
		
		} catch (ExcepcionJugadorPreso e) {
			// TODO Auto-generated catch block
		
		} catch (ExcepcionCapitalInsuficiente e) {
			// TODO Auto-generated catch block
		}
	}

	public void jugar() {
		
		//Cambio de turno
		Jugador jugador = turnador.siguienteTurno();
		
		//Bloque comienzo de turno
		this.opcionPagarFianza(jugador);
		
		//Bloque pre-movida
		this.opcionEdificar(jugador);
		
		//Bloque jugada
		this.opcionMoverse(jugador);
	}		
		
}

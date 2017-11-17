package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class AlgoPoly {

	private Tablero tablero = new Tablero();
	private Tirada tirada = new Tirada();
	private Turnador turnador;
	
	private Jugador jugadorRojo = new Jugador();
	private Jugador jugadorAmarillo = new Jugador();
	private Jugador jugadorAzul = new Jugador();
	
	
	public AlgoPoly() {
		
		turnador = new Turnador(this.listaDeJugadores());
		tablero.agregarJugadores(this.listaDeJugadores());
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
			tablero.avanzar(jugador, numeroDados);
					
		} catch (ExcepcionJugadorPreso e) {
			// TODO Auto-generated catch block
		
		} catch (ExcepcionCapitalInsuficiente e) {
			// TODO Auto-generated catch block
		}
	}

}

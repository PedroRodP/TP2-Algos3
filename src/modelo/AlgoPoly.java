package modelo;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorNoRegistrado;
import modelo.excepciones.ExcepcionJugadorPreso;

public class AlgoPoly {

	private GrupoJugadores grupo = new GrupoJugadores();
	private Tablero tablero = new Tablero();
	private Tirada tirada = new Tirada();
	private Turnador turnador;
	
	
	public AlgoPoly() {
		
		turnador = new Turnador(grupo.getJugadores());
		tablero.agregarJugadores(grupo.getJugadores());
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
			
		
		} catch (ExcepcionCapitalInsuficiente e) {
			
			
		} catch (ExcepcionJugadorNoRegistrado e) {
			
			
		}
	}

}

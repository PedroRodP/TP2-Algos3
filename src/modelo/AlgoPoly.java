package modelo;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionPagarFianzaNoCorresponde;

public class AlgoPoly {

	private GrupoJugadores grupo = new GrupoJugadores();
	private Tablero tablero = new Tablero();
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
		try {
			jugador.pagarFianza();
			
		} catch (ExcepcionPagarFianzaNoCorresponde e) {
			
			
		} catch (ExcepcionCapitalInsuficiente e) {
			
			
		}
	}
	
	private void opcionEdificar(Jugador jugador) {
		
	}
	
	private void opcionMoverse(Jugador jugador) {
		
		Tirada tirada = new Tirada();
		
		try {
			//Entra aunque sea una vez al ciclo. Continua si salen dobles. Corta si salen 3 veces.
			while (tirada.salenDobles() && !tirada.salieron3Dobles()) {
				
				int numeroDados = tirada.arrojarDados();
				tablero.avanzar(jugador, numeroDados);
				
			}
			
			if (tirada.salieron3Dobles()) { tablero.enviarALaCarcel(jugador); }
			
		} catch (ExcepcionJugadorPreso e) {
			//El jugador no debe poder moverse
		
		} catch (ExcepcionCapitalInsuficiente e) {
			
			
		}
	}

}

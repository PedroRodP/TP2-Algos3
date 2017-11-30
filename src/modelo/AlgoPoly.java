package modelo;

import modelo.excepciones.*;

public class AlgoPoly {

	private GrupoJugadores grupo = new GrupoJugadores();
	private Tablero tablero = new Tablero();
	private Turnador turnador;
	private Jugador jugadorActual;
	private Tirada tirada = new Tirada();
	
	
	public AlgoPoly() {
		
		turnador = new Turnador(grupo.getJugadores());
		tablero.agregarJugadores(grupo.getJugadores());
	}

	public void proximoTurno() {
		
		this.jugadorActual = turnador.siguienteTurno();
	}	
	
	/* JUEGO
	 * 
	  	//Bloque comienzo de turno
		this.opcionPagarFianza();
		
		//Bloque pre-movida
		this.opcionVenderPropiedades();
		this.opcionEdificar();
		
		//Bloque jugada
		this.opcionMoverse();
	 * 
	 */

	public void opcionPagarFianza() {
		try {
			jugadorActual.pagarFianza();
			
		} catch (ExcepcionPagarFianzaNoCorresponde e) {
			
			
		} catch (ExcepcionCapitalInsuficiente e) {
			
			
		}
	}
	
	public void opcionVenderPropiedades() {
		
	}
	
	public void opcionEdificar() {
		
	}
	
	public int arrojarDados() {
		
		int valorDados;
		
		try { 
			valorDados = tirada.arrojarDados();
			
		} catch (ExcepcionArrojoDoblesTresVeces e) {
			
			this.tablero.enviarALaCarcel(jugadorActual);
			this.proximoTurno();
			
			valorDados = this.arrojarDados();
		}
		
		return valorDados;
	}
	
	public void opcionMoverse(int valorDados) {
		
		try {
			tablero.avanzar(jugadorActual, valorDados);
	
		} catch (ExcepcionJugadorPreso e) {
		
		} catch (ExcepcionCapitalInsuficiente e) {
		
		} catch (ExcepcionNoExistePropietario e) {
		
		}
	}

}

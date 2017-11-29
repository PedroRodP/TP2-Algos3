package modelo;

import modelo.excepciones.*;

public class AlgoPoly {

	private GrupoJugadores grupo = new GrupoJugadores();
	private Tablero tablero = new Tablero();
	private Turnador turnador;
	private Jugador jugadorActual;
	
	
	public AlgoPoly() {
		
		turnador = new Turnador(grupo.getJugadores());
		tablero.agregarJugadores(grupo.getJugadores());
	}

	public void jugar() {
		
		//Cambio de turno
		this.jugadorActual = turnador.siguienteTurno();
		
		//Bloque comienzo de turno
		this.opcionPagarFianza();
		
		//Bloque pre-movida
		this.opcionVenderPropiedades();
		this.opcionEdificar();
		
		//Bloque jugada
		this.opcionMoverse();
	}		

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
	
	public void opcionMoverse() {
		
		Tirada tirada = new Tirada();
		
		try {
			//Entra aunque sea una vez al ciclo. Continua si salen dobles. Corta si salen 3 veces.
			while (tirada.salenDobles() && !tirada.salieron3Dobles()) {
				
				int numeroDados = tirada.arrojarDados();
				tablero.avanzar(jugadorActual, numeroDados);
				
			}
			
			if (tirada.salieron3Dobles()) { tablero.enviarALaCarcel(jugadorActual); }
			
		} catch (ExcepcionJugadorPreso e) {
			//El jugador no debe poder moverse
		
		} catch (ExcepcionCapitalInsuficiente e) {
			
			
		} catch (ExcepcionNoExistePropietario e) {
			e.printStackTrace();
		} catch (ExceptionArrojoDoblesTresVeces exceptionArrojoDoblesTresVeces) {
			exceptionArrojoDoblesTresVeces.printStackTrace();
		}
	}

}

package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class Retroceso implements Casillero {
	
	Tablero tablero;
	
	public Retroceso(Tablero referencia) {
		
		tablero = referencia;
	}

	private void retrocederDinamicamente(Jugador jugador, int valorDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		if (valorDados <= 6) {
			
			tablero.avanzar(jugador, (valorDados-2)*-1);
			
		} else if (valorDados > 6 && valorDados <= 10) {
			
			tablero.avanzar(jugador, (int) ((jugador.getCapital()) % valorDados)*(-1));
		
		} else {
			
			tablero.avanzar(jugador, (Math.abs(valorDados - jugador.cantidadDeInmuebles()))*-1);
			
		}	
	}

	@Override
	public void caer(Jugador jugador, int valorDados)
			throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		this.retrocederDinamicamente(jugador, valorDados);
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}


}

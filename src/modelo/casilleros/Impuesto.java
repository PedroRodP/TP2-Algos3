package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Impuesto implements Casillero {

	@Override
	public void caer(Jugador jugador) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		jugador.pagar(0.1 * jugador.getCapital());
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}

}

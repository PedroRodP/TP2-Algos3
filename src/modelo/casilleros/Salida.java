package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Salida implements Casillero {

	Casillero siguiente;
	
	@Override
	public void caer(Jugador jugador) throws ExcepcionJugadorPreso {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}

}

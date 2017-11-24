package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Policia implements Casillero {

	Tablero tablero;
	private Carcel miCarcel;
	
/*	public Policia(Tablero referencia) {
		
		tablero = referencia;
	}
	*/
	public void enviarACarcel(Jugador jugador) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		
		miCarcel.caer(jugador);;
	}
	
	@Override
	public void caer(Jugador jugador) throws ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso {
		
		this.enviarACarcel(jugador);
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
	public void setCarcel(Carcel unaCarcel){
		miCarcel = unaCarcel;
	}

}

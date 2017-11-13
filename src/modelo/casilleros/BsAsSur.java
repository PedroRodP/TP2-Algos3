package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.estados.Estado;
import modelo.excepciones.JugadorEstaPresoException;

public class BsAsSur extends Barrio implements Casillero {


	public BsAsSur(){
		
		precioTerreno = 20000;
		
	}

	
	@Override
	public Estado getDisponibilidad() {
		return (administrador.getDisponibilidad());
	}


	@Override
	public void hazLoTuyo(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException {
		// TODO Auto-generated method stub
		
	}
	
}
package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

public class SantaFe extends Barrio {

	
	public SantaFe(){
		
		precioTerreno = 15000;
		
	}

	public void venderTerreno() {
		
	}
	
	public double calcularReembolso() {
		
		double adicional = registro.getValorEdificios();
		double total = precioTerreno + adicional;
		
		return (total * 85 / 100);
	}
	
/*	public void cobrar(Jugador jugador) throws ExcepcionCapitalInsuficiente {
		
		registro.cobrar(jugador);
	}
*/	
	public void edificar() {
		
		registro.edificar();
	}

	@Override
	public void caer(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		registro.cobrar(unJugador);
		
	}
}

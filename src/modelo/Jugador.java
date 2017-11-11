package modelo;

import java.util.ListIterator;

import modelo.EstadosJugador.EstadoJugador;
import modelo.casilleros.Neuquen;
import modelo.casilleros.Transitable;

public class Jugador {

	private double capital;
	private Tablero tablero;
	private ListIterator<Transitable> iteradorDelTablero;
	private EstadoJugador estado;

	public Jugador() {
		capital = 100000;
	}
	
	public void cobrar(double monto) {
		capital -= monto;
	}
	
	public void acreditar(double monto) {
		capital += monto;
	}
	
	public double balance() {
		return capital;
	}

	public void setTablero(Tablero unTablero) {
		tablero = unTablero;
		iteradorDelTablero = unTablero.listIterator();
			
	}

	public Transitable getUbicacion(){
		// No existe un metodo para ver el elemento actual en los iterador, asi que lo implemente asi por ahora.
		// Esto va a pasar a ser otra clase, que implemente ListIterator
		
		//Tambien se me ocurrio pasar esto a la clase tablero. Que el jugador solo guarde una referencia al tablero
		// y el tablero sepa donde estan todos los jugadores. Entonces cuando el jugador quiere avanzar, le manda al tablero
		// la cantidad de pasos y este se encarga de moverlo.
		if(!iteradorDelTablero.hasNext()){
			iteradorDelTablero.previous();
			return iteradorDelTablero.next();
		}else{
			iteradorDelTablero.next();
			return iteradorDelTablero.previous();			
		}
	
	}

	public void avanzar(int cantidadDePasos){
		
		for (int i = 0;i<cantidadDePasos; i++){
			iteradorDelTablero.next();
		}
	}

}

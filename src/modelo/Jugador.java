package modelo;

import java.util.ListIterator;

import modelo.casilleros.Neuquen;
import modelo.casilleros.Transitable;

public class Jugador {

	private double capital;
	private Tablero tablero;
	
	
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
	}

	public Transitable getUbicacion(){
		return (tablero.getUbicacion(this));
	
	}

	public void avanzar(int cantidadDePasos){
		tablero.avanzar(this,cantidadDePasos);
	}

}

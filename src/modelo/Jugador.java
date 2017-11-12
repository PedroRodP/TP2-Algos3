package modelo;

import java.util.ListIterator;

import modelo.casilleros.Casillero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class Jugador {

	private double capital;
	private Tablero tablero;
	
	
	public Jugador() {
		capital = 100000;
	}
	
	public void cobrar(double monto) throws ExcepcionCapitalInsuficiente {
		if (monto > capital) { throw new ExcepcionCapitalInsuficiente(); }
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

	public Casillero getUbicacion(){
		return (tablero.getUbicacion(this));
	
	}

	public void avanzar(int cantidadDePasos){
		tablero.avanzar(this,cantidadDePasos);
	}

}

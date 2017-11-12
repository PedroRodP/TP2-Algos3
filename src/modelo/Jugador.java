package modelo;

import java.util.ListIterator;

import modelo.EstadosJugador.EstadoJugador;
import modelo.EstadosJugador.Jugando;
import modelo.EstadosJugador.Preso;
import modelo.casilleros.Neuquen;
import modelo.casilleros.Transitable;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class Jugador {

	private double capital;
	private Tablero tablero;
	private ListIterator<Transitable> iteradorDelTablero;
	private EstadoJugador estado;

	public Jugador() {
		capital = 100000;
		estado = new Jugando();
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

	public Transitable getUbicacion(){
		return (tablero.getUbicacion(this));
	
	}

	public void avanzar(int cantidadDePasos) throws JugadorEstaPresoException {
		estado.avanzar(cantidadDePasos,this,tablero);
	}

	public void irPreso() {
		estado = new Preso();
	}
}

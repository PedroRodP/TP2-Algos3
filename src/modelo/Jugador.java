package modelo;

import modelo.EstadosJugador.EstadoJugador;
import modelo.EstadosJugador.Jugando;
import modelo.EstadosJugador.Preso;
import modelo.casilleros.Casillero;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class Jugador {

	private double capital;
	private EstadoJugador estado;

	public Jugador() {
		capital = 100000;
		estado = new Jugando();
	}
	
	public void pagar(double monto) throws ExcepcionCapitalInsuficiente {
		if (monto > capital) { throw new ExcepcionCapitalInsuficiente(); }
		capital -= monto;
	}
	
	public void acreditar(double monto) {
		capital += monto;
	}
	
	public double balance() {
		return capital;
	}

	public void irPreso() {
		estado = new Preso();
	}

	public boolean tieneInmuebles() {
		return false;
	}

	public int avanzar(int cantidadDePasos) throws JugadorEstaPresoException {
		return estado.avanzar(cantidadDePasos);
	}

	public void pagarFianza() throws ExcepcionCapitalInsuficiente {
		estado.pagarFianza(this);
		
	}

	public boolean esLibre() {
		return estado.esLibre();
	}

	public void cambiarEstado(EstadoJugador estadoNuevo) {
		estado = estadoNuevo;
	}
}

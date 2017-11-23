package modelo;

import modelo.EstadosJugador.EstadoJugador;
import modelo.EstadosJugador.Jugando;
import modelo.EstadosJugador.Preso;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.*;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class Jugador implements Propietario {

	private double capital;
	private EstadoJugador estado;
	private Casillero posicion;
	private int cantidadDeInmuebles;

	public Jugador() {
		capital = 100000;
		estado = new Jugando();
		cantidadDeInmuebles = 0;
	}

	@Override
	public void pagar(double monto) throws ExcepcionCapitalInsuficiente {
		if (monto > capital) { throw new ExcepcionCapitalInsuficiente(); }
		capital -= monto;
	}
	
	public void acreditar(double monto) {
		capital += monto;
	}
	
	public double getCapital() {
		return capital;
	}

	public void avanzar(Casillero casillero) throws ExcepcionJugadorPreso {
		
		Casillero nuevaPosicion = estado.avanzar(casillero);
		
		this.actualizarPosicion(nuevaPosicion);
	}

	private void actualizarPosicion(Casillero nuevaPosicion) {
		
		posicion = nuevaPosicion;
	}
	
	public Casillero getPosicion() {
		return posicion;
	}

	public void cumplirCondena() throws ExcepcionJugadorYaEstaJugando {
		estado = estado.siguienteEstado();
	}

	public void irPreso(Carcel carcel) {
		this.actualizarPosicion(carcel);
		estado = new Preso();
	}
	
	public void recobrarLibertad() {
		estado = new Jugando();
	}

	public void pagarFianza() 
			throws ExcepcionPagarFianzaNoCorresponde, ExcepcionCapitalInsuficiente {
		
		try {
			Carcel carcel = (Carcel) posicion;
			estado.pagarFianza(this, carcel);
			
		} catch (ClassCastException e) {
			throw new ExcepcionPagarFianzaNoCorresponde();
		}
	}
	
	public int cantidadDeInmuebles(){
		
		return cantidadDeInmuebles;
	}
}

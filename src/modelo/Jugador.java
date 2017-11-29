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

	//TODO las dos pposiciones seran componentes atributos de la clase posicion
	private Casillero posicion;
	private int posicionNumerica;

	private int cantidadDeInmuebles;

	public Jugador() {
		capital = 100000;
		estado = new Jugando();
		cantidadDeInmuebles = 0;
		posicionNumerica = 0;
	}

	@Override
	public void acreditar(double unMonto) throws ExcepcionNoExistePropietario, ExcepcionCapitalInsuficiente {
		capital += unMonto;
	}

	@Override
	public void recibirPagoDe(Jugador unJugador, double unMonto) throws ExcepcionNoExistePropietario, ExcepcionCapitalInsuficiente {
		unJugador.pagar(unMonto);
		this.acreditar(unMonto);
	}

	@Override
	public void pagar(double monto) throws ExcepcionCapitalInsuficiente {
		if (monto > capital) { throw new ExcepcionCapitalInsuficiente(); }
		capital -= monto;
	}

	public double getCapital() {
		return capital;
	}

	public void avanzar(Casillero casillero) throws ExcepcionJugadorPreso {
		
		Casillero nuevaPosicion = estado.avanzar(casillero);
		
		this.actualizarPosicion(nuevaPosicion);
	}

	public void avanzar(int cantidadPasos) throws ExcepcionJugadorPreso {
		//TODO avanzar hasta el casillero que corresponda, lo decide la Posicion(Class) y segun EstadoJugador.
		posicionNumerica = cantidadPasos;
	}

	private void actualizarPosicion(Casillero nuevaPosicion) {
		
		posicion = nuevaPosicion;
	}
	
	public Casillero getPosicion() {
		return posicion;
	}

	public int getPosicionNumerica() {
		//TODO esto debe resolverse desde la clase Posicion
		//Tal vez esta deba ser el verdadero getPosicion;
		return posicionNumerica;
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

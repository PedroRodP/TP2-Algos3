package modelo;

import modelo.EstadosJugador.EstadoJugador;
import modelo.EstadosJugador.Jugando;
import modelo.EstadosJugador.Preso;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.excepciones.*;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class Jugador {

	private double capital;
	private Tablero tablero;
	private EstadoJugador estado;
	//Por ahora queda como integer, porque lo necesito para los avances dinamicos
	//pero hay que pasarlo a una clase, no se si RegistroDeInmuebles era la que se penso para eso
	private int cantidadDeInmuebles = 0;

	public Jugador() {
		capital = 100000;
		estado = new Jugando();
	}
	
	public void pagar(double monto) throws ExcepcionCapitalInsuficiente {
		if (monto > capital) { throw new ExcepcionCapitalInsuficiente(); }
		capital -= monto;
		//De nuevo, es para las pruebas de avance dinamico
		cantidadDeInmuebles++;
	}
	
	public void acreditar(double monto) {
		capital += monto;
	}
	
	public double getCapital() {
		return capital;
	}

	public void irPreso() {
		estado = new Preso();
	}

	public Casillero getUbicacion() {
		return (tablero.getUbicacion(this));
	}
	
	public boolean tieneInmuebles() {
		return false;
	}

	public int avanzar(int cantidadDePasos) throws JugadorEstaPresoException {
		return estado.avanzar(cantidadDePasos);
	}

	public boolean esLibre() {
		return estado.esLibre();
	}

	public void cambiarEstado(EstadoJugador estadoNuevo) {
		estado = estadoNuevo;
	}

	public void siguienteEstado() throws JugadorJugandoNoTieneMasEstados {
		estado = estado.siguienteEstado();
	}

	public void recobrarLibertad() {
		estado = new Jugando();
	}

	public void pagarFianza(Carcel laCarcel) throws ImposiblePagarFianzaPrimerTurnoExeption, JugadorNoEstaPreso, ExcepcionCapitalInsuficiente {
		estado.pagarFianza(this, laCarcel);
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public int cantidadDeInmuebles(){
		
		return cantidadDeInmuebles;
	}
}

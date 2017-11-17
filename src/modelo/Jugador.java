package modelo;

import modelo.EstadosJugador.EstadoJugador;
import modelo.EstadosJugador.Jugando;
import modelo.EstadosJugador.Preso;
import modelo.casilleros.Carcel;
import modelo.excepciones.*;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class Jugador {

	private double capital;
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

	public int avanzar(int cantidadDePasos) throws ExcepcionJugadorPreso {
		return estado.avanzar(cantidadDePasos);
	}

	public void siguienteEstado() throws ExcepcionJugadorYaEstaJugando {
		estado = estado.siguienteEstado();
	}

	public void irPreso() {
		estado = new Preso();
	}
	
	public void recobrarLibertad() {
		estado = new Jugando();
	}

	public void pagarFianza(Carcel laCarcel) 
			throws ExcepcionPagarFianzaNoCorresponde, ExcepcionCapitalInsuficiente {
		
		estado.pagarFianza(this, laCarcel);
	}
	
	public int cantidadDeInmuebles(){
		
		return cantidadDeInmuebles;
	}
}

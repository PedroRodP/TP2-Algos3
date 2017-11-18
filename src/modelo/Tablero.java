package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

import modelo.casilleros.Avance;
import modelo.casilleros.Aysa;
import modelo.casilleros.BsAsNorte;
import modelo.casilleros.BsAsSur;
import modelo.casilleros.Carcel;
import modelo.casilleros.CordobaNorte;
import modelo.casilleros.CordobaSur;
import modelo.casilleros.Edesur;
import modelo.casilleros.Impuesto;
import modelo.casilleros.Neuquen;
import modelo.casilleros.Policia;
import modelo.casilleros.Posicion;
import modelo.casilleros.Quini6;
import modelo.casilleros.Retroceso;
import modelo.casilleros.Salida;
import modelo.casilleros.SaltaNorte;
import modelo.casilleros.SaltaSur;
import modelo.casilleros.SantaFe;
import modelo.casilleros.Subte;
import modelo.casilleros.Casillero;
import modelo.casilleros.Tren;
import modelo.casilleros.Tucuman;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorNoRegistrado;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Tablero {
	
	private LinkedList<Casillero> casilleros = new LinkedList<>();
	private Posicion posiciones = new Posicion();
	
	public Tablero() {
		
		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		casilleros.add(new BsAsSur());
		casilleros.add(new Edesur());
		casilleros.add(new BsAsNorte());
		casilleros.add(new Carcel());
		casilleros.add(new CordobaSur());
		casilleros.add(new Avance());
		casilleros.add(new Subte());
		casilleros.add(new CordobaNorte());
		casilleros.add(new Impuesto());
		casilleros.add(new SantaFe());
		casilleros.add(new Aysa());
		casilleros.add(new SaltaNorte());
		casilleros.add(new SaltaSur());
		casilleros.add(new Policia());
		casilleros.add(new Tren());
		casilleros.add(new Neuquen());
		casilleros.add(new Retroceso());
		casilleros.add(new Tucuman());
	}

	public void agregarJugadores(ArrayList<Jugador> listaJugadores) {
		
		//Registra a los jugadores poniendolos en la posicion de salida
		Casillero salida = casilleros.getFirst();
		
		for (Jugador jugador: listaJugadores) {
			posiciones.setPosicion(jugador, salida);
		}
	}

	public Casillero getUbicacion(Jugador unJugador) {
		return (posiciones.getPosicion(unJugador));
	}
	
	public void avanzar(Jugador jugador, int valorDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionJugadorNoRegistrado {
		
		if (!posiciones.estaRegistrado(jugador)) { throw new ExcepcionJugadorNoRegistrado(); }
		
		int numeroDePosicion = this.getNumeroDePosicion(jugador);
		//Actualizar numero de posicion
		numeroDePosicion += valorDados;
		
		Casillero nuevaPosicion = this.calcularNuevaPosicion(numeroDePosicion);
		
		//Guardar posicion nueva
		posiciones.setPosicion(jugador, nuevaPosicion);
		
		//Comprueba avance posible del jugador
		jugador.avanzar(nuevaPosicion);
		
		nuevaPosicion.caer(jugador, this, valorDados);
	}

	private int getNumeroDePosicion(Jugador jugador) {
		
		Casillero casilleroActual = this.getUbicacion(jugador);
		int numeroDePosicion = casilleros.indexOf(casilleroActual);
		
		return numeroDePosicion;
	}

	private Casillero calcularNuevaPosicion(int numeroDePosicion) {
		
		//Método para volver al inicio de la lista cuando se termina
		if (numeroDePosicion >= casilleros.size())
			numeroDePosicion -= casilleros.size();
		
		if (numeroDePosicion < 0)
			numeroDePosicion += casilleros.size();
				
		return casilleros.get(numeroDePosicion);
	}

	public Carcel getCarcel() {

		return (Carcel) casilleros.get(5);
	}
}

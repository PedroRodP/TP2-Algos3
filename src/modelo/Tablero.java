package modelo;

import java.util.HashMap;
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
import modelo.excepciones.JugadorEstaPresoException;

public class Tablero {
	
	private LinkedList<Casillero> casilleros = new LinkedList<>();
	private	HashMap<Jugador,Casillero> jugadores;
	
	public Tablero() {
		
		this.agregarCasillero(new Salida());
		this.agregarCasillero(new Quini6());
		this.agregarCasillero(new BsAsSur());
		this.agregarCasillero(new Edesur());
		this.agregarCasillero(new BsAsNorte());
		this.agregarCasillero(new Carcel());
		this.agregarCasillero(new CordobaSur());
		this.agregarCasillero(new Avance());
		this.agregarCasillero(new Subte());
		this.agregarCasillero(new CordobaNorte());
		this.agregarCasillero(new Impuesto());
		this.agregarCasillero(new SantaFe());
		this.agregarCasillero(new Aysa());
		this.agregarCasillero(new SaltaNorte());
		this.agregarCasillero(new SaltaSur());
		this.agregarCasillero(new Policia());
		this.agregarCasillero(new Tren());
		this.agregarCasillero(new Neuquen());
		this.agregarCasillero(new Retroceso());
		this.agregarCasillero(new Tucuman());
		
		jugadores = new HashMap<Jugador,Casillero>(); //Posicion de jugador. Podria implementarse clase Posicion
	}
	
	private void agregarCasillero(Casillero casillero) {
		casilleros.add(casillero);
	}

	public void setJugador(Jugador unJugador) {
		
		jugadores.put(unJugador, casilleros.getFirst());
			
	}

	public Casillero getUbicacion(Jugador unJugador) {
		return (jugadores.get(unJugador));
	}
	

	public Casillero avanzar(Jugador unJugador, int cantidadDePasos) throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		
		int posicionActual = casilleros.indexOf(jugadores.get(unJugador));
		posicionActual += unJugador.avanzar(cantidadDePasos);
		
		if(posicionActual >= casilleros.size())
			posicionActual -= casilleros.size();
		
		if(posicionActual<0)
			posicionActual += casilleros.size();
		jugadores.replace(unJugador, casilleros.get(posicionActual));
		
		if (cantidadDePasos != 0)
			(casilleros.get(posicionActual)).caer(unJugador, this, cantidadDePasos);
		
		return this.getUbicacion(unJugador);
	}

	public Carcel getCarcel() {

		return (Carcel) casilleros.get(5);
	}
}

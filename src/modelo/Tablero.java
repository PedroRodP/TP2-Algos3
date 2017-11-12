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
import modelo.casilleros.Transitable;
import modelo.casilleros.Tren;
import modelo.casilleros.Tucuman;

public class Tablero extends LinkedList<Transitable> {
	
	private	HashMap<Jugador,Transitable> jugadores;
	
	public Tablero() {
		
		this.add(new Salida());
		this.add(new Quini6());
		this.add(new BsAsSur());
		this.add(new Edesur());
		this.add(new BsAsNorte());
		this.add(new Carcel());
		this.add(new CordobaSur());
		this.add(new Avance());
		this.add(new Subte());
		this.add(new CordobaNorte());
		this.add(new Impuesto());
		this.add(new SantaFe());
		this.add(new Aysa());
		this.add(new SaltaNorte());
		this.add(new SaltaSur());
		this.add(new Policia());
		this.add(new Tren());
		this.add(new Neuquen());
		this.add(new Retroceso());
		this.add(new Tucuman());
		jugadores = new HashMap<Jugador,Transitable>();
	}
	
	public void setJugador(Jugador unJugador) {
		
		jugadores.put(unJugador, this.getFirst());
		System.out.println("asd");
			
	}

	public Transitable getUbicacion(Jugador unJugador) {
		return (jugadores.get(unJugador));
	}
	

	public void avanzar(Jugador unJugador, int cantidadDePasos) {
		
		int posicionActual = this.indexOf(jugadores.get(unJugador));
		posicionActual += cantidadDePasos;
		if(posicionActual >= this.size())
			posicionActual -= this.size();
		jugadores.replace(unJugador, this.get(posicionActual));
		
	}
}

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

@SuppressWarnings("serial")
public class Tablero extends LinkedList<Casillero> {
	
	private	HashMap<Jugador,Casillero> jugadores;
	
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
		jugadores = new HashMap<Jugador,Casillero>();
	}
	
	public void setJugador(Jugador unJugador) {
		
		jugadores.put(unJugador, this.getFirst());
			
	}

	public Casillero getUbicacion(Jugador unJugador) {
		return (jugadores.get(unJugador));
	}
	

	public Casillero avanzar(Jugador unJugador, int cantidadDePasos) throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		
		int posicionActual = this.indexOf(jugadores.get(unJugador));
		posicionActual += unJugador.avanzar(cantidadDePasos);
		if(posicionActual >= this.size())
			posicionActual -= this.size();
		if(posicionActual<0)
			posicionActual +=this.size();
		jugadores.replace(unJugador, this.get(posicionActual));
		if (cantidadDePasos != 0)
			(this.get(posicionActual)).hazLoTuyo(unJugador, this, cantidadDePasos);
		return this.getUbicacion(unJugador);
	}

	public Carcel getCarcel() {

		return (Carcel) this.get(5);
	}
}

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
import modelo.excepciones.JugadorEstaPresoException;

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
		
		for (Jugador jugador: listaJugadores) {
			posiciones.setCasillero(jugador, casilleros.getFirst());
		}
	}

	public Casillero getUbicacion(Jugador unJugador) {
		return (posiciones.getCasillero(unJugador));
	}
	

	public Casillero avanzar(Jugador unJugador, int cantidadDePasos) throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		
		int posicionActual = casilleros.indexOf(posiciones.getCasillero(unJugador));
		posicionActual += unJugador.avanzar(cantidadDePasos);
		
		if(posicionActual >= casilleros.size())
			posicionActual -= casilleros.size();
		
		if(posicionActual<0)
			posicionActual += casilleros.size();
		posiciones.setCasillero(unJugador, casilleros.get(posicionActual));
		
		if (cantidadDePasos != 0)
			(casilleros.get(posicionActual)).caer(unJugador, this, cantidadDePasos);
		
		return posiciones.getCasillero(unJugador);
	}

	public Carcel getCarcel() {

		return (Carcel) casilleros.get(5);
	}
}

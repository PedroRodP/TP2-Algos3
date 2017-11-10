package modelo;

import java.util.List;

import modelo.casilleros.Avance;
import modelo.casilleros.Aysa;
import modelo.casilleros.BsAsNorte;
import modelo.casilleros.BsAsSur;
import modelo.casilleros.Carcel;
import modelo.casilleros.Transitable;
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
import modelo.casilleros.Tren;
import modelo.casilleros.Tucuman;

public class AlgoPoly {

	private Tablero tablero = new Tablero();
	private Jugador jugadorRojo;
	private Jugador jugadorAmarillo;
	private Jugador jugadorAzul;
	
	public AlgoPoly() {
		
		this.prepararTablero();
		jugadorRojo = new Jugador();
		jugadorAmarillo = new Jugador();
		jugadorAzul = new Jugador();
	}
	
	private void prepararTablero() {
		
		tablero.agregarCasillero(new Salida());
		tablero.agregarCasillero(new Quini6());
		tablero.agregarCasillero(new BsAsSur());
		tablero.agregarCasillero(new Edesur());
		tablero.agregarCasillero(new BsAsNorte());
		tablero.agregarCasillero(new Carcel());
		tablero.agregarCasillero(new CordobaSur());
		tablero.agregarCasillero(new Avance());
		tablero.agregarCasillero(new Subte());
		tablero.agregarCasillero(new CordobaNorte());
		tablero.agregarCasillero(new Impuesto());
		tablero.agregarCasillero(new SantaFe());
		tablero.agregarCasillero(new Aysa());
		tablero.agregarCasillero(new SaltaNorte());
		tablero.agregarCasillero(new SaltaSur());
		tablero.agregarCasillero(new Policia());
		tablero.agregarCasillero(new Tren());
		tablero.agregarCasillero(new Neuquen());
		tablero.agregarCasillero(new Retroceso());
		tablero.agregarCasillero(new Tucuman());
	}
	
}

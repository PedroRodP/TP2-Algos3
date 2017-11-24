package modelo.casilleros;

import modelo.Jugador;
import modelo.Pasada;
import modelo.PrimeraPasada;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;

import java.util.HashMap;

public class Quini6 implements Casillero {

	private HashMap<Jugador, Pasada> registroDeGanadores = new HashMap<Jugador, Pasada>();
	
	public Quini6() {
		//Para evitar problemas de basura y excepciones NullPointer
		registroDeGanadores.clear();
	}
	
	public void premiar(Jugador jugador) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Pasada pasada;
		
		if (registroDeGanadores.containsKey(jugador)) {
			
			pasada = registroDeGanadores.get(jugador);
		}
		else {
			
			pasada = new PrimeraPasada();
			registroDeGanadores.put(jugador, pasada);
		}
		
		pasada.otorgarPremio(jugador);

		this.registrarPasada(jugador);
	}
	
	private void registrarPasada(Jugador jugador) {
		
		Pasada pasada = registroDeGanadores.get(jugador);
		Pasada nuevaPasada = pasada.incrementar();
		registroDeGanadores.replace(jugador, nuevaPasada);
	}

	@Override
	public void caer(Jugador jugador)
			throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		this.premiar(jugador);
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}

}

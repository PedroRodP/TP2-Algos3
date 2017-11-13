package modelo.casilleros;

import modelo.Jugador;
import modelo.Pasada;
import modelo.PrimeraPasada;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

import java.util.HashMap;

public class Quini6 implements Casillero {

	private HashMap<Jugador, Pasada> registroDeGanadores = new HashMap<Jugador, Pasada>();
	
	public Quini6() {
		//Para evitar problemas de basura y excepciones NullPointer
		registroDeGanadores.clear();
	}
	
	//Dejo el metodo premiar para no complejizar las pruebas del Quini6
	public void premiar(Jugador jugador) {
		
		if (registroDeGanadores.containsKey(jugador)) {
			
			Pasada pasada = registroDeGanadores.get(jugador);
			pasada.otorgarPremio(jugador);
		}
		else {
			
			Pasada pasada = new PrimeraPasada();
			registroDeGanadores.put(jugador, pasada);
			pasada.otorgarPremio(jugador);
		}
		
		//se otorga el premio dentro del if ya que no reconoce "pasada" afuera
		this.registrarPasada(jugador);
	}
	
	public void registrarPasada(Jugador jugador) {
		
		Pasada pasada = registroDeGanadores.get(jugador);
		Pasada nuevaPasada = pasada.incrementar();
		registroDeGanadores.replace(jugador, nuevaPasada);
	}

	@Override
	public void hazLoTuyo(Jugador unJugador, Tablero unTablero, int velorDeLosDados)
			throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		this.premiar(unJugador);
		
	}
	
}

package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Disponible;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.NoDisponible;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class SantaFe {

	private Estado disponibilidad;
	private RegistroDeInmuebles registro;
	private Jugador duenio;
	
	private final double precioTerreno = 15000;
	
	public SantaFe() {
		this.setDisponible();
	}
	
	private void setDisponible() {
		disponibilidad = new Disponible();
		duenio = null;
	}
	
	private void setNoDisponible(Jugador jugador) {
		disponibilidad = new NoDisponible();
		duenio = jugador;
	}
	
	public void comprarTerreno(Jugador jugador) {
		
		try {
			disponibilidad.comprar(jugador, precioTerreno);
			this.setNoDisponible(jugador);
		}
		catch (ExcepcionTerrenoOcupado excepcion) {
		}
	
	}
	
	public void cobrar(Jugador jugador) {
		
		registro.cobrar(jugador);
	}
	
	public void edificar() {
		
		registro.edificar();
	}
}

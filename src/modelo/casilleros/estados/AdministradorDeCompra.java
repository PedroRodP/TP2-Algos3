package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class AdministradorDeCompra {
	
	private Estado disponibilidad;
	private Jugador duenio;
	
	public AdministradorDeCompra() {
		this.setDisponible();
	}

	public void comprar(Jugador jugador, double precio) throws ExcepcionTerrenoOcupado {
		
		disponibilidad.comprar(jugador, precio);
		this.setNoDisponible(jugador);
	}
	
	private void setDisponible() {
		
		disponibilidad = new Disponible();
		duenio = null;
	}
	
	private void setNoDisponible(Jugador jugador) {
		
		disponibilidad = new NoDisponible();
		duenio = jugador;
	}
	
	public Jugador getDuenio() {
		return duenio;
	}
	
	public Estado getDisponibilidad() {
		return disponibilidad;
	}
}

package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class AdministradorDeCompra {
	
	private Estado disponibilidad;
	private Propietario duenio;
	
	public AdministradorDeCompra() {
		this.setDisponible();
	}
	
	public void comprarTerreno(Jugador jugador, double precio) throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		disponibilidad.comprarTerreno(jugador, precio);
		this.setNoDisponible(jugador);
	}
	
	public void venderTerreno(Jugador jugador, double precio) {
		//A implementar
	}

	private void setDisponible() {
		
		disponibilidad = new Disponible();
		duenio = new SinPropietario();
	}
	
	private void setNoDisponible(Jugador jugador) {
		
		disponibilidad = new NoDisponible();
		duenio = jugador;
	}
	
	public Propietario getDuenio() {
		return duenio;
	}

}

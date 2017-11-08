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
	
	public void comprarTerreno(Jugador jugador) throws ExcepcionTerrenoOcupado {
		
		disponibilidad.comprar(jugador, precioTerreno);
		this.setNoDisponible(jugador);
	}
	
	public void venderTerreno() {
		
		duenio.acreditar(this.calcularReembolso());
		this.setDisponible();
	}
	
	public double calcularReembolso() {
		
		double adicional = registro.getValorEdificios();
		double total = precioTerreno + adicional;
		
		return (total * 85 / 100);
	}
	
	public void cobrar(Jugador jugador) {
		
		registro.cobrar(jugador);
	}
	
	public void edificar() {
		
		registro.edificar();
	}
}

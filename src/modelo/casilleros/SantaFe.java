package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class SantaFe extends Casillero implements Barrio {

	private AdministradorDeCompra administrador = new AdministradorDeCompra();
	private RegistroDeInmuebles registro = new RegistroDeInmuebles();
	private final double precioTerreno = 15000;
	
	@Override
	public double precio() {
		return precioTerreno;
	}
	
	@Override
	public void comprarTerreno(Jugador jugador) throws ExcepcionTerrenoOcupado {
		
		administrador.comprar(jugador, precioTerreno);
	}
	
	@Override
	public Estado getDisponibilidad() {
		return (administrador.getDisponibilidad());
	}
	
	public void venderTerreno() {
		
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

package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public abstract class Barrio {
	
	protected AdministradorDeCompra administrador = new AdministradorDeCompra();
	protected RegistroDeInmuebles registro = new RegistroDeInmuebles();
	protected double precioTerreno;
	
	public void comprarTerreno(Jugador jugador) throws ExcepcionTerrenoOcupado{
		administrador.comprar(jugador, precioTerreno);
	}
	
	public double precio(){
		return precioTerreno;
	}
	
	public Estado getDisponibilidad(){
		return (administrador.getDisponibilidad());
	}

	public long getPropietario() {
		return administrador.getDuenio();
	}
}

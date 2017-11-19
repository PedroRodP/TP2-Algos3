package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public abstract class Barrio implements Casillero {
	
	protected AdministradorDeCompra administrador = new AdministradorDeCompra();
	protected RegistroDeInmuebles registro = new RegistroDeInmuebles();
	protected double precioTerreno;
	
	@Override
	public void caer(Jugador jugador, int valorDados) throws ExcepcionCapitalInsuficiente {
		
		try {
			administrador.comprarTerreno(jugador, precioTerreno);
			
		} catch (ExcepcionTerrenoOcupado e) {
			
			registro.alquilar(jugador);
		}
	}
	
	public double getPrecio(){
		return precioTerreno;
	}

	public Propietario getPropietario() {
		return administrador.getDuenio();
	}
}

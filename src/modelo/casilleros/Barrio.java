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
			this.serComprado(jugador);
			
		} catch (ExcepcionTerrenoOcupado e) {
			
			this.serAlquilado(jugador);
		}
	}
	
	public void serComprado(Jugador jugador) throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		administrador.comprarTerreno(jugador, precioTerreno);
	}
	
	public void serVendido(Jugador jugador) {
		
		administrador.venderTerreno(jugador, precioTerreno);
	}
	
	public void serAlquilado(Jugador jugador) throws ExcepcionCapitalInsuficiente {
		
		double monto = registro.calcularAlquiler(jugador);
		jugador.pagar(monto);
	}
	
	public void edificar() {
		
		registro.edificar();
	}
	
	public double getPrecio(){
		return precioTerreno;
	}

	public Propietario getPropietario() {
		return administrador.getDuenio();
	}

}

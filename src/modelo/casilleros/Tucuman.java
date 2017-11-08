package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class Tucuman extends Casillero implements Barrio {

	private AdministradorDeCompra administrador = new AdministradorDeCompra();
	private RegistroDeInmuebles registro = new RegistroDeInmuebles();
	private final double precioTerreno = 25000;
	
	@Override
	public double precio() {
		return precioTerreno;
	}
	
	@Override
	public void comprarTerreno(Jugador jugador) throws ExcepcionTerrenoOcupado {
		
		administrador.comprar(jugador, precioTerreno);
	}
}

package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class BsAsSur extends Barrio implements Transitable {


	public BsAsSur(){
		
		precioTerreno = 20000;
		
	}

	
	@Override
	public Estado getDisponibilidad() {
		return (administrador.getDisponibilidad());
	}
	
}
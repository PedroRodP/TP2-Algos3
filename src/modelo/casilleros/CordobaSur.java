package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class CordobaSur extends Barrio implements Transitable {

	public CordobaSur(){
		
		precioTerreno = 18000;
		
	}

	
}

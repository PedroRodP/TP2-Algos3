package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class SaltaSur extends Barrio implements Transitable {

	
	public SaltaSur(){
		
		precioTerreno = 23000;
		
	}


}

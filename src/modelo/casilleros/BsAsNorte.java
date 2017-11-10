package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class BsAsNorte extends Barrio implements Transitable {

	public BsAsNorte(){
		
		precioTerreno = 25000;
	
	}

}

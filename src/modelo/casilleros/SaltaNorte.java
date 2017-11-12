package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class SaltaNorte extends Barrio implements Casillero {


	public SaltaNorte(){
		
		precioTerreno = 23000;
		
	}

	
}

package modelo.casilleros;

import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;

public class SaltaSur extends Barrio {

	public SaltaSur(){
		
		precioTerreno = 23000;
		alquilerDefault = 2000;
		precioPrimeraCasa = 3250;
		precioSegundaCasa = 3850;
		precioHotel = 5500;
		registro = new RegistroDeInmuebles(alquilerDefault);
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

package modelo.casilleros;

import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;

public class BsAsNorte extends Barrio {

	public BsAsNorte(){
		
		precioTerreno = 25000;
		alquilerDefault = 2500;
		precioPrimeraCasa = 3500;
		precioSegundaCasa = 4000;
		precioHotel = 6000;
		registro = new RegistroDeInmuebles(alquilerDefault);
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

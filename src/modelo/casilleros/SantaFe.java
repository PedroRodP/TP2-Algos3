package modelo.casilleros;

import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;

public class SantaFe extends Barrio {

	public SantaFe(){
		
		precioTerreno = 15000;
		alquilerDefault = 1500;
		precioPrimeraCasa = 3500;
		precioSegundaCasa = 3500;
		precioHotel = 3500;
		registro = new RegistroDeInmuebles(alquilerDefault);
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

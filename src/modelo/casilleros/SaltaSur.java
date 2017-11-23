package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class SaltaSur extends Barrio {

	public SaltaSur(){
		
		precioTerreno = 23000;
		alquilerDefault = 2000;
		precioPrimeraCasa = 3250;
		precioSegundaCasa = 3850;
		precioHotel = 5500;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

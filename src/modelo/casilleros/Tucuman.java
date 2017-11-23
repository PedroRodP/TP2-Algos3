package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class Tucuman extends Barrio {

	public Tucuman(){
		
		precioTerreno = 25000;
		alquilerDefault = 2500;
		precioPrimeraCasa = 4500;
		precioSegundaCasa = 4500;
		precioHotel = 4500;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

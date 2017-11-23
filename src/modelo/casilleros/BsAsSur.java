package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class BsAsSur extends Barrio {


	public BsAsSur(){
		
		precioTerreno = 20000;
		alquilerDefault = 2000;
		precioPrimeraCasa = 3000;
		precioSegundaCasa = 3500;
		precioHotel = 5000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}
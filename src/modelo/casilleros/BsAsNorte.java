package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class BsAsNorte extends Barrio {

	public BsAsNorte(){
		
		precioTerreno = 25000;
		alquilerDefault = 2500;
		precioPrimeraCasa = 3500;
		precioSegundaCasa = 4000;
		precioHotel = 6000;
	
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

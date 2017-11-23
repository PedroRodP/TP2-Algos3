package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class CordobaSur extends Barrio {

	public CordobaSur(){
		
		precioTerreno = 18000;
		alquilerDefault = 1000;
		precioPrimeraCasa = 1500;
		precioSegundaCasa = 2500;
		precioHotel = 3000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class CordobaNorte extends Barrio {

	public CordobaNorte(){
		
		precioTerreno = 20000;
		alquilerDefault = 1300;
		precioPrimeraCasa = 1800;
		precioSegundaCasa = 2900;
		precioHotel = 3500;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

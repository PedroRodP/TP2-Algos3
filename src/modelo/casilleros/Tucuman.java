package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class Tucuman extends Barrio {

	public Tucuman(){
		
		precioTerreno = 25000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class SaltaSur extends Barrio {

	public SaltaSur(){
		
		precioTerreno = 23000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

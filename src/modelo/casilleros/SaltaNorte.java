package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class SaltaNorte extends Barrio {

	public SaltaNorte(){
		
		precioTerreno = 23000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

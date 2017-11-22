package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class CordobaSur extends Barrio {

	public CordobaSur(){
		
		precioTerreno = 18000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class BsAsSur extends Barrio {


	public BsAsSur(){
		
		precioTerreno = 20000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}
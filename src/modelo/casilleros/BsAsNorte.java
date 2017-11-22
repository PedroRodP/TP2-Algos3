package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class BsAsNorte extends Barrio {

	public BsAsNorte(){
		
		precioTerreno = 25000;
	
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

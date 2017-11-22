package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class CordobaNorte extends Barrio {

	public CordobaNorte(){
		
		precioTerreno = 20000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}
